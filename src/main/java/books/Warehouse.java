package books;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Book book = new Book("Martins påhitt", author, "Massa blaj", 2345, LocalDate.now());
        books.add(book);
        author.books.add(book);

        Book book1 = new Book("", null, "", 123, LocalDate.now());

        stock.add(new BookInfo(book, 10, 179.0f));
        book = new Book("Javaprogrammering", author, "Lär dig Java", 215, LocalDate.now(), new Dimensions(110, 179, 23, 105));
        stock.add(new BookInfo(book, 2, 149.0f));
        books.add(book);
        author.books.add(book);
//
//        for (BookInfo bookInfo: stock ) {
//            System.out.println( bookInfo );
//        }

        Stream<Book> bookStream = books.stream();
        long c = bookStream.count();
        System.out.println(books.stream().count());

        System.out.println(books.stream()
                .filter(b -> b.getTitle().startsWith("Java"))
                .count()
        );

        ////
        List<Book> filteredBooks = books.stream()
                                    .filter(b -> b.getTitle().startsWith("Java"))
                                    .filter(b -> b.getPages() > 100)
                                    .collect(Collectors.toList());
        ////
//        List<Book> filteredBooksOldStyle = new ArrayList<>();
//        for (Book b: books ) {
//            if( b.getTitle().startsWith("Java") && b.getPages() > 100 )
//                filteredBooksOldStyle.add(b);
//        }

        System.out.println(filteredBooks);
    }
}
