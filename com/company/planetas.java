package com.company;

import java.io.*;
import java.math.BigInteger;
import java.util.HashSet;

public class planetas {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        String line;
        String[] lines;
        BigInteger result;


        while (!(line = br.readLine()).equals("0")) {
            lines = br.readLine().split(" ");
            int N = Integer.parseInt(line);
            result = BigInteger.ONE;

            for (int i = 0; i < N; i++) {
                result = result.multiply(new BigInteger(lines[i])).divide(result.gcd(new BigInteger(lines[i])));
            }

            pw.println(result);
        }
        pw.flush();
    }

}
