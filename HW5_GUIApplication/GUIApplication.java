import java.util.ArrayList;

public class GUIApplication {
    private ArrayList<Widget> widgets;
    private WidgetFactory factory;

    public GUIApplication(){
        this.factory = new MotifWidgetFactory();
        this.widgets = new ArrayList<Widget>();
    }

    public void setFactory(String style){
        if(style.equals("Motif")){
            this.factory = new MotifWidgetFactory();
        }
        else if(style.equals("PM")){
            this.factory = new PMWidgetFactory();
        }
    }

    public void switchStyle(String style){
        setFactory(style);

        for(int i = 0; i < this.widgets.size(); i++) {
            String name = this.widgets.get(i).getName();
            switch (this.widgets.get(i).getClass().getSuperclass().getName()) {
                case "Window":
                    this.widgets.set(i, this.factory.createWindow(this.widgets.get(i).getName()));
                    break;
                case "ScrollBar":
                    this.widgets.set(i, this.factory.createScrollBar(this.widgets.get(i).getName()));
                    break;
                case "Button":
                    this.widgets.set(i, this.factory.createButton(this.widgets.get(i).getName()));
                    break;
            }
        }
    }

    public void addWidget(String type, String name){
        switch(type){
            case "Window":
                this.widgets.add(this.factory.createWindow(name));
                break;
            case "ScrollBar":
                this.widgets.add(this.factory.createScrollBar(name));
                break;
            case "Button":
                this.widgets.add(this.factory.createButton(name));
                break;
        }
    }


    public void present(){
        // Window
        for(Widget w : this.widgets){
            if(w.getClass().getSuperclass().getName().equals("Window")){
                System.out.println(w.getClass().getName() + " " + w.getName());
            }
        }
        // ScrollBar
        for(Widget w : this.widgets){
            if(w.getClass().getSuperclass().getName().equals("ScrollBar")){
                System.out.println(w.getClass().getName() + " " + w.getName());
            }
        }// Button
        for(Widget w : this.widgets){
            if(w.getClass().getSuperclass().getName().equals("Button")){
                System.out.println(w.getClass().getName() + " " + w.getName());
            }
        }

    }
}
