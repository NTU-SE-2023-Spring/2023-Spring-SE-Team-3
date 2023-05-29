public class ComplaintHandler extends EmailHandler {

    public ComplaintHandler(EmailHandler nextHandler) {
        super(nextHandler);
    }
    public void action(Email e){
        if(e.getType().equals("COMPLAINT")){
            System.out.println("Forward to legal department.");
        }
    }
}