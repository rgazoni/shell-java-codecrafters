public class ExitCommand implements Command {
    @Override
    public CommandResult process(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: 'exit 0' to exit shell");
            return new CommandResult();
        }
        System.exit(Integer.parseInt(args[0]));
        return new CommandResult();
    }

    @Override
    public String getName() {
        return "exit";
    }


}
