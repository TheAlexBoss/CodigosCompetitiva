package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class Elefantes {
    public static void main(String[] args) {
        tle();
    }

    public static void bien(){
        Scanner scn = new Scanner(System.in);
        int c;
        String lect;
        BigInteger sol, peso;

        while(!(lect = scn.next()).equals("0")){
            peso = new BigInteger(lect);
            sol = BigInteger.ZERO;
            c = 0;
            while(!(lect = scn.next()).equals("0")){
                sol = sol.add(new BigInteger(lect));
                if(sol.compareTo(peso) <= 0 )
                    c++;
            }
            System.out.println(c);
        }
    }

    public static void mal(){
        Scanner scn = new Scanner(System.in);
        int c;
        long lect;
        long sol, peso;

        while((peso = scn.nextLong()) != 0){
            sol = 0;
            c = 0;
            while((lect = scn.nextLong()) != 0){
                sol += lect;
                if(sol <= peso)
                    c++;
            }
            System.out.println(c);
        }
    }

    public static void tle(){
        Scanner scn = new Scanner(System.in);
        long c;
        long lect;
        long sol, peso = scn.nextLong();

        while(peso != 0){
            sol = 0;
            c = 0;
            lect = scn.nextLong();
            while(lect!= 0){
                sol += lect;
                if(sol <= peso)
                    c++;
                lect = scn.nextLong();
            }
            System.out.println(c);
            peso = scn.nextLong();
        }
    }
}
