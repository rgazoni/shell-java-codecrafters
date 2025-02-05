public class ShellInterpreter {

    public void interpretCommand(String command, String[] args) {
        switch(command) {
            case "echo":
                Echo echo = new Echo(args);
                echo.process();
                break;
            case "exit":
                //TODO: I know that this is rough, but is manageable for now
                System.exit(Integer.parseInt(args[0]));
            default: //command not found
                System.out.println(command + ": command not found");
        }
    }
}

