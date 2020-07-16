package CP0911;

import java.io.*;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);

        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];

        int number=1;
        for (int i = 0; i < N/2; i++) {
            for (int j = i; j < N-i; j++) {
                matrix[i][j]=number;
                number++;
            }
            for (int j = i+1; j < N-i ; j++) {
                matrix[j][N-i-1] = number;
                number++;
            }

            for (int j = N-i-2; j >= i ; j--) {
                matrix[N-i-1][j] = number;
                number++;
            }

            for (int j = N-i-2; j > i ; j--) {
                matrix[j][i] = number;
                number++;
            }
        }
        if(N%2 == 1){
            matrix[N/2][N/2]= number;
        }

        for (int i = 0; i < N ; i++) {

            for (int j = 0; j < N ; j++) {
                pw.print(matrix[i][j]+" ");
            }
            pw.println();
        }

        pw.flush();
    }
}