package adatraining;

import java.io.*;
import java.util.Scanner;

public class Fracciones2 {
    public static void main(String[] args) throws IOException{
        Scanner scn = new Scanner(System.in);

        while (scn.hasNext()){
            int N = scn.nextInt();
            int result = factorize(N);

            result = (result+1)/2;
            System.out.println(result);
        }
    }

    public static int factorize(int n) {
        int result = 1;

        int t = 0, raiz;
        while (n % 2 == 0) {
            n /= 2;
            t++;
        }
        result *= (2*t+1);

        raiz = (int) Math.sqrt(n);
        for (int i = 3; i-1 <= raiz; i+=2) {
            if(n%i == 0){
                t = 0;
                while (n % i == 0) {
                    n /= i;
                    t++;
                }
                result *= (2*t+1);
                raiz = (int) Math.sqrt(n);
            }
        }

        if (n > 1)
            result *= 3;
        return result;
    }
}