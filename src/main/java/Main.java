import java.sql.Array;
import java.util.ArrayList;
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

            String[] parts = input.split(" ", 2);
            String cmd = parts[0];
            String[] arguments = parts.length > 1 ? parts[1].trim().split(" ") : new String[0];
            command.executeCommand(cmd, arguments);

        }

    }
}
