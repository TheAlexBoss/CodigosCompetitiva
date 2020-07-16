package CP20200424;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Main {
    static int INF = Integer.parseInt("3F3F3F3F", 16);
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        String s = "hola.for";
        String[] arr = s.split("[.]");
        System.out.println(arr.length);
        System.out.println(arr[0]);
        System.out.println(arr[1]);

    }

    public int editD(String S, String T, int[][] memo, int i, int j) {
        if (i >= S.length() && j >= T.length())
            return 0;
        if (i >= S.length() || j >=T.length())
            return INF;
        if (memo[i][j] != -1)
            return memo[i][j];
        if (S.charAt(i) == T.charAt(j))
            memo[i][j] = editD(S, T, memo, i + 1, j + 1);
        else
            memo[i][j] = Math.min(Math.min(editD(S, T, memo, i + 1, j) + 1, editD(S, T, memo, i, j + 1) + 1), editD(S, T, memo, i + 1, j + 1) + 1);

        return memo[i][j];
    }
}
