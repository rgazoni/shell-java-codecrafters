public class Echo extends CommandProcedures {
    String[] args;

    public Echo(String[] args) {
        this.args = args;
    }

    public void process() {
        System.out.println(String.join(" ", args));
    }
}
