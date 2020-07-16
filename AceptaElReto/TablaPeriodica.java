package adatraining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class TablaPeriodica {

    static HashSet<String> elements = new HashSet<>();

    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        boolean posible;

        while((input = br.readLine())!= null){
            char[] string = join(input);
            Boolean[] memo = new Boolean[string.length];

            if(dp(memo, string, 0))
                System.out.println("SI");
            else
                System.out.println("NO");
        }

    }


    public static boolean dp(Boolean[] memo,char[] string, int i){
        if(i >= string.length)
            return true;

        if(memo[i] != null)
            return memo[i];

        boolean T1, T2;

        if(elements.contains("" + string[i])){
            T1 = dp(memo, string, i+1);
        }else{
            T1 = false;
        }

        if(i+1 < string.length && elements.contains(string[i] + "" + string[i+1])){
            T2 = dp(memo, string, i+2);
        }else{
            T2 = false;
        }

        memo[i] = (T1 || T2);

        return memo[i];
    }

    public static char[] join(String string){
        StringBuilder strb = new StringBuilder();
        String[] str = string.split(" ");
        for (String s : str) {
            strb.append(s.toLowerCase());
        }
        return strb.toString().toCharArray();
    }


    public static void init(){
        elements.add("h");
        elements.add("li");
        elements.add("na");
        elements.add("k");
        elements.add("rb");
        elements.add("cs");
        elements.add("fr");
        elements.add("be");
        elements.add("mg");
        elements.add("ca");
        elements.add("sr");
        elements.add("ba");
        elements.add("ra");
        elements.add("sc");
        elements.add("y");
        elements.add("ti");
        elements.add("zr");
        elements.add("hf");
        elements.add("rf");
        elements.add("v");
        elements.add("nb");
        elements.add("ta");
        elements.add("db");
        elements.add("cr");
        elements.add("mo");
        elements.add("w");
        elements.add("sg");
        elements.add("mn");
        elements.add("tc");
        elements.add("re");
        elements.add("bh");
        elements.add("fe");
        elements.add("ru");
        elements.add("os");
        elements.add("hs");
        elements.add("co");
        elements.add("rh");
        elements.add("ir");
        elements.add("mt");
        elements.add("ni");
        elements.add("pd");
        elements.add("pt");
        elements.add("ds");
        elements.add("cu");
        elements.add("ag");
        elements.add("au");
        elements.add("rg");
        elements.add("zn");
        elements.add("cd");
        elements.add("hg");
        elements.add("cn");
        elements.add("b");
        elements.add("al");
        elements.add("ga");
        elements.add("in");
        elements.add("tl");
        elements.add("nh");
        elements.add("c");
        elements.add("si");
        elements.add("ge");
        elements.add("sn");
        elements.add("pb");
        elements.add("fl");
        elements.add("mc");
        elements.add("lv");
        elements.add("ts");
        elements.add("og");
        elements.add("n");
        elements.add("p");
        elements.add("as");
        elements.add("sb");
        elements.add("bi");
        elements.add("o");
        elements.add("s");
        elements.add("se");
        elements.add("te");
        elements.add("po");
        elements.add("f");
        elements.add("cl");
        elements.add("br");
        elements.add("i");
        elements.add("at");
        elements.add("he");
        elements.add("ne");
        elements.add("ar");
        elements.add("kr");
        elements.add("xe");
        elements.add("rn");

        elements.add("la");
        elements.add("ce");
        elements.add("pr");
        elements.add("nd");
        elements.add("pm");
        elements.add("sm");
        elements.add("eu");
        elements.add("gd");
        elements.add("tb");
        elements.add("dy");
        elements.add("ho");
        elements.add("er");
        elements.add("tm");
        elements.add("yb");
        elements.add("lu");
        elements.add("lr");
        elements.add("no");
        elements.add("md");
        elements.add("fm");
        elements.add("es");
        elements.add("cf");
        elements.add("bk");
        elements.add("cm");
        elements.add("am");
        elements.add("pu");
        elements.add("np");
        elements.add("u");
        elements.add("pa");
        elements.add("th");
        elements.add("ac");
    }
}
