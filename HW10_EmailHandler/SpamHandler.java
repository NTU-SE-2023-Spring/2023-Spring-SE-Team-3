public class SpamHandler extends EmailHandler {

    public SpamHandler(EmailHandler nextHandler) {
        super(nextHandler);
    }
    public void action(Email e){
        if(e.getType().equals("SPAM")){
            System.out.println("Put mail to the spam box.");
        }
    }

}