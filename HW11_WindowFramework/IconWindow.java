import javax.swing.Icon;

public class IconWindow extends Window {
    IconWindow(String s){
        super(s);
    }
    public void drawBorder(){
        this.framework.drawText();
        this.framework.drawRect();
    }
    public void drawCloseBox(){
        System.out.println("IconWindow doen't support drawCloseBox");
    }
}
