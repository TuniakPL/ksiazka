
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;


public class BooksFunctions {

    public static Book findBookByISBN(List<Book> books, String ISBN) {
        return books.stream()
                .filter(book -> book.getISBN().equals(ISBN))
                .findFirst().get();
    }

    public static List<Book> sortingBooksAscending (List<Book> books) {
        return books.stream()
                .sorted((o1, o2) -> Integer.compare(o1.getYear(), o2.getYear()))
                .collect(Collectors.toList());

    }

    public static List<Book> takeLastTwoBooks(List<Book> books) {
        return books.stream()
                .skip(3)
                .collect(Collectors.toList());

    }

    public static List<Book> sortingBooksDescending(List<Book> books) {
        return books.stream()
                .sorted(Comparator.comparingInt(Book::getYear).reversed())
                .collect(Collectors.toList());

    }

    public static java.util.Optional<Book> takeFirstWrittenBook(List<Book> books) {
        return books.stream()
                .min((o1, o2) -> Integer.compare(o1.getYear(), o2.getYear()));

    }

    public static java.util.Optional<Book> takeLastWrittenBook(List<Book> books) {
        return books.stream()
                .max((o1, o2) -> Integer.compare(o1.getYear(), o2.getYear()));

    }

    public static int sumOfDates(List<Book> books) {
        return books.stream()
                .mapToInt(value -> value.getYear()).sum();

    }

    public static long countOfBooksAfter2007(List<Book> books) {
        return books.stream()
                .filter(book -> book.getYear() > 2007)
                .count();
    }

    public static boolean allBooksWrittenAfter2003(List<Book> books) {
        return books.stream()
                .allMatch(book -> book.getYear() > 2003);
    }

    public static OptionalDouble averageYearOfBooks(List<Book> books) {
        return books.stream()
                .mapToInt(value -> value.getYear())
                .average();
    }

    public static boolean anyBooksWrittenBefore2000(List<Book> books) {
        return books.stream()
                .anyMatch(book -> book.getYear() > 2003);
    }

    public static List<Book> titleWithFirstTAndYearOfWrittenAfter2009(List<Book> books, String name) {
        return books.stream()
                .filter(book -> (book.getName().startsWith("T", 0)))
                .filter(book -> book.getYear() > 2009)
                .collect(Collectors.toList());
    }

    public static List<Book> add100toYears(List<Book> books, int year) {
        books.stream().forEach(book -> book.setYear(book.getYear() + 100));
        return books;

    }
}
