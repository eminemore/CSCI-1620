public class Book extends hasKey
{
    private String title;
    private String author;

    public Book()
    {
        super(0);
        title = "";
        author = "";
    }

    public Book(String t, String a, int i)
    {
        super(i);
        title = t;
        author = a;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public boolean equals(Book b)
    {
        if(this.key == b.key)
            return true;
        else
            return false;
    }

    public String toString()
    {
        return String.format("%s\n%s\n%d", title, author, key);
    }
}
