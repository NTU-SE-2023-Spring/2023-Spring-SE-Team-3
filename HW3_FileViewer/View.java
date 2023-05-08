

import java.util.ArrayList;

interface   View {



    void display();
    String getContent();
}

class ViewDecorator implements View {

    View view;


    ViewDecorator(View v){
        this.view = v;

    }
    public void display(){

    }
    public  String getContent(){return "";}
}

class ScrollBarDecorator extends ViewDecorator {



    ScrollBarDecorator(View v){
        super(v);

    }
    public void display(){
        System.out.println(this.view.getContent() + " scrollBar" );
    }

    public String getContent(){
        return this.view.getContent() + " scrollBar";
    }
}

class ThickBlackBorderDecorator extends ViewDecorator {



    ThickBlackBorderDecorator(View v){
        super(v);


    }
    public void display(){
        System.out.println(this.view.getContent() + " thickBlackBorder" );
    }

    public String getContent(){
        return this.view.getContent() +  " thickBlackBorder";
    }
}
class ConcreteTextView implements    View{

    String name = null;
    String text = null;

    ConcreteTextView(String name, String text){
        this.name = name;
        this.text = text;
    }
    public void display(){
        System.out.println(this.text);
    }

    public String getContent(){
        return   this.text;
    }
}
