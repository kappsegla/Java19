package books;

import java.time.LocalDate;

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
}
