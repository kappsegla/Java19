package books;

import java.time.LocalDate;
import java.util.ArrayList;

public class Warehouse {

    ArrayList<BookInfo> stock = new ArrayList<>();


    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        Author author = new Author("Martin", "Blomberg");
        Book book = new Book("Martins påhitt", author ,"Massa blaj",2345, LocalDate.now());
        warehouse.stock.add(  new BookInfo(book, 10, 179.0f));
        book = new Book("Javaprogrammering", author ,"Lär dig Java",215, LocalDate.now());
        warehouse.stock.add(  new BookInfo(book, 2, 149.0f));

        for (BookInfo bookInfo: warehouse.stock ) {
            System.out.println( bookInfo );
        }








    }
}
