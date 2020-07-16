package clasificatorioSWERC19;

import java.io.*;
import java.util.HashMap;

public class A {
    static HashMap<Character,Integer> basics = new HashMap<>();

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        basics.put('I',1);
        basics.put('V',5);
        basics.put('X',10);
        basics.put('L',50);
        basics.put('C',100);
        basics.put('D',500);
        basics.put('M',1000);



        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            pw.println(translate(str));
        }

        pw.flush();
    }

    public static int translate(String str){
        int actual = basics.get(str.charAt(0));
        int next;
        int res = 0;

        for (int i = 1; i <str.length(); i++) {
            next = basics.get(str.charAt(i));

            if(actual<next)
                res-=actual;
            else
                res+=actual;
            actual = next;

        }

        res+= basics.get(str.charAt(str.length()-1));
        return res;
    }

}
