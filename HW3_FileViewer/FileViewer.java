import java.util.HashMap;
import java.util.Map;

public class FileViewer {
    Map<String, View> views=  new HashMap();
    public void addView(String name, String text){
        this.views.put(name, new ConcreteTextView(name, text));
    }

    public void display(String name){
        this.views.get(name).display();
    }
    public void addElementByViewName(String viewName, String elementType){
        View currentView = this.views.get(viewName);
        if (elementType.equals("scrollBar")){
            this.views.put(viewName, new ScrollBarDecorator(currentView));
        }else if (elementType.equals("thickBlackBorder")){
            this.views.put(viewName, new ThickBlackBorderDecorator(currentView));
        }
    }

}
