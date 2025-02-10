import java.io.File;

public class TypeCommand implements Command {
    private final CommandRegistry registry;

    TypeCommand(CommandRegistry reg) {
        this.registry = reg;
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

        ExecutablesFiles executables = new ExecutablesFiles();
        String executableCommands = executables.findCommandInPath(command);
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
