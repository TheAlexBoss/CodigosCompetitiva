package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class tandem2 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int familiares, personas, start, end;
        long parejas, peso, P;
        ArrayList<Long> pesos = new ArrayList<>();

        while((familiares = scn.nextInt()) != 0 && (P = scn.nextLong()) != 0){
            pesos.clear();
            personas = 0;
            for (int i = 0; i < familiares; i++) {
                peso = scn.nextLong();
                if(peso <= P){
                    personas++;
                    pesos.add(peso);
                }
            }

            Collections.sort(pesos);

            parejas = 0;
            start = 0;
            end = personas-1;

            while(start < end){
                peso = pesos.get(start) + pesos.get(end);
                if(peso <= P){
                    parejas += (end - start);
                    start++;
                }else{
                    end--;
                }
            }
            System.out.println(parejas);
        }
    }
}