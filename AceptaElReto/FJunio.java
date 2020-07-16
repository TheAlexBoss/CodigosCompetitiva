package adatraining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Locale;

public class FJunio {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] str = br.readLine().split(" ");

            int N = Integer.parseInt(str[0]);
            double D = 1 - Double.parseDouble(str[1])/100;

            str = br.readLine().split(" ");

            double min = Double.MAX_VALUE, sum = 0, current;

            for (int j = 0; j < str.length; j++) {
                current = Double.parseDouble(str[j]);
                sum += current;
                min = Math.min(min, current);
            }

            DecimalFormat df = (DecimalFormat)DecimalFormat.getNumberInstance(Locale.US);

            df.applyPattern("#.00");
            System.out.println(df.format((sum-min)*D+min));

        }

    }
}
