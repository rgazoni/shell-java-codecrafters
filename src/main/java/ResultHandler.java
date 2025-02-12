import java.io.FileWriter;
import java.io.IOException;

public class ResultHandler {
    private boolean redirectionOutput = false;
    private boolean redirectionErr = false;
    private String fileRedirection = null;

    public ResultHandler(
            boolean redirectionOutput,
            boolean redirectionErr,
            String fileRedirection
    ) {
        this.redirectionOutput = redirectionOutput;
        this.redirectionErr = redirectionErr;
        this.fileRedirection = fileRedirection;
    }

    private void writeToFile(String output) {
        try {
            FileWriter myWriter = new FileWriter(this.fileRedirection);
            myWriter.write(output);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void process(CommandResult result) {

        if (redirectionOutput && !redirectionErr) {
            this.writeToFile(result.getStdout());
            if (!result.getStderr().isEmpty()) {
                System.out.println(result.getStderr());
            }
        } else if (!redirectionOutput && redirectionErr){
            this.writeToFile(result.getStderr());
            if (!result.getStdout().isEmpty()) {
                System.out.println(result.getStdout());
            }
        } else if (redirectionOutput && redirectionErr) {
            String output = result.getStdout() +
                    "\n" +
                    result.getStderr();
            this.writeToFile(output);
        } else {
            if (!result.getStdout().isEmpty()) {
                System.out.println(result.getStdout());
            }
            if (!result.getStderr().isEmpty()) {
                System.out.println(result.getStderr());
            }
        }
    }
}
