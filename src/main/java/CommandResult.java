
public class CommandResult {
    private String stdout = "";
    private String stderr = "";
    private boolean hasError = false;
    private boolean hasOutput = false;

    void setStdout(String stdout) {
        this.stdout = stdout;
        this.hasOutput = true;
    }

    void setStderr(String stderr) {
        this.stderr = stderr;
        this.hasError = true;
    }

    String getStdout() {
        return stdout;
    }
    String getStderr() {
        return stderr;
    }

    boolean hasError() {
        return hasError;
    }

    boolean hasOutput() {
        return hasOutput;
    }
}
