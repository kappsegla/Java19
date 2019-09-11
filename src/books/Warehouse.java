package books;

import java.time.LocalDate;
import java.util.ArrayList;

public class Warehouse {

    ArrayList<BookInfo> stock = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Author> authors = new ArrayList<>();

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.run();
    }

    private void run() {
        Author author = new Author("Martin", "Blomberg");
        authors.add(author);
        Book book = new Book("Martins påhitt", author ,"Massa blaj",2345, LocalDate.now());
        books.add(book);
        author.books.add(book);

        stock.add(  new BookInfo(book, 10, 179.0f));
        book = new Book("Javaprogrammering", author ,"Lär dig Java",215, LocalDate.now(), new Dimensions(110,179,23,105));
        stock.add(  new BookInfo(book, 2, 149.0f));
        author.books.add(book);

        for (BookInfo bookInfo: stock ) {
            System.out.println( bookInfo );
        }
    }
}
