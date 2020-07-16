package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class mejillones {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        Scanner scn = new Scanner(System.in);
        ArrayList<Integer> montones;

        int N;
        while(scn.hasNext()){
            N = scn.nextInt();
            montones = new ArrayList<>(N);

            for (int i = 0; i < N; i++) {
                int size = scn.nextInt();
                int index = binaryMaxIndex(montones,size,0,montones.size());
                if(index == montones.size())
                    montones.add(size);
                else
                    montones.set(index,size);
            }

            pw.println(montones.size());
        }

        pw.flush();

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


}
