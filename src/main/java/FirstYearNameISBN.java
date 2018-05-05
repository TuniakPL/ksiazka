import java.util.List;

public class FirstYearNameISBN implements BooksPrintStrategy {
    @Override
    public void print(List<Book> allBooks) {
        allBooks.stream()
                .forEach(book -> System.out.println("Year "+ book.getYear() + "\t" + " Name: " + book.getName() + "\t" + " ISBN: " + book.getISBN()));

    }
}
