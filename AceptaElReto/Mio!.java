//  Mio! ACEPTA EL RETO
//  https://www.aceptaelreto.com/problem/statement.php?id=492&cat=114
//  Solucion no optima
import java.util.Scanner;
import java.lang.Math;

public class mio {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int[] caso = new int[3];
        int c;

        caso[0] = Integer.parseInt(scn.next());
        caso[1] = Integer.parseInt(scn.next());
        caso[2] = Integer.parseInt(scn.next());


        while((caso[0] + caso[1] + caso[2]) != 0){
            c = 0;
            for(int i = 1;i<=caso[2];i++){
                if(i%caso[0] == 0 && i%caso[1] == 0){
                    c++;
                }
            }
            System.out.println(c);
            
           /* INTENTO DE SOLUCION MAS OPTIMA (no funciona para muchos casos)
           if(caso[0]%caso[1] == 0 || caso[1]%caso[0] == 0){
            
                System.out.println(caso[2]/Math.max(caso[1],caso[0]));
            }else{
                System.out.println(caso[2]/(caso[0]*caso[1]));
            }
            */

            caso[0] = Integer.parseInt(scn.next());
            caso[1] = Integer.parseInt(scn.next());
            caso[2] = Integer.parseInt(scn.next());
        }

    }
}
