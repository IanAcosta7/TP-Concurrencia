package ar.edu.utn.mdp;

import ar.edu.utn.mdp.library.*;

public class Main {

    public static void main(String[] args) {
        Library library = Library.INSTANCE;

        library.addBook(new Book(1, "A Song of Ice and Fire"));
        library.addBook(new Book(2, "The Hunger Games"));
        library.addBook(new Book(3, "The Lord of the Rings"));
        library.addBook(new Book(4, "Effective Java"));
        library.addBook(new Book(5, "1984"));

        Thread member1 = new Thread(new Member("Member 1"));
        Thread member2 = new Thread(new Member("Member 2"));
        Thread member3 = new Thread(new Member("Member 3"));
        Thread member4 = new Thread(new Member("Member 4"));
        Thread member5 = new Thread(new Member("Member 5"));
        Thread member6 = new Thread(new Member("Member 6"));
        Thread member7 = new Thread(new Member("Member 7"));
        Thread member8 = new Thread(new Member("Member 8"));
        Thread member9 = new Thread(new Member("Member 9"));
        Thread member10 = new Thread(new Member("Member 10"));

        member1.start();
        member2.start();
        member3.start();
        member4.start();
        member5.start();
        member6.start();
        member7.start();
        member8.start();
        member9.start();
        member10.start();
    }
}
