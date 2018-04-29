import java.util.List;
import java.util.stream.Collectors;

public class BooksFunctions {

    public static Book findBookByISBN(List<Book> books,String ISBN){
        return books.stream()
                .filter(book -> book.getISBN().equals(ISBN))
                .findFirst().get();
    }



}
