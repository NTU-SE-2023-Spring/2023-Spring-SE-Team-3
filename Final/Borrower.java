import java.util.ArrayList;

public class Borrower extends User {
    Borrower(String name, int preDefinedNumber){
        this.name=name;
        this.preDefinedNumber=preDefinedNumber;
        checkedOutBook = new ArrayList<>();
    }
    @Override
    public void addBook(Book bk) {
        System.out.println("Borrower can not add book");
    }
    @Override
    public void returnBook(Book bk) {
        System.out.println("Borrower can not return book");        
    }
    @Override
    public void checkOutBook(User borrower, ArrayList<Book> bk) {
        System.out.println("Borrower can not check out the books");
        
    }
    @Override
    public void removeBook(Book bk) {
        System.out.println("Borrower can not remove book");
    }
    @Override
    public void getBooksByBorrower(User borrower) {
        if (borrower.name != this.name){
            System.out.println("Borrower can not find books checked out by other users");
        } else {
            for (int i=0;i<this.checkedOutBook.size();i++){
                Book b = this.checkedOutBook.get(i);
                String s;
                s = String.format("ID: %d Author: %s Subject: %s",
                    Integer.valueOf(b.id),b.author,b.subject);
                System.out.println(s);
            }
        }
        
    }
    @Override
    public void getLastCheckedBorrowerByBook(Book bk) {
        System.out.println("Borrower can not find borrower");
    }
}
