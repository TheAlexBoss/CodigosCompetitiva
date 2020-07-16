package adatraining;

import java.util.ArrayDeque;
import java.util.Scanner;

public class semaforos {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s;
        while(scn.hasNext()){
            s = scn.next();
            int R = 0, V = 0, A = 0;

            ArrayDeque<Character> pila = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {

                if(s.charAt(i)=='R'){
                    R++;
                    pila.push('R');
                }else if(s.charAt(i)=='A' && A<R && !pila.isEmpty() && pila.peek()!='A'){
                    A++;
                    pila.push('A');
                }else if(s.charAt(i)=='V' && R>0 && A>0 && !pila.isEmpty() && pila.peek()=='A'){
                    V++;
                    R--;
                    A--;
                    pila.pop();
                    pila.pop();
                }else {
                    R = 0;
                    A = 0;
                    pila.clear();
                }
            }
            System.out.println(V);
        }
    }
}
