package adatraining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;

public class EMayo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str;

        str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        double[] v = new double[N];
        double[] w = new double[N];
        double ratio, max_ratio = Double.MIN_VALUE, min_ratio = Double.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            v[i] = Double.parseDouble(str[0]);
            w[i] = Double.parseDouble(str[1]);
            ratio = v[i]/w[i];

            max_ratio = Math.max(max_ratio, ratio);
            min_ratio = Math.min(min_ratio, ratio);
        }

        double sol = realBinarySearch(min_ratio, max_ratio,v,w,k);
        DecimalFormat df = (DecimalFormat) DecimalFormat.getNumberInstance(Locale.US);
        df.applyPattern("#.######");
        System.out.println(df.format(sol));
    }

    public static double realBinarySearch(double min, double max, double[] v, double[] w, int k){
        double mid;

        // Busqueda binaria acotada
        for (int i = 0; i < 50; i++) {
            mid = (min + max)/2;
            if(possibleHappyness(v,w,mid,k))
                min = mid;
            else
                max=mid;
        }

        return min;
    }


    public static boolean possibleHappyness (double[] v, double[] w, double alpha, int k){
        double result = 0;

        LinkedList<Double> results = new LinkedList<>();
        for (int i = 0; i < v.length; i++)
            results.add((v[i] - alpha*w[i]));

        Collections.sort(results, Collections.reverseOrder());

        int i = 0;
        for (double r: results){
            result += r;
            i++;
            if(i >= k)
                break;
        }

        return result > 0;
    }
}
