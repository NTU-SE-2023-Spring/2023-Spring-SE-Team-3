import java.util.ArrayList;

public class PieChart implements Chart{
    @Override
    public void display(ArrayList<SpreadSheetData> data) {
        int sum = 0;
        for(int i = 0; i < data.size(); i++){
            sum = sum + data.get(i).getValue();
        }

        for(int i = 0; i < data.size(); i++){
            System.out.println("%s %.1f%%".formatted(data.get(i).getName(), (float)data.get(i).getValue()/sum*100));
        }
    }

    @Override
    public void changeItemValue(String item, int value, SpreadSheetApplication app) {
        System.out.println("%s change %s %d.".formatted(this.getClass().getName(), item, value));
        app.changeItemValue(item, value);
    }
}
