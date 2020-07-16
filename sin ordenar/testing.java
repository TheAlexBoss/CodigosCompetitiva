package com.company;


import CP0911.B;

import java.io.*;
import java.lang.instrument.Instrumentation;
import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.*;

public class testing {

    static class Par{
        Integer a, b;
        public Par(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Par par = (Par) o;
            return this.a.equals(par.a) && this.b.equals(par.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }


    public static void main(String[] args) {

        System.out.println(((Math.asin(1)+ Math.PI/2)*180)/Math.PI);

    }

    public static void jorl2(){
        String str = "57";

        int N = str.length();
        System.out.println(N);

        BigInteger i = new BigInteger(str);

        System.out.println(str.substring(1,1));
        System.out.println();
        System.out.println(substring(i,1,1,N));

    }

    public static BigInteger substring(BigInteger integer, int start, int end, int length){
        return integer.mod(BigInteger.TEN.pow(length-start)).divide(BigInteger.TEN.pow(length-end));
    }

    public static void meh(){
        HashMap<Par,String> map = new HashMap<>();

        map.put(new Par(5,4), "Hola");
        System.out.println(map.getOrDefault(new Par(5,4),"Null"));
        map.put(new Par(4,5), "Adios");
        map.put(new Par(5,4), "Jorl");
        map.put(new Par(2,10), "Meh");


        System.out.println(map.size());
        System.out.println(map.getOrDefault(new Par(5,4),"Null"));
        System.out.println(map.getOrDefault(new Par(4,5),"Null"));
        System.out.println(map.getOrDefault(new Par(2,10),"Null"));
    }

    public static void jorl() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            String[] str = br.readLine().split(" ");
            int n = 0;
            System.out.println(str.length);
            for (int j = 0; j < str.length; j++) {
                System.out.print(n + " ");
                n += Integer.parseInt(str[j]);
            }
            System.out.println();

        }
    }

    public static void tihnh(){
        String str = "";

        int[] arr = {0,8, 15, 24, 32, 39, 48, 56, 63};

        for (int i = 1; i < arr.length; i++) {
            str+=(char)((arr[i]-arr[i-1])+48);
        }

        System.out.println(str);
    }

    public static int indexMax(ArrayList<Integer> array, Integer elem){
        int index = 0;
        while(index < array.size() && array.get(index) <= elem){
            index++;
        }
        return index;
    }

    public static int binaryMaxIndex(ArrayList<Integer> array, Integer elem, int low, int up){


        if(low+1 == up)
            if(elem < array.get(low))
                return low;
            else
                return up;

        if(low == up)
            return low;

        int med = (low+up)/2;

        if(elem<array.get(med))
            return binaryMaxIndex(array,elem,low,med);
        else
            return binaryMaxIndex(array,elem,med,up);
    }



    public static int numOr(int a, int b){
        int prod = a * b;

        if(prod<0)
            return 1;

        return a > 0 ? 1:-1;
    }
}