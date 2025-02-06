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

    public void executeCommand(String command, String[] args) {
       Command cmd = commands.get(command);
       if (cmd != null) {
           cmd.process(args);
       } else {
           System.out.println(command + ": command not found");
       }
    }

    public Map<String, Command> getCommands() {
        return commands;
    }
}
