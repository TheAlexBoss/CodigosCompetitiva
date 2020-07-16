package com.company;

import java.io.*;
import java.util.ArrayList;

public class reprografia {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;

        ArrayList<Integer> cycle, buffer;
        int pointer;
        String[] str;

        while((N = Integer.parseInt(br.readLine())) != 0){
            cycle = new ArrayList<>();
            buffer = new ArrayList<>();

            str =  br.readLine().split(" ");

            cycle.add(Integer.parseInt(str[1])- Integer.parseInt(str[0]));
            pointer = 0;

            for (int i = 2; i < N; i++) {
                int resta = Integer.parseInt(str[i])- Integer.parseInt(str[i-1]);
                if(resta == cycle.get(pointer)) {
                    buffer.add(resta);
                    pointer = (pointer + 1) % cycle.size();
                }else{
                    pointer = 0;
                    cycle.addAll(buffer);
                    buffer.clear();
                    cycle.add(resta);
                }
            }

            pw.println(Integer.parseInt(str[N-1]) + cycle.get(pointer));
        }

        pw.flush();

    }
}
