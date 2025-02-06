public class ExitCommand implements Command {
    @Override
    public void process(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: 'exit 0' to exit shell");
            return;
        }
        System.exit(Integer.parseInt(args[0]));
    }

    @Override
    public String getName() {
        return "exit";
    }


}
