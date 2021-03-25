package ar.edu.utn.mdp.library;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.Hashtable;

public class Library {

    public static final Library INSTANCE = new Library();
    private final Hashtable<Integer, Book> books;
    private Boolean booksLock;

    private Library() {
        this.books = new Hashtable<>();
        this.booksLock = false;
    }

    public void addBook(Book newBook) {
        if (books.containsKey(newBook.getBookID())) {
            throw new KeyAlreadyExistsException("This book ID is already present in the library.");
        }

        books.put(newBook.getBookID(), newBook);
    }

    public synchronized Book requestBook(Integer bookId) {
        Book requestedBook;

        while (booksLock) {
            try {
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        booksLock = true;

        requestedBook = books.get(bookId);
        books.remove(bookId);

        booksLock = false;
        notifyAll();
        return requestedBook;
    }

    public synchronized void returnBook(Book book) {
        while (booksLock) {
            try {
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        booksLock = true;

        books.put(book.getBookID(), book);

        booksLock = false;
        notifyAll();
    }
}
