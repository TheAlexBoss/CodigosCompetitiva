package adatraining;

import java.util.Scanner;

public class boda {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int lect;
        while((lect = scn.nextInt()) != 0){
            int total = 0;
            for (int i = 0; i < lect; i++) {
                total += scn.nextInt();
            }

            System.out.println(total);
        }
    }
}
