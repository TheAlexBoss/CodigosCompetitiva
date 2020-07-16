package adatraining;

import java.util.Scanner;

public class becarios {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        while(scn.hasNext()){
            int K = scn.nextInt();

            int total = cuenta(scn.nextInt(), scn, K, 0);
            System.out.println(total);
        }

    }
    
    
    public static int cuenta(int n, Scanner scn, int k, int profundo){
        int total = 0;

        if(n == 0){
            if(profundo >= k)
                return 1;
            return 0;
        }

        for (int i = 0; i < n; i++) {
            int s = scn.nextInt();
            total += cuenta(s, scn, k, profundo+1);
        }
        return total;
    }
}
