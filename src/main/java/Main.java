import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        BooksPrintStrategy booksPrintStrategy = new FirstNameYearISBN();
        importBooks();
        int odczyt;
        boolean continueLoop = true;
        Scanner skaner = new Scanner(System.in);
        BooksFunctions booksFunctions = new BooksFunctions();
        BookData dane = BookData.getInstance();


        while (continueLoop) {
            System.out.println("--------------------------------------\n " +
                                "Wybież:\n " +
                                "1- wyjdź,\n " +
                                "2- kontakt,\n " +
                                "3- wyświetlenie wszystkich książek,\n " +
                                "4- wyświetlenie książek posortowanych rosnąco,\n " +
                                "5- wyświetlenie książek posortowanych malejąco,\n " +
                                "6- wyświetlenie czy są książki wydane po 2003r,\n " +
                                "7- Drukuj Year+Name+ISBN, \n " +
                                "8- Drukuj Name+Year+ISBN, \n " +
                                "9- Drukuj ISBN+Name+Year.\n " +
                                "--------------------------------------");
            odczyt = skaner.nextInt();
            switch (odczyt) {
                case 1:
                    continueLoop = false;
                    break;
                case 2:
                    System.out.println("email: ksiegarnia@gmail.com");
                    break;
                case 3:
                    booksPrintStrategy.print(dane.getAllBooks());
                    break;
                case 4:
                    List<Book> sortAscending = booksFunctions.sortingBooksAscending(dane.getAllBooks());
                    booksPrintStrategy.print(sortAscending);
                    break;
                case 5:
                    List<Book> sortDescending = booksFunctions.sortingBooksDescending(dane.getAllBooks());
                    booksPrintStrategy.print(sortDescending);
                    break;
                case 6:
                    boolean areBooksAfter2003Years = booksFunctions.anyBooksWrittenBefore2000(dane.getAllBooks());
                    if (areBooksAfter2003Years == true) {
                        System.out.println("Istnieją takie książki");
                    } else {
                        System.out.println("Nie ma takich książek");
                    }
                    break;
                case 7:
                    booksPrintStrategy = new FirstNameYearISBN();
                    break;
                case 8:
                    booksPrintStrategy = new FirstYearNameISBN();
                    break;
                case 9:
                    booksPrintStrategy = new FisrtISBNNameYear();
                    break;
            }
        }

    }

    public static void importBooks() {
        BufferedReader br;
        List<Book> books = new ArrayList<>();
        try {
            br = new BufferedReader(new InputStreamReader(
                    ClassLoader.getSystemResourceAsStream("books.csv")));
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(";");
                Book book = createBook(attributes);
                books.add(book);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        BookData dane = BookData.getInstance();
        dane.setBooks(books);

    }

    private static Book createBook(String[] attributes) {
        return new Book(attributes[0], (attributes[1]), Integer.parseInt(attributes[2]));
    }


}


