import java.util.List;

public class FirstNameYearISBN implements BooksPrintStrategy {
    @Override
    public void print(List<Book> allBooks) {
        allBooks.stream()
                .forEach(book -> System.out.println("Name "+ book.getName() + "\t" + " Year: " + book.getYear() + "\t" + " ISBN: " + book.getISBN()));

    }
}
