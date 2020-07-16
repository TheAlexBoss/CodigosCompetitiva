package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class SWERC2019F {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        double result = 0;

        ArrayList<Point> array;

        for (int i = 0; i < N; i++) {
            int T = scn.nextInt();

            array = new ArrayList<>(T+1);
            for (int j = 0; j < T; j++)
                array.add(new Point(scn.nextLong(), scn.nextLong()));
            array.add(new Point(array.get(0).x, array.get(0).y));

            result += area(array);
        }

        System.out.println((long) Math.floor(result));
    }

    public static double area(ArrayList<Point> array){
        double ans = 0;

        for (int i = 0; i < array.size() - 1; i++)
            ans += array.get(i).x * array.get(i+1).y - array.get(i).y * array.get(i+1).x;

        double result = Math.abs(ans)/2;
        return result;
    }
}

class Point{
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double x,y;
}
