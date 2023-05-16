import java.io.*;
import java.lang.Thread.State;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class LibrarySystem {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<BorrowRecord> borrowRecords = new ArrayList<>();
    private ArrayList<String> transactions;
    LibrarySystem(){
        
    }

    public void checkOutBook(String staff,String borrower, ArrayList<Integer> ids){
        ArrayList<Book> books = new ArrayList<>();
        for(int i=0; i<ids.size();i++){
            if(!hasBook(ids.get(i))){
                System.out.println("Error");
                return;
            }
            books.add(findBook(ids.get(i)));
        }
        if(hasUser(staff) && hasUser(borrower)){
            User usr = findUser(staff);
            User bor = findUser(borrower);
            usr.checkOutBook(bor, books);
            return;
        } else {
            System.out.println("Error");
            return;            
        }
    }
    public void returnBook(String staff, int book_id){
        if(!hasBook(book_id){
            System.out.println("Error");
            return;
        }
        Book bk = findBook(book_id);
    
        if(hasUser(staff)){
            User usr = findUser(staff);
            usr.returnBook(bk);
            return;
        } else {
            System.out.println("Error");
            return;            
        }
    }
    public void addBook(String staff, String subject, String author){
        Book bk = new Book(books.size(), author, subject);
        books.add(bk);
    }
    public void removeBook(String staff, int book_id){
        if(!hasBook(book_id){
            System.out.println("Error");
            return;
        }
        Book bk = findBook(book_id);
        if(hasUser(staff)){
            User usr = findUser(staff);
            usr.removeBook(bk);
            return;
        } else {
            System.out.println("Error");
            return;            
        }        
    }
    public void getBooksByAuthor(String author){
        for(int i=0;i<this.books.size();i++){
            if(this.books.get(i).author.equals(author)){
                Book bk = this.books.get(i);
                System.out.println("ID: "+bk.id+" Author: "+ bk.author+ " Subject: "+bk.subject);
                return;
            }
        }
        System.out.println("Error");
    }
    public void getBooksBySubject(String sub){
        for(int i=0;i<this.books.size();i++){
            if(this.books.get(i).subject.equals(sub)){
                Book bk = this.books.get(i);
                System.out.println("ID: "+bk.id+" Author: "+ bk.author+ " Subject: "+bk.subject);
                return;
            }
        }
        System.out.println("Error");
    }
    public void getBooksByBorrower(String staff, String borrower){
        if(hasUser(staff)&&hasUser(borrower)){
            User usr = findUser(staff);
            User bor = findUser(borrower);
            usr.getBooksByBorrower(bor);
            return; 
        } 
        System.out.println("Error");
    }
    public void getLastCheckedBorrowerByBook(String staff, int book_id){
        if(hasUser(staff)&&hasBook(book_id)){
            User usr = findUser(staff);
            Book bk = findBook(book_id);
            usr.getLastCheckedBorrowerByBook(bk);
            return; 
        } 
        System.out.println("Error");
    }
    public void addRecord(User staff, User borrower, Book bk){
        //  TODO check staff if staff
        
        BorrowRecord r = new BorrowRecord(staff, borrower, bk);
        this.borrowRecords.add(r);
    }
    public void addUser(String type, String name, int preDefinedNumber){
        User usr;
        if(type.equals("Staff")){
            usr  = new Staff(name, this);
        }
        if(type.equals("Borrower")){
            usr = new Borrower(name, this, preDefinedNumber);
        }
        this.users.add(usr);  
    }
    public boolean hasBook(int id){
        for(int i=0; i<this.books.size();i++){
            if(this.books.get(i).id == id){
                return true;
            }
        }
        return false;
    }
    public boolean hasUser(String name){
        for(int i=0; i<this.users.size();i++){
            if(this.users.get(i).name.equals(name)){
                return true;
            }
        }
        return false;
    }
    public Book findBook(int id){
        for(int i=0; i<this.books.size();i++){
            if(this.books.get(i).id == id){
                return this.books.get(i);
            }
        }
        return new Book(0, "", "");
    }
    public User findUser(String name){
        for(int i=0; i<this.users.size();i++){
            if(this.users.get(i).name.equals(name)){
                return this.users.get(i);
            }
        }
        // TODO
        return this.users.get(0);      
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