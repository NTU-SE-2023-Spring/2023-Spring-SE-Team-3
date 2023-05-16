import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class LibrarySystem {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<BorrowRecord> borrowRecords = new ArrayList<>();
    LibrarySystem(){
        
    }

    public void checkOutBook(String staff,String borrower, Book bk){
        
    }
    public void returnBook(String staff, Book bk){

    }
    public void addBook(String staff, String subject, String author){

    }
    public void removeBook(String staff, Book bk){

    }
    public void getBooksByAuthor(String author){
        
    }
    public void getBooksBySubject(String sub){

    }




    public static void main(String[] args) {

        // read filename
        String fn = args[0];

        // read file
        File inputFile = new File(fn);
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(inputFile));
        } catch (FileNotFoundException ex) {
            // insert code to run when exception occurs
            System.out.println("Error");
        }

        Reader reader = new Reader();
        // add book
        int readBookTimes = -1;
        while (readBookTimes<0) {
            try{
                String readBookTimeString = fileReader.readLine();
                readBookTimes = Integer.parseInt(readBookTimeString);
                if(readBookTimes>=0){
                    break;
                } else {
                    System.out.println("Error");
                }
            } catch (NumberFormatException e){
                System.out.println("Error");
            } catch (IOException e) {
                System.out.println("No number_of_book param");
            }
        }
        while (readBookTimes>0){
            try {
                String bkline = fileReader.readLine();
                boolean pass = reader.parseBook(bkline);
                if (pass) {
                    readBookTimes-=1;
                } else {
                    System.out.println("Error");
                }
            } catch (IOException e) {
                System.out.println("Books not enough");
                System.exit(0);
            }
        }
        // add User
        int addUserTimes=-1;
        while (addUserTimes<0) {
            try{
                String addUserTimeString = fileReader.readLine();
                addUserTimes = Integer.parseInt(addUserTimeString);
                if(addUserTimes>=0){
                    break;
                } else {
                    System.out.println("Error");
                }
            } catch (NumberFormatException e){
                System.out.println("Error");
            } catch (IOException e) {
                System.out.println("No number_of_user param");
            }
        }
        while (addUserTimes>0){
            try {
                String uline = fileReader.readLine();
                boolean pass = reader.parseBook(uline);
                if (pass) {
                    readBookTimes-=1;
                } else {
                    System.out.println("Error");
                }
            } catch (IOException e) {
                System.out.println("Books not enough");
                System.exit(0);
            }
        }

        // command loop
        
        try {
            String line;
            while ((line = fileReader.readLine()) != null){
                boolean pass = reader.parseCommand(line);
                if (!pass){
                    System.out.println("Error");
                }
            }
        } catch (IOException ex) {
            System.exit(0);
        }


    }
    
    


}