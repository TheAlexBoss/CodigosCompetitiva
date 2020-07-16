package CP20200424;

import java.util.Scanner;

public class I {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int N = scn.nextInt();

        for (int i = 0; i < N; i++) {
            String s = scn.next();
            int[] res = rec(s, 0, s.length()-1);
            System.out.println((res[0] + res[1]) + " " + res[0] + " " + res[1]);
        }
    }


    public static int[] rec(String s, int ini, int fin){
        int cero = 0;
        int uno = 0;
        int mid = (ini + fin + 1)/2;

        boolean m1 = sameColor(s, ini, mid-1);
        boolean m2 = sameColor(s, mid, fin);

        if(m1 && m2 && s.charAt(ini) == s.charAt(fin)){
            if(s.charAt(ini) == '0')
                return new int[]{1, 0};
            return new int[]{0, 1};
        }

        if(m1){
            if(s.charAt(ini) == '0'){
                cero++;
            }else{
                uno++;
            }
        }else{
            int[] res = rec(s, ini, mid-1);
            cero += res[0];
            uno += res[1];
        }

        if(m2){
            if(s.charAt(mid) == '0'){
                cero++;
            }else{
                uno++;
            }
        }else{
            int[] res = rec(s, mid, fin);
            cero += res[0];
            uno += res[1];
        }

        return new int[]{cero, uno};
    }

    public static boolean sameColor(String s, int ini, int fin){
        char color = s.charAt(ini);
        for (int i = ini+1; i <= fin; i++) {
            if(s.charAt(i) != color)
                return false;
        }
        return true;
    }
}
