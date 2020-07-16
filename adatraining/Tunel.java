package adatraining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tunel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lect;

        while((lect = br.readLine()) != null && !lect.equals("")){
            int[] izda = new int[lect.length()];

            int last_T_izda = 0, last_T_dcha = 0;
            for (int i = 0; i < lect.length(); i++) {
                if (lect.charAt(i) == 'T') {
                    last_T_izda = 0;
                    izda[i] = 0;
                } else {
                    last_T_izda++;
                    izda[i] = last_T_izda;
                }
            }

            for (int i = 0; i < lect.length(); i++) {
                if (lect.charAt(lect.length() - 1 - i) == 'T') {
                    last_T_dcha = 0;
                    izda[lect.length() - 1 - i] = 0;
                } else {
                    last_T_dcha++;
                    izda[lect.length() - 1 - i] -= last_T_dcha;
                }
            }

            int casos = Integer.parseInt(br.readLine());

            for (int i = 0; i < casos; i++) {
                int index = Integer.parseInt(br.readLine());

                if(izda[index-1] == 0 && lect.charAt(index-1) == 'T'){
                    System.out.println("AQUI");
                }else if(izda[index-1] == 0){
                    if(index-1 <= lect.length()-index){
                        System.out.println("PENINSULA");
                    }else{
                        System.out.println("ISLAS");
                    }
                }else if(izda[index-1] > 0){
                    System.out.println("ISLAS");
                }else{//iz<de
                    System.out.println("PENINSULA");
                }
            }
        }
    }
}
