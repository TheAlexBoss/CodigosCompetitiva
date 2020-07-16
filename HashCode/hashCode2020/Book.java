package hashCode2020;

import java.util.Objects;

public class Book implements Comparable<Book>{
    int id, score;
    boolean repe;

    public Book(int id, int score) {
        this.id = id;
        this.score = score;
        this.repe = false;
    }

    @Override
    public int compareTo(Book o) {
        if(repe)
            return 1;
        else
            return -(this.score - o.score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", score=" + score +
                ", repe=" + repe +
                '}';
    }
}
