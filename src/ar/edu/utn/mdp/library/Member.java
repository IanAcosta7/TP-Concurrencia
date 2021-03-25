package ar.edu.utn.mdp.library;

import java.util.Random;

public class Member implements Runnable {

    private String name;

    public Member(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Library library = Library.INSTANCE;
        Book requestedBook;
        Integer booksRead = 0;
        Random rand = new Random();

        while (true) {
            Integer bookID = rand.nextInt(4) + 1;

            System.out.println(name + ": requested book " + bookID);
            requestedBook = library.requestBook(bookID);

            if (requestedBook != null)
                System.out.println(name + ": is reading book " + bookID + " (" + requestedBook.getTitle() + ")");
            else
                System.out.println(name + ": didn't find book " + bookID);

            spendTime(rand.nextInt(1000));

            if (requestedBook != null) {
                System.out.println(name + ": returned the book " + bookID + " (" + requestedBook.getTitle() + ")");
                library.returnBook(requestedBook);

                booksRead++;
                System.out.println(name + ": already have read " + booksRead + " books");
            }

            spendTime(rand.nextInt(1000));
        }
    }

    private void spendTime(Integer time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
