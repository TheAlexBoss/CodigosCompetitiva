//  REPROGRAFIA ACEPTA EL RETO
//  https://www.aceptaelreto.com/problem/statement.php?id=494&cat=114
//  Wrong answer

import java.util.Scanner;

public class Reprografia {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int actual, anterior, ciclo;
        int n[];

        while(N !=0){
          	ciclo = 1;
            n = new int[N-1];
            anterior = 0;
            scn.nextInt();
          
            for(int i = 0;i<N-1;i++){
                actual = scn.nextInt();
                n[i] = actual-anterior;
                anterior = actual;

                if(i>ciclo && n[i] != n[i%ciclo]){
                    ciclo++;
                }

            }
            System.out.println(anterior + n[((N-1)%ciclo)]);

            N = scn.nextInt();

        }

    }
}
