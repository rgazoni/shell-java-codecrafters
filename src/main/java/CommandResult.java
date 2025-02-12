enum Status {
    SUCCESS,
    ERROR
}

public class CommandResult {
    private String stdout = "";
    private String stderr = "";
    private Status type;

    void setStdout(String stdout) {
        this.stdout = stdout;
        this.type = Status.SUCCESS;
    }

    void setStderr(String stderr) {
        this.stderr = stderr;
        this.type = Status.ERROR;
    }

    String getStdout() {
        return stdout;
    }
    String getStderr() {
        return stderr;
    }

    Status getType() {
        return type;
    }
}
