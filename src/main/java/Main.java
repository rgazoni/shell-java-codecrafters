import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        CommandRegistry command = new CommandRegistry();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            String[] parts;
            String fileDesc = null;

            boolean hasFileRedirection = input.contains(" 1> ") || input.contains(" > ");
            if (hasFileRedirection) {
                String pattern = input.contains(" 1> ") ? " 1> " : " > ";
                String[] sp = input.split(pattern);

                parts = sp[0].trim().split(" ");
                fileDesc =  sp[1].trim();
            } else {
                parts = input.split(" ");
            }

            CommandResult result = command.executeCommand(parts);
            if (result == null) {
                return;
            }

            if(result.getType() == Status.ERROR) {
                System.out.println(result.getStderr());
            } else if(result.getType() == Status.SUCCESS) {
                System.out.println(result.getStdout());
            }

            if (hasFileRedirection) {
                try {
                    FileWriter myWriter = new FileWriter(fileDesc);
                    myWriter.write(result.getStdout());
                    myWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
