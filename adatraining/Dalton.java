package adatraining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Dalton {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);

        int N;

        while((N = scn.nextInt()) != 0){
            BigInteger a = new BigInteger(scn.next()), next;
            boolean daltonA = true, daltonB = true;
            for (int i = 1; i < N; i++) {
                next = new BigInteger(scn.next());
                int comp = a.compareTo(next);
                if(comp >= 0) {
                    daltonA = false;
                }
                if(comp <= 0){
                    daltonB = false;
                }
                a = next;
            }

            if(daltonA || daltonB)
                System.out.println("DALTON");
            else{
                System.out.println("DESCONOCIDOS");
            }

        }


    }
}
