package books;

import java.util.Objects;

public class BookInfo {
    Book book;
    int stock;
    float price;

    public BookInfo(Book book, int stock, float price) {
        this.book = book;
        this.stock = stock;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookInfo bookInfo = (BookInfo) o;
        return stock == bookInfo.stock &&
                Float.compare(bookInfo.price, price) == 0 &&
                Objects.equals(book, bookInfo.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, stock, price);
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "book=" + book +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
