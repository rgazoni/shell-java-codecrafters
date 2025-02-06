import java.util.Arrays;
import java.io.File;

public class TypeCommand implements Command {
    private final CommandRegistry registry;
    private static final String PATH_SEPARATOR = ":";

    TypeCommand(CommandRegistry reg) {
        this.registry = reg;
    }

    private String searchExecutableCommands(String command) {
        String[] paths = System.getenv("PATH").split(PATH_SEPARATOR);
        for (String path : paths) {
            String foundCommandPath = findCommandInDirectory(path, command);
            if (foundCommandPath != null) {
                return foundCommandPath;
            }
        }
        return null;
    }

    private String findCommandInDirectory(String directoryPath, String command) {
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

    @Override
    public void process(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: type <command>");
            return;
        }
        String command = args[0];

        if (registry.getCommands().containsKey(command)) {
            System.out.println(command + " is a shell builtin");
            return;
        }

        String executableCommands = searchExecutableCommands(command);
        if (executableCommands != null) {
            System.out.println(command + " is " + executableCommands);
            return;
        }

        System.out.println(command + ": not found");
    }

    @Override
    public String getName() {
        return "type";
    }

}
