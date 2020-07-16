package com.company;

import java.io.*;

public class albergue {

    // AER 400 : https://www.aceptaelreto.com/problem/statement.php?id=400

    public static void main(String[] args) throws IOException{
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out), false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int cont, d;
        boolean flag;

        while((line = br.readLine()) != null && !line.equals("")){
            cont = 0;
            d = 0;
            flag = true;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if(c == 'X'){
                    if(flag){
                        flag = false;
                        d = Math.max(0, cont-1);
                        cont = 0;
                        continue;
                    }
                    if(cont % 2 == 0){
                        d = Math.max(d, cont/2 - 1);
                    }else{
                        d = Math.max(d, cont/2);
                    }
                    cont = 0;
                }else{
                    cont++;
                }
            }

            d = Math.max(d, cont-1);

            pw.println(d);

        }

        pw.flush();

    }
}
