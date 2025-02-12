interface Command {
    CommandResult process(String[] args);
    String getName();
}
