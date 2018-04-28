import java.util.List;


class BookData {

    private static BookData instance = new BookData();

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    private BookData() {}

    private List<Book> books;

    public static BookData getInstance() {
        return instance;
    }

    public List<Book> getAllBooks() {
        return books;
    }

}