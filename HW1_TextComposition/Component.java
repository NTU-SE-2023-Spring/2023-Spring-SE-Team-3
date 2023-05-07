public abstract class  Component {
    private int id;
    private  int naturalSize;
    private  int stretchability;
    private  int shrinkability;
    private String  content;
    public Component(int id, int naturalSize, int shrinkability, int stretchability, String content){
        this.id = id;
        this.naturalSize = naturalSize;
        this.shrinkability = shrinkability;
        this.stretchability = stretchability;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public  void setNaturalSize(int newSize){
        if (newSize < shrinkability || stretchability< newSize){
            System.out.println("component " + Integer.toString(id) + " failed to change size");
        }else{
            this.naturalSize = newSize;
            System.out.println("component " + Integer.toString(id) + " size changed to " + Integer.toString(newSize));
        }
    }
    public int getNaturalSize() {
        return naturalSize;
    }

    public int getShrinkability() {
        return shrinkability;
    }

    public int getStretchability() {
        return stretchability;
    }

    public String getContent() {
        return content;
    }
}


class  TextComponent extends Component{

    public TextComponent(int id, int naturalSize, int shrinkability, int stretchability, String content) {
        super(id, naturalSize, shrinkability, stretchability, content);
    }
};

class GraphicalElementComponent extends  Component{

    public GraphicalElementComponent(int id, int naturalSize, int shrinkability, int stretchability, String content) {
        super(id, naturalSize, shrinkability, stretchability, content);
    }
};