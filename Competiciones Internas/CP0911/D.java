package CP0911;

import java.io.*;

public class D {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);

        int N;
        while((N = Integer.parseInt(br.readLine())) != 0){
            String[] str = br.readLine().split(" ");
            int posicion = 0;
            for (int i = 0; i < N; i++) {
                if(str[i].equals("left")){
                    posicion++;
                }else{
                    posicion--;
                }

            }

            pw.println(posicion);
        }
        pw.flush();
    }
}
