package clasificatorioSWERC19;

import java.io.*;
import java.util.TreeMap;

public class D {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        TreeMap<Integer,Integer> map = new TreeMap<>();


        for (int i = 0; i < T; i++) {
            String[] str = br.readLine().split(" ");

            if (str[0].equals("i")) {

                map.put(Integer.parseInt(str[1]),Integer.parseInt(str[2]));

            }else{//t
                try{
                    int X = map.ceilingKey(Integer.parseInt(str[1]));
                    int Y = map.get(X);

                    if(Y<Integer.parseInt(str[2]))
                        pw.println("WE NEED A BIGGER HOLE");
                    else
                        pw.println("OK");
                }catch(NullPointerException e){
                    pw.println("WE NEED A BIGGER HOLE");
                }


            }
        }
        pw.flush();
    }
}
