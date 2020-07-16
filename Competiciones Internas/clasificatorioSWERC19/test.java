package clasificatorioSWERC19;

import java.time.*;
import java.util.*;


public class test {
    public static void main(String[] args){

        Integer a = 87;

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(a,6);

        System.out.println(map.get(a));


        a = 46;

        System.out.println(map.get(a));

    }
}

class Testing{
    String str;
    Integer integer;
    ArrayList<Integer> lista;

    public Testing(String str, Integer integer, ArrayList<Integer> lista) {
        this.str = str;
        this.integer = integer;
        this.lista = lista;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public ArrayList<Integer> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Integer> lista) {
        this.lista = lista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Testing testing = (Testing) o;
        return Objects.equals(str, testing.str) &&
                Objects.equals(integer, testing.integer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str, integer);
    }

    @Override
    public String toString() {
        return "Testing{" +
                "str='" + str + '\'' +
                ", integer=" + integer +
                ", lista=" + lista +
                '}';
    }

    public Testing copy(){
        Testing testing = new Testing(null,null,null);
        testing.setStr(this.str);
        testing.setInteger(this.integer);
        testing.setLista(new ArrayList<>(this.lista));

        return testing;
    }
}

class Prueba{

    LocalDate date;
    String str;

    public Prueba(LocalDate date, String str) {
        this.date = date;
        this.str = str;
    }

    public Prueba(int a, int m, int d, String str) {
        this.date = LocalDate.of(a,m,d);
        this.str = str;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prueba prueba = (Prueba) o;
        return date.equals(prueba.date) &&
                str.equals(prueba.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, str);
    }
}
