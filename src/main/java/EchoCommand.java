public class EchoCommand implements Command {
    @Override
    public CommandResult process(String[] args) {
        CommandResult result = new CommandResult();
        String str = String.join(" ", args)
                .replaceAll("'", "");
        result.setStdout(str);
        return result;
    }

    @Override
    public String getName() {
        return "echo";
    }
}
