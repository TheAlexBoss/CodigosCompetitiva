package com.company;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class perlas2 {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        boolean imprime;
        long n, x, k, max;
        int v;
        String s, cop;
        while ((n = sc.nextInt()) != 0) {
            imprime = true;
            s = "";
            TreeMap<Long, Integer> map = new TreeMap<>(Collections.reverseOrder());
            map.put(n, 1);
            while ((x = sc.nextInt()) != 0) {
                if (map.containsKey(x)) {
                    v = map.remove(x);
                    map.put(x, v + 1);
                } else {
                    map.put(x, 1);
                }
            }
            max = map.firstKey();
            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                k = entry.getKey();
                v = entry.getValue();
                if ((v % 2 != 0 && k != max) || (k == max && v % 2 == 0)) {
                    pw.println("NO");
                    imprime = false;
                    break;
                }
                if (k == max) {
                    s = s + String.format("%0" + v + "d", 0).replace("0", Long.toString(k) + " ");
                } else {
                    cop = String.format("%0" + v / 2 + "d", 0).replace("0", Long.toString(k) + " ");
                    s = cop + s + cop;
                }
            }
            if (imprime) {
                pw.println(s.substring(0, s.length() - 1));
            }
        }
        pw.flush();
    }
}