import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        File fakeDataFile = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));
        String line;

        SpreadSheetApplication app = new SpreadSheetApplication();

        while ((line = reader.readLine()) != null){
            String[] words = line.split(" ");
            if (words[0].equals("data")){
                app.addData(words[1], Integer.parseInt(words[2]));
            }else if (words[0].equals("addChart")){
                if(words[1].equals("Spreadsheet")){
                    app.addChart(new Spreadsheet());
                }
                else if (words[1].equals("BarChart")) {
                    app.addChart(new BarChart());
                }
                else if (words[1].equals("PieChart")){
                    app.addChart(new PieChart());
                }
            }else if (words[0].equals("change")){
                for(int i = 0; i < app.charts.size(); i++){
                    if(app.charts.get(i).getClass().getName().equals(words[1])){
                        app.charts.get(i).changeItemValue(words[2], Integer.parseInt(words[3]), app);
                    }
                }
            }
        }

    }

}
