package com.company;

import java.io.*;
import java.util.*;

public class mediano {

    final static int INF = Integer.parseInt("3F3F3F3F",16);
    public static void main(String args[]) throws IOException {

        Scanner scn = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        PriorityQueue<Integer> pqD;
        PriorityQueue<Integer> pqA;

        int T, read, last = INF;
        boolean firstPrint, firstNumber;

        while(scn.hasNext()){
            T = scn.nextInt();
            firstPrint = true;
            firstNumber = true;
            pqD = new PriorityQueue(11, Collections.reverseOrder());
            pqA = new PriorityQueue();

            for (int i = 0; i < T; i++) {
                read = scn.nextInt();

                if(read == 0){
                    //ECSA

                    if(pqD.size() == 0 && pqA.size() == 0){
                        if(firstPrint){
                            pw.print("ECSA");
                            firstPrint = false;
                        }else{
                            pw.print(" ECSA");
                        }
                    }else{
                        int result;
                        if(pqD.size() < pqA.size())
                            result = pqA.poll();
                        else
                            result = pqD.poll();

                        if(firstPrint){
                            pw.print(result);
                            firstPrint = false;
                        }else{
                            pw.print(" "+result);
                        }
                    }

                }else{
                    //logica

                    if(firstNumber){
                        pqD.offer(read);
                        firstNumber = false;
                    }else{
                        if(read < last){
                            pqD.offer(read);
                        }else{
                            pqA.offer(read);
                        }
                    }


                }

                if(Math.abs(pqD.size()-pqA.size()) > 1)
                    if(pqD.size() > pqA.size())
                        pqA.offer(pqD.poll());
                    else
                        pqD.offer(pqA.poll());

                if(pqA.size() != 0)
                    last = pqA.peek();
                else
                    last = INF;
            }
            pw.println();
        }

        pw.flush();

    }
}