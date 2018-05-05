import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

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
    public void testForFindBookByISBN() {
        assertEquals(BooksFunctions.findBookByISBN(books, "0321146530").getISBN(), "0321146530");
    }

    @Test
    public void testForSortingBooksAscending() {
        assertEquals(BooksFunctions.sortingBooksAscending(books).get(0).getISBN(), "0321127420");
        assertEquals(BooksFunctions.sortingBooksAscending(books).get(4).getISBN(), "0134685997");
    }

    @Test
    public void testForTakeLastTwoBooks() {
        List<Book> zmienna = BooksFunctions.takeLastTwoBooks(books);
        assertEquals(2, zmienna.size());
        assertEquals(zmienna.get(0).getISBN(), "0321127420");
        assertEquals(zmienna.get(1).getISBN(), "0596007124");
    }

    @Test
    public void testSortingBooksDescending() {
        assertEquals(BooksFunctions.sortingBooksDescending(books).get(0).getISBN(), "0134685997");
        assertEquals(BooksFunctions.sortingBooksDescending(books).get(4).getISBN(), "0321127420");
    }

    @Test
    public void testTakeFirstWrittenBook() {
        assertEquals(BooksFunctions.takeFirstWrittenBook(books).get().getISBN(), "0321127420");
    }

    @Test
    public void testTakeLastWrittenBook() {
        assertEquals(BooksFunctions.takeLastWrittenBook(books).get().getISBN(), "0134685997");
    }

    @Test
    public void testSumOfDates() {

        assertEquals(BooksFunctions.sumOfDates(books), 10035);
    }

    @Test
    public void testCountOfBooksAfter2007() {
        assertEquals(BooksFunctions.countOfBooksAfter2007(books), 2);
    }

    @Test
    public void testAllBooksWrittenAfter2003() {
        assertEquals(BooksFunctions.allBooksWrittenAfter2003(books), false);
    }

    @Test
    public void testAverageYearOfBooks() {
        assertEquals(BooksFunctions.averageYearOfBooks(books), OptionalDouble.of(2007));
    }

    @Test
    public void testAnyBooksWrittenBefore2000() {
        assertEquals(BooksFunctions.anyBooksWrittenBefore2000(books), false);
    }

    @Test
    public void testTitleWithFirstTAndYearOfWrittenAfter2009() {
        assertEquals(BooksFunctions.titleWithFirstTAndYearOfWrittenAfter2009(books, "Test Driven Development").isEmpty(), true);
    }

//    @Test
//    public void testAdd100toYears(){
//        assertEquals(BooksFunctions.add100toYears(books).get(0).getYear(),2108 );
//    }
}