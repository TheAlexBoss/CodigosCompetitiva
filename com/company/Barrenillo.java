package com.company;

        import java.util.Scanner;

public class Barrenillo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int N = scn.nextInt();
        while(N != 0){
            Point[] arbol = new Point[N];

            int maxX = -1;
            for (int i = 0; i < N; i++) {
                arbol[i] = new Point(scn.nextInt(), scn.nextInt());
                maxX = Math.max(maxX, (int) arbol[i].x);
            }

            Point cam = new Point(0,0);
            int max = -1, veo;
            while(cam.x <= maxX){
                veo = 0;
                for (int i = 0; i < N; i++) {
                    if(cam.inRange(arbol[i]))
                        veo++;
                }
                max = Math.max(max, veo);
                cam.x++;
            }

            System.out.println(max);

            N = scn.nextInt();
        }
    }

    static class Point{
        double x,y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public boolean inRange(Point p){
            //RECTAS: con pendiente 1 y -1 que pasan por el punto p = (x,0);
            boolean a = (p.y > -p.x+this.x);
            boolean b = (p.y < p.x + this.x);
            return a && b;
        }
    }
}