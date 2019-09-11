package books;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Objects;

public class Book {

    private String title;
    private Author author;
    private String info;
    private int pages;
    private LocalDate publishDate;
    private Dimensions dimensions;

    public Book(String title, Author author, String info, int pages, LocalDate publishDate) {
        this(title,author,info,pages,publishDate, Dimensions.ZERO);
    }

    public Book(String title, Author author, String info, int pages, LocalDate publishDate, Dimensions dimensions) {
        this.title = title;
        this.author = author;
        this.info = info;
        this.pages = pages;
        this.publishDate = publishDate;
        this.dimensions = dimensions;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getInfo() {
        return info;
    }

    public int getPages() {
        return pages;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(info, book.info) &&
                Objects.equals(publishDate, book.publishDate) &&
                Objects.equals(dimensions, book.dimensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, info, pages, publishDate, dimensions);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", info='" + info + '\'' +
                ", pages=" + pages +
                ", publishDate=" + publishDate +
                ", dimensions=" + dimensions +
                '}';
    }
}
