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
            System.out.println(command + " "
                    + (registry.getCommands().get(command).isShellBuiltin() ?
                    "is a shell builtin" :
                    "is not a shell builtin"));
        } else {
            System.out.println(command + ": not found");
        }
    }

    @Override
    public String getName() {
        return "type";
    }

    @Override
    public boolean isShellBuiltin() {
        return true;
    }
}
