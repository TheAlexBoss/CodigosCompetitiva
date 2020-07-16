package adatraining;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class timonel {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scn = new Scanner(System.in);

        int N;
        while((N = scn.nextInt()) != 0){
            ArrayList<Integer> negs = new ArrayList<>(N/2);
            ArrayList<Integer> array = new ArrayList<>(N/2);
            for (int i = 0; i < N; i++) {
                int a = scn.nextInt();
                if(a < 0) {
                    negs.add(a);
                }else{
                    array.add(a);
                }
            }
            Collections.sort(array, Collections.reverseOrder());
            Collections.sort(negs);

            //System.err.println(array);
            //System.err.println(negs);
            BigInteger integer, maxN, max;

            if(N == 2 && array.size() == 1 && negs.size() == 1){
                integer = new BigInteger(Integer.toString(array.get(0)));
                max = integer.multiply(new BigInteger(Integer.toString(negs.get(0))));
                System.out.println(max);
            }else{
                if(array.size() >= 2){
                    integer = new BigInteger(Integer.toString(array.get(0)));
                    max = integer.multiply(new BigInteger(Integer.toString(array.get(1))));
                }else if(array.size() == 1 && negs.size() > 0){
                    max = new BigInteger(Integer.toString(array.get(0))).multiply(new BigInteger(Integer.toString(negs.get(0))));
                }else{
                    max = new BigInteger("-3F3F3F3F",16);
                }

                if(negs.size() >= 2){
                    integer = new BigInteger(Integer.toString(negs.get(0)));
                    maxN = integer.multiply(new BigInteger(Integer.toString(negs.get(1))));
                }else if(negs.size() == 1 && array.size() > 0){
                    maxN = new BigInteger(Integer.toString(negs.get(0))).multiply(new BigInteger(Integer.toString(array.get(0))));
                }else{
                    maxN = new BigInteger("-3F3F3F3F",16);
                }
                System.out.println(max.max(maxN));
            }
        }
    }
}