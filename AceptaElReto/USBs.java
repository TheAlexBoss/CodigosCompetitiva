package adatraining;

import java.util.HashMap;
import java.util.Scanner;

public class USBs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();

        for (int i = 0; i < T; i++) {
            int C = scn.nextInt();
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < C; j++) {
                String usb = scn.next();
                map.put(usb, getOrDefault(map, usb, 0) + 1);
            }

            if(getOrDefault(map, "HH", 0) == getOrDefault(map, "MM", 0))
                System.out.println("POSIBLE");
            else
                System.out.println("IMPOSIBLE");

        }
    }

    public static int getOrDefault(HashMap<String, Integer> map, String key, int def){
        if(map.containsKey(key))
            return map.get(key);
        return def;
    }
}
