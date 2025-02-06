public class EchoCommand implements Command {
    @Override
    public void process(String[] args) {
        System.out.println(String.join(" ", args));
    }

    @Override
    public String getName() {
        return "echo";
    }

    @Override
    public boolean isShellBuiltin() {
        return true;
    }

}
