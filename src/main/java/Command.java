import java.util.ServiceLoader;

interface Command {
    void process(String[] args);
    String getName();
}
