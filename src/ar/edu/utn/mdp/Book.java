package ar.edu.utn.mdp;

public class Book {

    private Integer bookID;
    private String title;

    public Book(Integer bookID, String title) {
        this.bookID = bookID;
        this.title = title;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
