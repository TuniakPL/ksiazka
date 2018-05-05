import java.util.List;

public class FisrtISBNNameYear implements BooksPrintStrategy {
    @Override
    public void print(List<Book> allBooks) {
        allBooks.stream()
                .forEach(book -> System.out.println("ISBN: "+ book.getISBN() + "\t" + " Name: " + book.getName() + "\t" + " Year: " + book.getYear()));

    }
}
