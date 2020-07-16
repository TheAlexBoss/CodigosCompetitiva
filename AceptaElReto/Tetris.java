package com.competitive;

//  Altura final en tetris (Acepta el Reto)
//  https://www.aceptaelreto.com/problem/statement.php?id=493&cat=114
//  No acabado, resultados erroneos

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int I,R,P;
        Map<Integer,Integer> mapa = new TreeMap<>();


        int C = Integer.parseInt(scn.next());
        int N = Integer.parseInt(scn.next());
        scn.nextLine();

        while(C!= 0 && N!=0){
            for(int i = 0; i<C;i++){
                mapa.put(i,0);
            }

            for(int i = 0; i<N;i++){
                I = Integer.parseInt(scn.next());
                R = Integer.parseInt(scn.next());
                P = Integer.parseInt(scn.next());
                scn.nextLine();

                alturas(I,R,P,mapa);
            }

            for(int i = 0;i<C;i++){
                System.out.print(mapa.get(i) + " ");
            }
            System.out.print("\n");

            C = Integer.parseInt(scn.next());
            N = Integer.parseInt(scn.next());
            scn.nextLine();
        }

    }

    public static void alturas(int I, int R, int P, Map<Integer,Integer> mapa){
        P--;
        switch(I){
            case 1:
                switch(R){
                    case 0:
                    case 180:
                        mapa.put(P+3,mapa.get(P) + 1);
                        mapa.put(P+2,mapa.get(P) + 1);
                        mapa.put(P+1,mapa.get(P) + 1);
                        mapa.put(P,mapa.get(P) + 1);
                        break;
                    case 90:
                    case 270:
                        mapa.put(P,mapa.get(P) + 4);
                        break;
                    default:
                        System.out.println("mal 1");
                }
                break;
            case 2:
                switch(R){
                    case 0:
                        mapa.put(P+2,mapa.get(P) + 2);
                        mapa.put(P+1,mapa.get(P) + 1);
                        mapa.put(P,mapa.get(P) + 1);
                        break;
                    case 90:
                        mapa.put(P+1,mapa.get(P) + 1);
                        mapa.put(P,mapa.get(P) + 3);
                        break;
                    case 270:
                        mapa.put(P+1,mapa.get(P) + 3);
                        mapa.put(P,mapa.get(P) + 3);
                        break;
                    case 180:
                        mapa.put(P+2,mapa.get(P) + 2);
                        mapa.put(P+1,mapa.get(P) + 1);
                        mapa.put(P,mapa.get(P) + 1);
                        break;
                    default:
                        System.out.println("mal 2");
                }
                break;
            case 3:
                switch(R){
                    case 0:
                        mapa.put(P+2,mapa.get(P) + 2);
                        mapa.put(P+1,mapa.get(P) + 1);
                        mapa.put(P,mapa.get(P) + 1);
                        break;
                    case 90:
                        mapa.put(P+1,mapa.get(P) + 3);
                        mapa.put(P,mapa.get(P) + 1);
                        break;
                    case 270:
                        mapa.put(P+1,mapa.get(P) + 1);
                        mapa.put(P,mapa.get(P) + 3);
                        break;
                    case 180:
                        mapa.put(P+2,mapa.get(P) + 1);
                        mapa.put(P+1,mapa.get(P) + 1);
                        mapa.put(P,mapa.get(P) + 2);
                        break;
                    default:
                        System.out.println("mal 3");
                }
                break;
            case 4:
                mapa.put(P+1,mapa.get(P) + 2);
                mapa.put(P,mapa.get(P) + 2);
                break;
            case 5:
                switch(R){
                    case 0:
                    case 180:
                        mapa.put(P+2,mapa.get(P) + 2);
                        mapa.put(P+1,mapa.get(P) + 2);
                        mapa.put(P,mapa.get(P) + 1);
                        break;
                    case 90:
                    case 270:
                        mapa.put(P+1,mapa.get(P) + 1);
                        mapa.put(P,mapa.get(P) + 2);
                        break;
                    default:
                        System.out.println("mal 4");
                }
                break;
            case 7:
                switch(R){
                    case 0:
                    case 180:
                        mapa.put(P+2,mapa.get(P+2) + 1);
                        mapa.put(P+1,mapa.get(P) + 2);
                        mapa.put(P,mapa.get(P) + 1);
                        break;
                    case 90:
                    case 270:
                        mapa.put(P+1,mapa.get(P) + 3);
                        mapa.put(P,mapa.get(P) + 2);
                        break;
                    default:
                        System.out.println("mal 4");
                }
                break;
            case 6:
                switch(R){
                    case 0:
                        mapa.put(P+2,mapa.get(P) + 1);
                        mapa.put(P+1,mapa.get(P) + 2);
                        mapa.put(P,mapa.get(P) + 1);
                        break;
                    case 180:
                        mapa.put(P+2,mapa.get(P) + 1);
                        mapa.put(P+1,mapa.get(P) + 1);
                        mapa.put(P,mapa.get(P) + 1);
                        break;
                    case 90:
                        mapa.put(P+1,mapa.get(P) + 2);
                        mapa.put(P,mapa.get(P) + 1);
                        break;
                    case 270:
                        mapa.put(P+1,mapa.get(P) + 2);
                        mapa.put(P,mapa.get(P) + 3);
                        break;
                    default:
                        System.out.println("mal 5");
                }
                break;
            default:
                System.out.println("mal 6");
        }
    }
}
