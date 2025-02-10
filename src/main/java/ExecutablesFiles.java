import java.io.File;

public class ExecutablesFiles {
    private static final String PATH_SEPARATOR = ":";

    public String findCommandInPath(String command) {
        String[] paths = System.getenv("PATH").split(PATH_SEPARATOR);
        for (String path : paths) {
            String foundCommandPath = findCommandInDirectory(path, command);
            if (foundCommandPath != null) {
                return foundCommandPath;
            }
        }
        return null;
    }

    public String findCommandInDirectory(String directoryPath, String command) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if (files == null) {
            return null;
        }
        for (File file : files) {
            if (!file.isDirectory() && file.getName().equals(command)) {
                return file.getAbsolutePath();
            }
        }
        return null;
    }

    public void executeProgram(String directoryPath, String[] args) {
        try {
            String[] command = new String[args.length + 1];
            command[0] = directoryPath;
            System.arraycopy(args, 0, command, 1, args.length);

            ProcessBuilder processBuilder = new ProcessBuilder(command);
            // This line redirects the error stream (stderr) to the standard output stream (stdout).
            // This means that both normal output and error messages will be combined and can be read from the same input stream.
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            // This makes reader to be closed after try block
            try (var reader = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            // If you want to find out the exit code from the execution
            // int exitCode = process.waitFor();
            // System.out.println("Process exited with code: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
