package adatraining;

import java.io.*;

public class buhos {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while(!(line = br.readLine()).equals("XXX")){
            int i = 0, j = line.length()-1;
            boolean pal = true;
            while(pal && i<=j){

                while(line.charAt(i) == ' ')
                    i++;

                while(line.charAt(j) == ' ')
                    j--;

                pal = (Character.toLowerCase(line.charAt(i)) == Character.toLowerCase(line.charAt(j)));
                i++;
                j--;
            }

            if(pal)
                pw.println("SI");
            else
                pw.println("NO");
        }
        pw.flush();
    }
}
