import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
  public static void main(String args[]) throws IOException {
    File fakeDataFile = new File(args[0]);
    BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));
    String line;
    ArrayList<String> arg;
    Window window = null;

    while ((line = reader.readLine()) != null){

      arg = new ArrayList<String>(Arrays.asList(line.split(" ")));
      String command = arg.get(0);

      if (command.equals("window")){
        if(arg.get(1).equals("IconWindow"))
            window = new IconWindow(arg.get(2));
        if(arg.get(1).equals("TransientWindow"))
            window = new TransientWindow(arg.get(2));
      } else if (window == null){
            System.out.println("please specify window");
      } else if (command.equals("drawBorder")){
            window.drawBorder();     
      } else if (command.equals("drawCloseBox")){
            window.drawCloseBox();
      } else {
            System.out.println("command error");
      }
    }
  }
}