import java.util.ArrayList;
public abstract class User {
    protected String name;
    protected ArrayList<Book> checkedOutBook;
    protected int preDefinedNumber;
    public abstract void checkOutBook(User borrower, Book bk);
    public abstract void returnBook(User borrower, Book bk);
    public abstract void addBook(Book bk);
    public abstract void removeBook(Book bk);
    public abstract void getBooksByBorrower(User borrower);
    public abstract void getLastCheckedBorrowerByBook(Book bk);
}
