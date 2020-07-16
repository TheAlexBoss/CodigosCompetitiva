package clasificatoriaSWERC2018;

import java.io.*;

public class D {
    static int contador_cuantico = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),true);

        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);



        String[][] photo = new String[N][];
        for (int i = 0; i < N; i++) {
            photo[i] = br.readLine().split(" ");
        }

        if(N == 1 || M == 1)
            pw.println("0");
        else{
            int[][] cumuledSums = cumuledSumMatrix(photo);
            int xi,xj;
            int auxi, auxj;
            int galaxys = 0;

            for (int i = 1; i < N; i++) {
                for (int j = 1; j < M; j++) {
                    if(photo[i][j].equals("0")){
                        //Buscamos pa abajo
                        xi = i - 1;
                        xj = j - 1;
                        auxi = i;
                        auxj = j;
                        while(auxi < N && auxj < M && photo[auxi][auxj].equals("0")){
                            auxi++;
                            auxj++;
                        }

                        if(numOfOnes(cumuledSums,i,j,auxi-1,auxj-1) == 0){
                            galaxys = recubrimientos(galaxys,cumuledSums,xi,xj,auxi,auxj);
                        }
                    }
                }
            }

            pw.println(galaxys);
        }

    }

    public static int recubrimientos(int galaxys,int[][] matrix, int xi, int xj, int yi, int yj){
        //Sin marcar los 0s.
        boolean hayRecubrimiento = true;
        int newGalaxys = galaxys;
        int cont = 1;

        while(hayRecubrimiento && xi >= 0 && xj >= 0 && yi < matrix.length && yj < matrix[0].length){

           hayRecubrimiento = (newGalaxys = isValid(cont,galaxys,matrix,xi,xj,yi,yj)) != galaxys;
           galaxys = newGalaxys;
           cont++;

            xi--;
            xj--;
            yi++;
            yj++;
        }
        return newGalaxys;
    }

    public static int isValid(int i,int galaxys,int[][] matrix, int xi, int xj, int yi, int yj){
        int n = Math.abs(yj-xj+1);
        int n2 = Math.abs(yi-xi+1);

        if(n != n2)
            return galaxys;


        int zeros = (int) Math.pow(n-2*i,2);
        int nPow2 = (int) Math.pow(n,2);

        if(numOfOnes(matrix,xi,xj,yi,yj) + zeros == nPow2){
            galaxys++;
        }



        return galaxys;
    }

    public static int numOfOnes(int[][] matrix, int xi, int xj, int yi, int yj ){
        int result = matrix[yi][yj];

        if(xi>0)
            result -= matrix[xi-1][yj];
        if(xj>0)
            result -= matrix[yi][xj-1];
        if(xi > 0 && xj > 0)
            result += matrix[xi-1][xj-1];

        return result;
    }

    public static int[][] cumuledSumMatrix(String[][] matrixInput){
        int[][] matrix = new int[matrixInput.length][matrixInput[0].length];

        int ansC = 0, ansF;
        for (int i = 0; i < matrix.length; i++) {
            ansF = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if(i>0)
                    ansC = matrix[i-1][j];

                if(i>0 && j>0)
                    matrix[i][j] = ansC + ansF + Integer.parseInt(matrixInput[i][j]) - matrix[i-1][j-1];
                else
                    matrix[i][j] = ansC + ansF + Integer.parseInt(matrixInput[i][j]);

                ansF = matrix[i][j];
            }
        }
        return matrix;
    }
}
