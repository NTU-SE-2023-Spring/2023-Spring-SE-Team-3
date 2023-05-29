import java.util.ArrayList;

interface Iterator {

    boolean hasNext();
    Object next();

};

class List implements Iterator{


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



    public ArrayList<SkipNode> skipNodeArrayList = new ArrayList<>();
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
        SkipNode res = skipNodeArrayList.get(pos);
        pos +=1;
        return res;
    }


    public void addItem(String s){
        skipNodeArrayList.add(new SkipNode(s));
        size = skipNodeArrayList.size();
    }

    public void getNode(int index){
        System.out.println("SkipNode:" + skipNodeArrayList.get(index).value);
    }






};

class SkipNode {
    String value;
    SkipNode(String v){
        this.value = v;
    }
}