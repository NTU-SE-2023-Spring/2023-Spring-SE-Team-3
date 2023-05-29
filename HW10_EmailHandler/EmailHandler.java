public abstract class EmailHandler {
    private EmailHandler nextHandler;
    public EmailHandler(EmailHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public void handleRequest(Email e) {
        action(e);
        if (nextHandler != null) {
            nextHandler.handleRequest(e);
        }
    }
    public abstract void action(Email e);
}







