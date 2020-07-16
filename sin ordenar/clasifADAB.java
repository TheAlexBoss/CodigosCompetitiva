package com.company;

import java.util.*;

public class clasifADAB {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int I = scn.nextInt(), L = scn.nextInt(), R = scn.nextInt();
        PolarPoint[] locations = new PolarPoint[L];
        ArrayList<PolarPoint> interest = new ArrayList<>(2*I);

        for (int i = 0; i < I; i++) {
            PolarPoint point = new PolarPoint(scn.nextInt(), scn.nextInt());
            interest.add(point);
            interest.add(new PolarPoint(point));
        }

        for (int i = 0; i < L; i++) {
            locations[i] = new PolarPoint(scn.nextInt(), scn.nextInt());
        }


        int max = 0, localMax;
        for (int i = 0; i < L; i++) {

            HashSet<PolarPoint> set = new HashSet<>(I);
            for (PolarPoint p: interest) {
                if(!set.contains(p)){
                    set.add(p);
                    p.toPolar(locations[i]);
                }else{
                    p.toPolar(locations[i], 2*Math.PI);
                }
            }
            Collections.sort(interest);

            int inicio = 0, fin = 0, veo;
            localMax = 0;
            while(inicio < 2*I && fin < 2*I){

                inicio = Math.min(inicio, interest.size()-1);
                fin = Math.min(fin, interest.size()-1);

                if(interest.get(fin).t - interest.get(inicio).t < Math.PI){
                    veo = 0;
                    for (int j = inicio; j <= fin; j++) {
                        if(interest.get(j).isVisible(R)){
                            veo++;
                        }
                    }

                    localMax = Math.max(localMax, veo);
                    fin++;
                }else{
                    inicio++;
                }
            }

            max = Math.max(max, localMax);

        }
        System.out.println(max);
    }
}

class PolarPoint implements Comparable<PolarPoint>{
    double r, t;
    PolarPoint reference;
    double x,y;

    public PolarPoint(double x, double y){
        this.x = x;
        this.y = y;
    }

    public PolarPoint(PolarPoint point){
        this.x = point.x;
        this.y = point.y;
    }

    public boolean isVisible(double r){
        return this.r <= r;
    }

    public void toPolar(double theta){
        this.r = this.distance(this.reference);
        this.t = this.angle(this.reference);
        this.t += theta;
    }

    public void toPolar(PolarPoint point, double offset){
        this.reference = point;
        this.toPolar(offset);
    }

    public void toPolar(PolarPoint point){
        this.toPolar(point,0);
    }

    private double distance(PolarPoint point){
        return Math.sqrt(Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2));
    }

    private double angle(PolarPoint point){
        /*int factor = 0;

        if(this.x - point.x < 0 && this.y - point.y >= 0)
            factor = 1;
        else if(this.x - point.x < 0 && this.y - point.y < 0)
            factor = 2;
        else if(this.x - point.x >= 0 && this.y - point.y < 0)
            factor = 3;

        return (Math.PI/2)*factor + Math.asin(Math.abs((point.y-this.y))/this.r);*/
        return Math.atan2(this.y - point.y,this.x - point.x);
    }

    @Override
    public int compareTo(PolarPoint o) {
        return Double.compare(this.t, o.t);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolarPoint that = (PolarPoint) o;
        return Double.compare(that.x, x) == 0 &&
                Double.compare(that.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}