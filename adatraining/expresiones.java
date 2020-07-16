package adatraining;

import java.util.LinkedList;
import java.util.Scanner;

public class expresiones {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        LinkedList<Integer> pila = new LinkedList<>(), cola = new LinkedList<>();

        while(scn.hasNext()){
            String lect = scn.next();
            boolean error_pila = false, error_cola = false;
            for (int i = 0; i < lect.length(); i++) {
                char mander = lect.charAt(i);
                if(mander >= 48 && mander <= 57){
                    pila.push((int) mander - 48);
                    cola.offer((int) mander - 48);
                }else{
                    int a_cola = 0, b_cola = 0, a_pila = 0, b_pila = 0;
                    try{
                        b_cola = cola.poll();
                        a_cola = cola.poll();
                    }catch (Exception ex){
                        error_cola = true;
                    }

                    try{
                        b_pila = pila.pop();
                        a_pila = pila.pop();
                    }catch (Exception ex){
                        error_pila = true;
                    }


                    switch (mander){
                        case '+':
                            if(!error_cola)
                                cola.offer(a_cola + b_cola);
                            if(!error_pila)
                                pila.push(a_pila + b_pila);
                            break;
                        case '-':
                            if(!error_cola)
                                cola.offer(a_cola - b_cola);
                            if(!error_pila)
                                pila.push(a_pila - b_pila);
                            break;
                        case '/':
                            if(b_cola == 0)
                                error_cola = true;

                            if(b_pila == 0)
                                error_pila = true;

                            if(!error_cola)
                                cola.offer(a_cola / b_cola);

                            if(!error_pila)
                                pila.push(a_pila / b_pila);
                            break;
                        case '*':
                            if(!error_cola)
                                cola.offer(a_cola * b_cola);
                            if(!error_pila)
                                pila.push(a_pila * b_pila);
                            break;
                        default:
                    }
                }
            }


            if(error_cola && error_pila){
                System.out.println("ERROR = ERROR");
            }else if(error_cola){
                int p = pila.pop();
                System.out.println(p + " != ERROR");
            } else if (error_pila) {
                int c = cola.poll();
                System.out.println("ERROR != " + c);
            }else{
                int c = cola.poll();
                int p = pila.pop();

                if(c == p){
                    System.out.println(p + " = " + c);
                }else{
                    System.out.println(p + " != " + c);
                }
            }
        }
    }
}
