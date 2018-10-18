package pl.coderslab.Controller;

public class Book
{
    private String title;
    private String isbn;
    private String author;

    public Book(String title, String author, String isbn)
    {
        setAuthor(author);
        setIsbn(isbn);
        setTitle(title);
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }
}
