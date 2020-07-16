package com.company;

import java.io.*;
import java.util.*;

public class perlas {

    //AER 399: https://www.aceptaelreto.com/problem/statement.php?id=399

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out), false);

        HashMap<Long, Integer> map;
        HashSet<Long> oddSet;
        TreeSet<Long> set;

        String str;
        String[] strings;
        long n;

        while(!(str = br.readLine()).equals("0")){
            set = new TreeSet<>();
            oddSet = new HashSet<>();
            map = new HashMap<>();
            strings = str.split(" ");

            for(int i = 0; i < strings.length-1; i++) {
                n = Long.parseLong(strings[i]);
                int getter = getOrDefault(map, n, 0);
                map.put(n, getter + 1);

                if(getter == 0){
                    set.add(n);
                }

                if(getter % 2 == 0){
                    oddSet.add(n);
                }else{
                    oddSet.remove(n);
                }
            }

            if(oddSet.size() >= 2 || (strings.length-1) % 2 == 0){
                pw.println("NO");
                continue;
            }

            Iterator<Long> it = set.iterator();
            long i;
            if(it.hasNext()){
                i = it.next();
                pw.print(i);
                map.put(i,map.get(i)-1);
            }

            while(it.hasNext()){
                i = it.next();
                pw.print(" " + i);
                map.put(i,map.get(i)-1);
            }

            it = set.descendingIterator();

            while(it.hasNext()){
                i = it.next();
                int valueI = map.get(i);
                if(valueI > 0){
                    pw.print(" " + i);
                    map.put(i, valueI-1);
                }
            }

            pw.println();
        }

        pw.flush();
    }


    public static Integer getOrDefault(HashMap<Long, Integer> map, long get ,int def){

        Integer i = map.get(get);

        return (i != null) ? i : def;
    }
}
