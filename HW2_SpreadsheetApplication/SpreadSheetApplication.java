import java.util.ArrayList;

public class SpreadSheetApplication {
    public ArrayList<Chart> charts = new ArrayList<Chart>();
    public ArrayList<SpreadSheetData> data = new ArrayList<SpreadSheetData>();

    public void addChart(Chart c){
        this.charts.add(c);
    }

    public void addData(String item, int value){
        SpreadSheetData newData = new SpreadSheetData(item, value);
        data.add(newData);
    }

    public void changeItemValue(String item, int value){
        for(int i = 0; i < data.size(); i++){
            if(data.get(i).getName().equals(item)) {
                data.get(i).setValue(value);
                this.display();
                return;
            }
        }
        SpreadSheetData newData = new SpreadSheetData(item, value);
        data.add(newData);
        this.display();
    }

    public void display(){
        for (int i = 0; i < this.charts.size(); i++){
            this.charts.get(i).display(data);
        }
    }

}
