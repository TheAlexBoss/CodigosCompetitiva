package CP20200313;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scn.nextInt();
            int[] arr = new int[N];
            int sol = 0, temp;

            for (int j = 0; j < N; j++) {
                arr[j] = scn.nextInt();
            }

            for (int j = 0; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    if(arr[j] > arr[k]){
                        sol++;
                        temp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = temp;
                    }
                }
            }

            System.out.println(sol);
        }

    }
}
