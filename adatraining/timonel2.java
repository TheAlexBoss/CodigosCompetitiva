package adatraining;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class timonel2 {
    final static int INF = Integer.parseInt("3F3F3F3F", 16);

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scn = new Scanner(System.in);

        int N;
        while ((N = scn.nextInt()) != 0) {

            if (N == 2) {
                System.out.println(new BigInteger(Integer.toString(scn.nextInt())).multiply(new BigInteger(Integer.toString(scn.nextInt()))));
            } else if (N == 3) {
                int positivos = 0, negativos = 0;
                int[] pos = new int[3];
                int[] neg = new int[3];

                for (int i = 0; i < N; i++) {
                    int a = scn.nextInt();
                    if (a >= 0) {
                        pos[positivos] = a;
                        positivos++;
                    } else {
                        neg[negativos] = a;
                        negativos++;
                    }
                }

                if (positivos > negativos) {
                    System.out.println(new BigInteger(Integer.toString(pos[0])).multiply(new BigInteger(Integer.toString(pos[1]))));
                } else {
                    System.out.println(new BigInteger(Integer.toString(neg[0])).multiply(new BigInteger(Integer.toString(neg[1]))));
                }
            } else {
                int max_positive_a = -INF, max_positive_b = -INF, min_positive = INF;
                int min_negative_a = INF, min_negative_b = INF, max_negative = -INF;
                boolean positive = false, negative = false;


                for (int i = 0; i < N; i++) {
                    int a = scn.nextInt();
                    if (a >= 0) {
                        positive = true;
                        max_positive_a = Math.max(max_positive_a, a);
                        min_positive = Math.min(min_positive, a);
                        if (a < max_positive_a) {
                            max_positive_b = Math.max(max_positive_b, a);
                        }
                    } else {
                        min_negative_a = Math.min(min_negative_a, a);
                        max_negative = Math.max(max_negative, a);
                        if (a > min_negative_a) {
                            min_negative_b = Math.min(min_negative_b, a);
                        }
                        negative = true;
                    }
                }


                BigInteger bigInf = new BigInteger("-3F3F3F3F", 16);
                BigInteger mult_positive = bigInf, mult_negative = bigInf, mult_mix = bigInf;

                if (positive)
                    mult_positive = new BigInteger(Integer.toString(max_positive_a)).multiply(new BigInteger(Integer.toString(max_positive_b)));

                if (negative)
                    mult_negative = new BigInteger(Integer.toString(min_negative_a)).multiply(new BigInteger(Integer.toString(min_negative_b)));

                if (positive && negative)
                    mult_mix = new BigInteger(Integer.toString(min_negative_a)).multiply(new BigInteger(Integer.toString(min_negative_b)));

                if (positive && !negative)
                    System.out.println(mult_positive);
                else if (!positive && negative)
                    System.out.println(mult_negative);
                else
                    System.out.println(mult_positive.max(mult_negative).max(mult_mix));
            }
        }
    }
}