//  ABUELAS FALSAS ACEPTA EL RETO
//  https://www.aceptaelreto.com/problem/statement.php?id=446
//  SOLUCION BUENA

import java.util.Scanner;

public class abuelas {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();

        int i,F;

        for(int j = 0;j<N;j++){
            i =0;
            String real = scn.next();
            String anterior = "";
            F = Integer.parseInt(scn.next());

            while(i<F){
                anterior = scn.next();
                if(anterior.equals(real) && i+1<F){
                    anterior = "";
                    scn.nextLine();
                    break;
                }else{
                    i++;
                }

            }
            if(anterior.equals(real) && i>1){
                System.out.println("VERDADERA");
            }else{
                System.out.println("FALSA");
            }
        }


    }
}
