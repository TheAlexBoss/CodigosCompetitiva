//  Votaciones Capicuas ACEPTA EL RETO
//  https://www.aceptaelreto.com/problem/statement.php?id=500&cat=114
//  NO EFICIENTE
import java.util.Scanner;

public class capicua {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int N = Integer.parseInt(scn.next());
        int Q = Integer.parseInt(scn.next());
        int si, no;
        String F,C;
        int co;

        while(N!=0 && Q!= 0){
            co = 0;
            System.out.print(N + " " + Q + " ");
            for(int i = Q;i<=N;i++){
                for(int j = 0;j<i;j++){
                    F = conv(j);
                    C = conv(i-j);

                    if(F.equals(rev(C))){
                        co++;
                    }
                }
            }
            System.out.println(co);
            N = Integer.parseInt(scn.next());
            Q = Integer.parseInt(scn.next());
        }
    }

    public static String conv(int num){
        if(num/10 < 1){//1 cifra
            return "000"+num;
        }else if(num/100 < 1){//2 cifras
            return "00"+num;
        }else if(num/1000 <1){//3 cifras
            return "0"+num;
        }else{//4 cifras
            return ""+num;
        }

    }

    public static String rev(String str){
        return "" + str.charAt(3) + str.charAt(2) +str.charAt(1) +str.charAt(0);

    }

}
