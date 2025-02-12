public class EchoCommand implements Command {
    @Override
    public CommandResult process(String[] args) {
        CommandResult result = new CommandResult();
        result.setStdout(String.join(" ", args));
        return result;
    }

    @Override
    public String getName() {
        return "echo";
    }
}
