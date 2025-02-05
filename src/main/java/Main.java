import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");

            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            ShellInterpreter interpreter = new ShellInterpreter();

            String[] parts = input.split(" ", 2);
            String command = parts[0];
            String[] arguments = parts.length > 1 ? parts[1].trim().split(" ") : new String[0];

            interpreter.interpretCommand(command, arguments);

        }

    }
}
