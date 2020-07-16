package com.company;

import java.io.*;

public class EspionajeNavidad {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        String str;
        char mander;

        while(!(str = br.readLine()).equals("FIN")){
            for (int i = 0; i < str.length(); i++) {
                mander = str.charAt(i);
                if(mander == ' '){
                    pw.print(' ');
                }else if(mander == 'Z'){
                    pw.print('A');
                }else{
                    pw.print((char) (mander + 1));
                }
            }
            pw.println();
        }
        pw.flush();
    }
}
