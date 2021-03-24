package ar.edu.utn.mdp;

import ar.edu.utn.mdp.library.*;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book(1, "Game of Thrones"));
        library.addBook(new Book(1, "Game of Chairs"));
    }
}
