import java.util.List;
import java.util.stream.Collectors;

public class BooksFunctions {

    public static void findBookByISBN(){
        List <Book> books;
        books.stream()
                .filter(book -> book.getISBN().equals("321146530"))
                .collect(Collectors.toList());

    }



}
