package com.company;

        import java.io.*;

public class metro {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] init = br.readLine().split(" ");
            String[] str = br.readLine().split(" ");
            int originalDistance = Integer.parseInt(init[0]);

            int l,d,distance = originalDistance;
            for (int j = 0; j < 2*Integer.parseInt(init[1]) && distance > 0; j+=2) {
                int refactor = (originalDistance-distance);
                l = Integer.parseInt(str[j]) - refactor;
                d = Integer.parseInt(str[j+1]);

                if(l+d>=0 && l-d <= 0){
                    distance-=(l+d);
                }
            }

            if(distance<=0)
                pw.println("SI");
            else
                pw.println("NO");
        }

        pw.flush();
    }
}
