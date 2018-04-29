import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        importBooks();
        int odczyt;
        boolean continueLoop = true;
        Scanner skaner = new Scanner(System.in);

        while (continueLoop) {
            System.out.println("Wybież: 1-wyjście, 2-kontakt 3-wyświetlenie książek 4- ksiażki z 2000r");
            odczyt = skaner.nextInt();
            if (odczyt == 1) {
                System.out.println("zamykanie");
                continueLoop = false;
            } else if (odczyt == 2) {
                System.out.println("email: ksiegarnia@gmail.com");
            } else if (odczyt == 3) {
                BookData dane = BookData.getInstance();
                System.out.println(dane.getAllBooks());
//            } else if (odczyt == 4) {
//                List<Book> dane = BookData.getInstance().getAllBooks();
//
//            }

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


