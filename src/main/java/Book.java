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
        return  "   n: " +name + ", " + " I: " + ISBN +", " + " y: " + year +" \n";

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
