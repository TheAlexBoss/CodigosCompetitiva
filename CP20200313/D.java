package CP20200313;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int N = scn.nextInt();
        int P = scn.nextInt();

        int[] files = new int[N];

        int min, max = 0, mid, ans;
        for (int i = 0; i < N; i++) {
            files[i] = scn.nextInt();
            max += files[i];
        }

        min = 16;
        mid = 0;
        ans = -1;
        int k, sum;
        while(mid != ans){
            ans = mid;
            mid = (min+max)/2;
            sum = 0;
            k = 1;
            for (int i = 0; i < N; i++) {
                if(sum+files[i] <= mid){
                    sum+=files[i];
                }else{
                    sum = 0;
                    k++;
                    i--;
                }
                if(k > P)
                    break;
            }

            if(k > P){
                min = mid;
            }else{
                max = mid;
            }
        }
        System.out.println(max);
    }
}
