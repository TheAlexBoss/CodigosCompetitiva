package adatraining;

import java.util.ArrayDeque;
import java.util.Scanner;

public class antepasadoChungo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int C = scn.nextInt();

        for (int i = 0; i < C; i++) {
            int max = scn.nextInt();
            int P = scn.nextInt();
            int[] array = new int[P];
            int[] sumArray = new int[P];
            boolean posible = true;

            for (int j = 0; j < P; j++) {
                array[j] = scn.nextInt();

                if(j == 0)
                    sumArray[j] = array[j];
                else
                    sumArray[j] = sumArray[j-1] + array[j];

                if (array[j] > max) {
                    posible = false;
                    break;
                }
            }

            //Tamaños ventana
            ArrayDeque<Window> stack = new ArrayDeque<>();
            int window = 0, size = 0;
            boolean flag = true;
            for (int j = 0; j < P && flag; j++) {
                window += array[j];

                if(j > 0)
                    window++;

                if(window > max)
                    flag = false;

                if(flag)
                    stack.push(new Window(window, j+1));
            }


            int tamñoFinal = 0;
            Window w;
            posible = false;
            while(!stack.isEmpty() && !posible){
                w = stack.pop();
                posible = true;
                for (int j = 0; j < P && posible; j+=w.index) {
                    int inicio = j;
                    int fin = j+w.index-1;
                    int tamaño;

                    if(fin >= sumArray.length){
                        posible = false;
                    }else{
                        if(inicio == 0){
                            tamaño = sumArray[fin]+(fin-inicio);
                        }else{
                            tamaño = sumArray[fin]-sumArray[inicio-1]+(fin-inicio);
                        }

                        if(tamaño > w.size){
                            posible = false;
                        }
                    }
                }

                if(posible)
                    tamñoFinal = w.size;
            }

            if(posible)
                System.out.println(tamñoFinal);
            else
                System.out.println("IMPOSIBLE");

        }
    }
}

class Window{
    int size;
    int index;

    public Window(int size, int index) {
        this.size = size;
        this.index = index;
    }
}