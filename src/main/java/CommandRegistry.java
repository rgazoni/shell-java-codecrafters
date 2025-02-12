import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class CommandRegistry {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandRegistry() {
        ServiceLoader<Command> loader = ServiceLoader.load(Command.class);
        for (Command command : loader) {
            commands.put(command.getName(), command);
        }
        // Add the "type" command manually, as it depends on the registry
        commands.put("type", new TypeCommand(this));
    }

    public CommandResult executeCommand(String[] args) {
       Command cmd = commands.get(args[0]);
       if (cmd != null) {
           return cmd.process(Arrays.copyOfRange(args, 1, args.length));
       }

       ExecutablesFiles executables = new ExecutablesFiles();
       String executableCommands = executables.findCommandInPath(args[0]);
       if (executableCommands != null) {
           return executables.executeProgram(args);
       }

       CommandResult result = new CommandResult();
       result.setStderr(args[0] + ": command not found");
       return result;
    }

    public Map<String, Command> getCommands() {
        return commands;
    }
}
