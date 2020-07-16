package adatraining;

import java.text.DecimalFormat;
import java.util.*;

public class AEnero {


    static class Pair implements Comparable<Pair>{
        int first;
        double seccond;

        public Pair(int first, double seccond) {
            this.first = first;
            this.seccond = seccond;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.seccond == o.seccond)
                return this.first - o.first;
            return (int) (this.seccond-o.seccond);
        }

        @Override
        public String toString() {
            DecimalFormat df = (DecimalFormat) DecimalFormat.getNumberInstance(Locale.US);
            df.applyPattern("0.000000000000000");
            return first + " " + df.format(seccond);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scn.nextInt(), M = scn.nextInt(), K = scn.nextInt();

            double[][] matrix = new double[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    double prob = scn.nextInt();
                    prob /= 100;
                    matrix[j][k] = prob;
                }
            }

            double[][] MT = matrix_power(matrix, K, N);

            LinkedList<Pair> solucion = new LinkedList<>();
            for (int j = 0; j < M; j++) {
                int amigo = scn.nextInt();
                double p = findProbability(amigo, N, MT);

                if(p != 0)
                    solucion.add(new Pair(amigo, p));

            }
            Collections.sort(solucion);

            if(solucion.size() == 0)
                System.out.println("Hasta la vista, chaval!");
            else
                for(Pair p: solucion)
                    System.out.println(p);
        }


    }

    // Function to multiply two matrices A and B
    static double[][] multiply(double[][] A,
                               double[][] B, int N)
    {
        double[][] C = new double[N][N];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                for (int k = 0; k < N; ++k)
                    C[i][j] += A[i][k] * B[k][j];
        return C;
    }

    // Function to calculate the power of a matrix
    static double[][] matrix_power(double[][] M, int p, int n)
    {
        double[][] A = new double[n][n];
        for (int i = 0; i < n; ++i)
            A[i][i] = 1;

        while (p > 0)
        {
            if (p % 2 == 1)
                A = multiply(A, M, n);
            M = multiply(M, M, n);
            p /= 2;
        }
        return A;
    }

    static double findProbability(int F, int S, double[][] MT){
        return MT[F - 1][S - 1];
    }
}
