public class FanHandler extends EmailHandler {

    public FanHandler(EmailHandler nextHandler) {
        super(nextHandler);
    }

    public void action(Email e){
        if(e.getType().equals("FAN")){
            System.out.println("Forward to CEO.");
        }
    };
}