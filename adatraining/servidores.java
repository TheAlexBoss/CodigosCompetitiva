package adatraining;

import java.util.Scanner;

public class servidores {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        for (int i = 0; i < T; i++) {
            String input = scn.next();
            int max = 0, min = 0, actual = 0;

            for (int j = 0; j < input.length(); j++) {
                if(input.charAt(j) == 'I'){
                    actual++;
                }else if(input.charAt(j) == 'O'){
                    actual--;
                }

                if(actual<0){
                    min = Math.min(min, actual);
                }else{
                    max = Math.max(max, actual);
                }

            }

            System.out.println(max-min);
        }
    }
}
