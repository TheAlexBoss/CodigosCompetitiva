import java.util.*;

public class testing {


    static class Custom{
        String name;
        int win;
        int played;

        public Custom(String name, int win, int played) {
            this.name = name;
            this.win = win;
            this.played = played;
        }

        public double getRatio(){
            return (double) win/played;
        }

        public int getWin(){
            return this.win;
        }

        @Override
        public String toString() {
            return "Custom{" +
                    "name='" + name + '\'' +
                    ", win=" + win +
                    ", played=" + played +
                    '}';
        }
    }

    public static void main(String[] args) {


        ArrayList<Custom> array = new ArrayList<>();

        array.add(new Custom("Luis",7, 200));
        array.add(new Custom("Fernando",4, 7));
        array.add(new Custom("Alfredo",3, 3));
        array.add(new Custom("Jorse", 3, 8));
        array.add(new Custom("Jorse", 2, 8));


        array.sort(Comparator.comparing(Custom::getWin).thenComparing(Custom::getRatio).reversed());

        System.out.println(array);


    }
}
