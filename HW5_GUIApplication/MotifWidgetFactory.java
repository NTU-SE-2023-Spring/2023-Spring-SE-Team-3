public class MotifWidgetFactory implements WidgetFactory{
    public Window createWindow(String name){
        return new MotifWindow(name);
    }
    public ScrollBar createScrollBar(String name){
        return new MotifScrollBar(name);
    }
    public Button createButton(String name){
        return new MotifButton(name);
    }
}
