package adatraining;

import java.util.Scanner;

public class cuadradoPerfecto {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int C = scn.nextInt();

        for (int i = 0; i < C; i++) {
            int N = scn.nextInt();

            System.out.println(factorize(N));
        }
    }

    public static int factorize(int n) {
        int result = 1;

        int t = 0, raiz;
        while (n % 2 == 0) {
            n /= 2;
            t++;
        }
        if(t%2 == 1)
            result *= 2;

        raiz = (int) Math.sqrt(n);
        for (int i = 3; i-1 <= raiz; i+=2) {
            if(n%i == 0){
                t = 0;
                while (n % i == 0) {
                    n /= i;
                    t++;
                }
                if(t%2 == 1)
                    result *= i;
                raiz = (int) Math.sqrt(n);
            }
        }

        result *= n;

        return result;
    }
}
