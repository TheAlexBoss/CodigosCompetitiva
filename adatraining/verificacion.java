package adatraining;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Scanner;

public class verificacion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);


        while(scn.hasNext()){
            int gA = scn.nextInt();
            int gB = scn.nextInt();
            ArrayDeque<Struct> cola = new ArrayDeque<>();

            for (int i = 0; i < gA; i++) {
                cola.offer(new Struct(scn.nextInt(), scn.nextInt()));
            }


            long result = 0;
            for (int i = 0; i < gB; i++) {
                long reps = scn.nextInt();
                long n = scn.nextInt();

                Struct next = cola.peek();

                if(next.reps == reps){
                    result += ((n * next.n)*next.reps);
                    cola.poll();
                }else if(next.reps > reps){
                    result += ((n * next.n)*reps);
                    next.reps -= reps;
                    if(next.reps <= 0)
                        cola.poll();
                }else{ // <
                    while(reps > 0){
                        if(next.reps == reps){
                            result += ((n * next.n)*next.reps);
                            cola.poll();
                            reps = 0;
                        }else if(next.reps > reps){
                            result += ((n * next.n)*reps);
                            next.reps -= reps;
                            reps = 0;
                            if(next.reps == 0)
                                cola.poll();
                        }else{
                            result += (n*next.n)*next.reps;
                            reps -= next.reps;
                            cola.poll();
                            next = cola.peek();
                        }
                    }
                }

            }
            System.out.println(result);
        }

    }
}

class Struct{
    long reps, n;

    public Struct(long reps, long n) {
        this.reps = reps;
        this.n = n;
    }
}