package ar.edu.utn.mdp.library;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.Hashtable;

public class Library {

    private Hashtable<Integer, Book> books;

    public Library() {
        this.books = new Hashtable<>();
    }

    public void addBook(Book newBook) {
        if (books.containsKey(newBook.getBookID())) {
            throw new KeyAlreadyExistsException("This book ID is already present in the library.");
        }

        books.put(newBook.getBookID(), newBook);
    }
}
