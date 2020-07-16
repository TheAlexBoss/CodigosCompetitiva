//  Se supone que es muy optimo, pero da TIMELIMIT

package ED;

import java.util.Scanner;

public class Rango {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        int N,Q,ini,fi;
        int sumas[];
        for(int i=0;i<T;i++){
            N = scn.nextInt();
            sumas = new int[N+1];
            sumas[0] = 0;
            for(int j = 0;j<N;j++){
                sumas[j+1] = sumas[j] + scn.nextInt();
            }

            Q = scn.nextInt();

            for(int j = 0;j<Q;j++){
                ini = scn.nextInt();
                fi = scn.nextInt();

                System.out.println(sumas[fi]-sumas[ini-1]);
            }

            if(i<T-1){
                System.out.println("---");
            }

        }
    }
}
