import java.util.ArrayList;
public class Reader {
    private LibrarySystem lib;
    private int status;
    private String name1;
    private String name2;
    public Reader(){
        this.lib= new LibrarySystem();
        status=0;
    }
    public boolean parseBook(String s){
        try {
            String[] sl = s.split(" ");
            lib.books.add(new Book(lib.books.size(), sl[0], sl[1]));
            // System.out.println("here");
            // System.out.println(lib.books.size());
            return true;
        } catch (IndexOutOfBoundsException e){
            return false;
        }
    }
    public boolean parseUser(String s){
        try {
            String[] sl = s.split(" ");
            if (sl[0].equals("Staff")) {
                lib.addUser(sl[0],sl[1], -1);
            } else {
                lib.addUser(sl[0],sl[1],Integer.parseInt(sl[2]));
            }
            return true;
        } catch (IndexOutOfBoundsException e){
            return false;
        } catch (NumberFormatException e ){
            return false;
        }
    }
    public boolean parseCommand(String s){
        // System.out.println(s);
        String[] sl = s.split(" ");
        try {
            if (status==0){
                switch (sl[1]) {
                    case "addBook":
                        name1=sl[0];
                        status=1;
                        break;
                    case "removeBook":
                        lib.removeBook(sl[0], Integer.parseInt(sl[2]));
                        break;
                    case "checkout":
                        name1=sl[0];
                        name2=sl[2];
                        status=2;
                        break;
                    case "return":
                        lib.returnBook(sl[0], Integer.parseInt(sl[2]));
                        break;
                    case "listAuthor":
                        lib.getBooksByAuthor(sl[2]);
                        break;
                    case "listSubject":
                        lib.getBooksBySubject(sl[2]);
                        break;
                    case "findChecked":
                        lib.getBooksByBorrower(sl[0],sl[2]);
                        break;
                    case "Borrower":
                        lib.getLastCheckedBorrowerByBook(sl[0], Integer.parseInt(sl[2]));
                        break;
                    default:
                        return false;
                }
                return true;
            } else if (status == 1){
                lib.addBook(name1, sl[0], sl[1]);
                status=0;
                return true;
            } else if (status == 2){
                ArrayList<Integer> il = new ArrayList<>();
                for (int i=0;i<sl.length;i++){
                    il.add(Integer.parseInt(sl[i]));
                }
                lib.checkOutBook(name1, name2, il);
                status=0;
                return true;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

            
    
}
