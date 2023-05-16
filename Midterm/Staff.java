import java.util.ArrayList;

public class Staff extends User{
    private LibrarySystem lib;
    Staff(String name, LibrarySystem lib){
        this.name=name;
        this.lib = lib;
        this.preDefinedNumber=-1;
    }

    @Override
    public void addBook(Book bk) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void returnBook(Book bk) {
        if (bk.isAvaliable){
            System.out.println("Can not return since the book isn't checked out");
        }
        else {
            for (int i=lib.borrowRecords.size()-1;i>=0;i--){
                BorrowRecord r = lib.borrowRecords.get(i);
                if (r.book.id==bk.id) {
                    for (int j=0;j<r.borrower.checkedOutBook.size();j++){
                        Book b = r.borrower.checkedOutBook.get(j);
                        if (b.id == bk.id){
                            r.borrower.checkedOutBook.remove(j);
                            bk.isAvaliable=true;
                            return;
                        }
                    }
                }
            }
            System.out.println("Error");
        }
    }
    @Override
    public void checkOutBook(User borrower, ArrayList<Book> bk) {
        if (borrower.preDefinedNumber < borrower.checkedOutBook.size()+bk.size()){
            System.out.println("Can not check out since the number of books exceed the limitation of user can check-out");
        } else {
            for (int i=0;i<bk.size();i++){
                Book b = bk.get(i);
                if (!b.isAvaliable) {
                    System.out.println("Can not check out since the book is checked out");
                    return;
                }
            }
            for (int i=0;i<bk.size();i++){
                Book b = bk.get(i);
                borrower.checkedOutBook.add(b);
                lib.addRecord(this, borrower, b);
            }
        }
        
    }
    @Override
    public void removeBook(Book bk) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void getBooksByBorrower(User borrower) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void getLastCheckedBorrowerByBook(Book bk) {
        // TODO Auto-generated method stub
        
    }
}
