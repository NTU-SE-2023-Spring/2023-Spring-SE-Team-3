public class PMWidgetFactory implements WidgetFactory {
    public Window createWindow(String name){
        return new PMWindow(name);
    }
    public ScrollBar createScrollBar(String name){
        return new PMScrollBar(name);
    }
    public Button createButton(String name){
        return new PMButton(name);
    }
}
