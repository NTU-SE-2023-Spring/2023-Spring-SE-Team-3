public class TransientWindow extends Window {
    TransientWindow(String s){
        super(s);
    }
    public void drawCloseBox(){
        this.framework.drawRect();
    }
    public void drawBorder(){
        System.out.println("TransientWindow doen't support drawBorder");
    }
}
