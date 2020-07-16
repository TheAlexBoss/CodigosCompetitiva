package codeF161119;

import java.io.*;
import java.util.HashSet;

public class D {
    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> connected = new HashSet<>();
        HashSet<Integer> withoutNext = new HashSet<>();


        String[] str = br.readLine().split(" ");
        int n  = Integer.parseInt(str[0]);
        int m  = Integer.parseInt(str[1]);

        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);

            connected.add(u);
            connected.add(v);

            if(u+1 == v){
                if(withoutNext.contains(u))
                    withoutNext.remove(u);
                withoutNext.add(v);
            }else if(v+1 == u){
                if(withoutNext.contains(v))
                    withoutNext.remove(v);
                withoutNext.add(u);
            }else{
                withoutNext.add(u);
                withoutNext.add(v);
            }





        }


    }
}
