
public class InputParser {
    private boolean redirectionOutput = false;
    private boolean redirectionErr = false;
    private String fileRedirection = null;
    private String[] commands = null;

    public InputParser(String input) {
       this.init(input);
    }

    private void init(String input) {
        this.redirectionOutput = input.contains(" 1> ") || input.contains(" > ");
        this.redirectionErr = input.contains(" 2> ");

        if (this.hasRedirection()) {
            String[] parts = input.split(" 1> | > | 2> ", 2);
            this.commands = parts[0].trim().split(" "); // Command part

            if (parts.length > 1) {
                this.fileRedirection = parts[1].trim(); // File part
            }
        } else {
            this.commands = input.split(" ");
        }
    }

    public boolean hasRedirection() {
        return redirectionOutput || redirectionErr;
    }

    public String[] getCommands() {
        return commands;
    }

    public ResultHandler getResultHandler() {
        return new ResultHandler(
                redirectionOutput,
                redirectionErr,
                fileRedirection
        );
    }

}
