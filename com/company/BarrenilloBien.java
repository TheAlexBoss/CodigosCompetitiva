package com.company;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;

public class BarrenilloBien {
    public static void main(String[] args) {
        TreeMap<Long, Integer> map;
        Scanner scn = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int N;
        long x,y;

        while((N = scn.nextInt()) != 0){
            map = new TreeMap<>();
            for (int i = 0; i < N; i++) {
                x = scn.nextInt();
                y = scn.nextInt();
                if(x-y < 0)
                    addPut(map,0,true);
                else
                    addPut(map,x-y,true);
                addPut(map,x+y+1,false);
            }

            long max = 0, ac = 0;
            for(Integer i: map.values()){
                ac += i;
                max = Math.max(max, ac);
            }
            pw.println(max);
        }

        pw.flush();

    }


    public static void addPut(TreeMap<Long,Integer> map, long key, boolean add){
        if(!map.keySet().contains(key))
            if(add)
                map.put(key,1);
            else
                map.put(key,-1);
        else if(add)
            map.put(key, map.get(key) + 1);
        else
            map.put(key, map.get(key) - 1);
    }
}
