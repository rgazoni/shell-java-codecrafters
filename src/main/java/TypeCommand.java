import java.io.File;

public class TypeCommand implements Command {
    private final CommandRegistry registry;

    TypeCommand(CommandRegistry reg) {
        this.registry = reg;
    }

    @Override
    public CommandResult process(String[] args) {
        CommandResult result = new CommandResult();

        if (args.length == 0) {
            result.setStderr("Usage: type <command>");
            return result;
        }
        String command = args[0];

        if (registry.getCommands().containsKey(command)) {
            result.setStdout(command + " is a shell builtin");
            return result;
        }

        ExecutablesFiles executables = new ExecutablesFiles();
        String executableCommands = executables.findCommandInPath(command);
        if (executableCommands != null) {
            result.setStdout(command + " is " + executableCommands);
            return result;
        }

        result.setStderr(command + ": not found");
        return result;
    }

    @Override
    public String getName() {
        return "type";
    }

}
