import javax.security.auth.Subject;

public class Book {
    public int id;
    public String author;
    public String subject;
    public boolean isAvaliable;
    public boolean isRemove;

    Book(int id, String author, String subject){
        this.id = id;
        this.author = author;
        this.subject = subject;
        this.isAvaliable = true;
        this.isRemove = false;
    }
}
