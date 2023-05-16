public class BorrowRecord {
    public User staff;
    public User borrower;
    public Book book;

    BorrowRecord(User staff, User borrower, Book book){
        this.staff = staff;
        this.borrower = borrower;
        this.book = book;
    }
}
