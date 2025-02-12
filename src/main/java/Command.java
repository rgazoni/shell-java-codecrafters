import java.util.ServiceLoader;

interface Command {
    CommandResult process(String[] args);
    String getName();
}
