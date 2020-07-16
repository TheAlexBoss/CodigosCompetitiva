package hashCode2020;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Libreria implements Comparable<Libreria>{

    int id;
    int capacity, sign_up_time, books_per_day;
    BigInteger sumBooks, ratioAux, no_repetidos_sum;
    ArrayList<Book> books, finalBooks;
    double ratio;
    int scanned_books, no_repetidos_num;

    public Libreria(int id, int capacity, int sign_up_time, int books_per_day) {
        this.id = id;
        this.capacity = capacity;
        this.sign_up_time = sign_up_time;
        this.books_per_day = books_per_day;
        this.books = new ArrayList<>(capacity);

        this.sumBooks = new BigInteger("0");
        this.ratioAux = new BigInteger("0");
        this.finalBooks = new ArrayList<>();
        this.scanned_books = 0;
    }


    public void sort(){
        Collections.sort(this.books);
    }

    public void addBook(int bookId, ArrayList<Book> libros){
        Book book = libros.get(libros.indexOf(new Book(bookId, 0)));
        sumBooks = sumBooks.add(new BigInteger(Integer.toString(book.score)));
        this.books.add(book);
    }

    public double calcRatio(){
        //this.ratio = sumBooks.divide(new BigInteger(Integer.toString(books_per_day)).add(new BigInteger(Integer.toString(sign_up_time)))).doubleValue();
        this.ratioAux = new BigInteger(Integer.toString(sign_up_time)).add(new BigInteger(Integer.toString(this.books.size())).divide(new BigInteger(Integer.toString(books_per_day))));
        this.ratio = sumBooks.divide(ratioAux).doubleValue();
        return this.ratio;
    }

    public void sumNoRepe(int s){
        this.no_repetidos_sum = this.no_repetidos_sum.add(new BigInteger(Integer.toString(s)));
        this.no_repetidos_num++;
    }

    public boolean meVale(double mean){
        return (no_repetidos_sum.compareTo(new BigInteger(Integer.toString((int) (no_repetidos_num*mean*0.5)))) < 0);
    }

    @Override
    public int compareTo(Libreria o) {
        return Double.compare(o.ratio, this.ratio);
        //return o.ratioAux.compareTo(this.ratioAux);
        //return Integer.compare(this.sign_up_time, o.sign_up_time);
    }
}
