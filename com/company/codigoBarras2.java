package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class codigoBarras2 {

    public static HashMap<String, String> map = new HashMap<>();
    public static void main(String[] args) {
        init();
        Scanner scn = new Scanner(System.in);

        int[] powerUp = {3, 1};

        String input;

        while(!(input = scn.next()).equals("0")){
            if(input.length() <= 13){
                int cont = 0, sum = 0;
                for (int i = input.length()-2; i >= 0; i--) {
                    sum += (input.charAt(i) - 48)*powerUp[cont%2];
                    cont++;
                }

                int comparacion = (sum + (input.charAt(input.length()-1) - 48)) % 10;

                if(comparacion == 0){
                    System.out.print("SI");
                    if(input.length() > 8){
                        String country;
                        if(input.length()<13){
                            System.out.println(" EEUU");
                        }else if((country = map.get("" + input.charAt(0))) != null){
                            System.out.println(country);
                        }else if((country = map.get("" + input.charAt(0) + input.charAt(1))) != null){
                            System.out.println(country);
                        }else if((country = map.get("" + input.charAt(0) + input.charAt(1) + input.charAt(2))) != null){
                            System.out.println(country);
                        }else{
                            System.out.println(" Desconocido");
                        }
                    }else{
                        System.out.println();
                    }
                }else{
                    System.out.println("NO");
                }

            }else{
                System.out.println("NO");
            }
        }

    }

    public static void init(){
        map.put("0", " EEUU");
        map.put("380", " Bulgaria");
        map.put("50", " Inglaterra");
        map.put("539", " Irlanda");
        map.put("560", " Portugal");
        map.put("70", " Noruega");
        map.put("759", " Venezuela");
        map.put("850", " Cuba");
        map.put("890", " India");
    }
}
