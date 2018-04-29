import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class BooksFunctionsTest {
    private BooksFunctions booksFunctions = new BooksFunctions();

    private List<Book> books = new ArrayList<>();

    @Before
    public void init() {
        books.add(new Book("Clean Code", "0132350882", 2008));
        books.add(new Book("Effective Java", "0134685997", 2018));
        books.add(new Book("Test Driven Development", "0321146530", 2003));
        books.add(new Book("Patterns of Enterprise Application Architecture", "0321127420", 2002));
        books.add(new Book("Head First Design Patterns", "0596007124", 2004));
    }
    @Test
    public void testForFindBookByISBN(){
        assertEquals(BooksFunctions.findBookByISBN(books,"0321146530").getISBN(),"0321146530");
    }





}