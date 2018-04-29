public class Book {

    private String name;
    private String ISBN;
    private int year;

    public String getName() {
        return name;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getYear() {
        return year;
    }

    public Book(String name, String ISBN, int year) {
        this.name = name;
        this.ISBN = ISBN;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", ISBN=" + ISBN +
                ", year=" + year +
                "}\n";

    }

}
