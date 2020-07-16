package CP20200327;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        HashMap<String, BigInteger> tienda = new HashMap<>();

        int C = scn.nextInt();

        for (int i = 0; i < C; i++) {
            tienda.put(scn.next(), new BigInteger(scn.next()));
        }

        int T = scn.nextInt();
        BigInteger gano = BigInteger.ZERO;
        for (int i = 0; i < T; i++) {
            gano = gano.add(tienda.get(scn.next()));
        }

        BigInteger tenia = new BigInteger(scn.next());
        BigInteger falta = new BigInteger(scn.next());
        System.out.println(falta.subtract(tenia.add(gano)).max(BigInteger.ZERO));
    }
}
