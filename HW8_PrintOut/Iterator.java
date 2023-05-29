import java.util.ArrayList;

interface Iterator {

    boolean hasNext();
    Object next();

};

class List implements Iterator{

    public String type = "List";
    public ArrayList<String> stringArrayList = new ArrayList<>();
    public int pos;

    public int length;

    List(){}


    public boolean hasNext(){

        return !(pos>=length);
    }
    public void resetPos(){
        this.pos = 0;
    }
    public Object next(){
        String res = stringArrayList.get(pos);
        pos +=1;
        return res;
    }


    public void getLength(){
        System.out.println(length);
    }

    public void addItem(String s){
        stringArrayList.add(s);
        length = stringArrayList.size();
    }

    public  void  get(int index){
        System.out.println(stringArrayList.get(index));
    }

}

class SkipList implements Iterator{

    public String type = "SkipList";

    public ArrayList<SkipNode> stringArrayList = new ArrayList<>();
    public int pos;

    public int size;
    SkipList(){

    }

    public void size(){
        System.out.println(this.size);
    }

    public boolean hasNext(){

        return !(pos>=size);
    }
    public void resetPos(){
        this.pos = 0;
    }
    public Object next(){
        SkipNode res = stringArrayList.get(pos);
        pos +=1;
        return res;
    }


    public void addItem(String s){
        stringArrayList.add(new SkipNode(s));
        size = stringArrayList.size();
    }

    public void getNode(int index){
        System.out.println("SkipNode:" + stringArrayList.get(index).value);
    }

    public  void  get(int index){
        System.out.println("SkipList do not have method get");
    }




};

class SkipNode {
    String value;
    SkipNode(String v){
        this.value = v;
    }
}