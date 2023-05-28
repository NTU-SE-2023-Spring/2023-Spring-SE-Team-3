import java.util.ArrayList;

interface Iterator {

    boolean hasNext();
    Object next();

};

class List implements Iterator{

    public ArrayList<String> stringArrayList = new ArrayList<>();
    public int pos;
    public String name;
    public int length;

    List(){}
    List(String name){
        this.name = name;
        this.pos = 0;
        this.length = 0;
    }

    public boolean hasNext(){
        return !(pos>=length);
    }
    public Object next(){
        String res = stringArrayList.get(pos);
        pos +=1;
        return res;
    }

    public void size(){
        System.out.println("List do not have method size");
    }
    public void getLength(){
        System.out.println(length);
    }
    public void getNode(int index){
        System.out.println("List do not have method getNode");
    }
    public void addItem(String s){
        stringArrayList.add(s);
        length = stringArrayList.size();
    }
    public void printOut(){
        pos = 0;
        while (hasNext()){
            String s = (String) next();
            System.out.println(s);


        }

    }
    public  void  get(int index){
        System.out.println(stringArrayList.get(index));
    }

}

class SkipList extends List{

    SkipList(String name){
        this.name = name;
    }
    @Override
    public void size(){
        System.out.println(this.length);
    }

    @Override
    public void getLength(){
        System.out.println("SkipList can not access length");
    }
    @Override
    public void getNode(int index){
        System.out.println("SkipNode:" + stringArrayList.get(index));
    }
    @Override
    public  void  get(int index){
        System.out.println("SkipList do not have method get");
    }

    @Override
    public void printOut(){
        pos = 0;
        while (hasNext()){
            String s = (String) next();
            System.out.println("SkipNode:" + s);


        }

    }

}