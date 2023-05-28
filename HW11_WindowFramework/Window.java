public abstract class Window {
    protected WindowFramework framework;

    Window(String s){
        if(s.equals("XWindow")){
            this.framework = new XWindow();
        } else if(s.equals("PMWindow")){
            this.framework = new PMWindow();
        }
    }

    public abstract void drawBorder();
    public abstract void drawCloseBox();
}
