package adatraining;

import java.util.Scanner;

public class Relojes {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        while(scn.hasNext()){
            int A = scn.nextInt(), B = scn.nextInt(), C = scn.nextInt();

            if(A == 0 && B==0 && C == 0)
                break;

            int mcd = mcd(A, B, C);

            int sum = A/mcd + B/mcd + C/mcd;

            System.out.println(sum);

        }

    }


    public static int mcd(int A, int B , int C){
        int mcd = mcdIsaac(A, B);
        return mcdIsaac(mcd, C);
    }

    public static int mcd(int A, int B){
        int r = A%B;
        if(r==0)
            return B;

        return mcd(B, r);
    }

    public static int mcdIsaac(int A, int B){
        while (B > 0) {
            int temp = B;
            B = A % B;
            A = temp;
        }
        return A;
    }

}
