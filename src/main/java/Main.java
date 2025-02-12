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

            InputParser inputParser = new InputParser(input);

            CommandResult result = command.executeCommand(inputParser.getCommands());
            if (result == null) {
                return;
            }

            ResultHandler resultHandler = inputParser.getResultHandler();
            resultHandler.process(result);
        }
    }
}
