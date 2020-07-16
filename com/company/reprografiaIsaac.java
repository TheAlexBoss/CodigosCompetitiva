package com.company;

import java.io.*;

public class reprografiaIsaac {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out), false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        while((N = Integer.parseInt(br.readLine()))!=0){
            String[] str = br.readLine().split(" ");
            StringBuilder string = new StringBuilder();
            for (int i = 1; i < N; i++) {
                char append = (char) (Integer.parseInt(str[i]) - Integer.parseInt(str[i-1]) + 48);
                string.append(append);
            }

            int ciclo = ciclo(string.toString());
            int index = N % ciclo;

            index--;
            if(index == -1)
                index = ciclo-1;

            pw.println(Integer.parseInt(str[N-1]) - 48 + (int) string.charAt(index));

        }
        pw.flush();
    }

    public static int ciclo(String ciclo){

        boolean sigue = true;
        int i = 1;
        while(i<ciclo.length()){
            int aux = 0;
            for (int j = 0; j < ciclo.length() && sigue; j++){
                sigue = (ciclo.charAt(aux)==ciclo.charAt(j));
                aux = (aux+1)%i;
            }

            if(sigue)
                break;

            sigue = true;
            i++;
        }
        return i;
    }
}
