package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class codigoBarras {

    public static HashMap<String, String> map = new HashMap<>();
    public static void main(String[] args) {
        init();
        Scanner scn = new Scanner(System.in);

        String input = scn.next();

        while(!input.equals("0")){
            treat(input);
            input = scn.next();
        }
    }

    public static void init(){
        map.put("0", "EEUU");
        map.put("380", "Bulgaria");
        map.put("50", "Inglaterra");
        map.put("539", "Irlanda");
        map.put("560", "Portugal");
        map.put("70", "Noruega");
        map.put("759", "Venezuela");
        map.put("850", "Cuba");
        map.put("890", "India");
    }

    public static void treat(String input){
        StringBuilder treat = new StringBuilder(input).reverse();

        String country = checkCountry(input);

        if(treat.length() <= 8){
            while(treat.length() < 8){
                treat.append('0');
            }
        }else if(treat.length() <= 13){
            while(treat.length() < 13){
                treat.append('0');
            }
        }else{
            System.out.println("NO");
            return;
        }

        int check = treat.charAt(0) - 48;
        int[] multiply = {1, 3};
        int sum = 0;

        for (int i = 1; i < input.length(); i++) {
            sum += (treat.charAt(i) - 48) * multiply[i%2];
        }

        int last = (10 - (sum % 10)) % 10;

        if(last == check){
            System.out.println("SI" + country);
        }else{
            System.out.println("NO");
        }
    }


    public static String checkCountry(String input){
        if(input.length() > 8 && input.length() <= 13 ){
            if(input.charAt(0) == '0'){
                return " EEUU";
            }else{
                String country_one = getOrDefault("" + input.charAt(0) + input.charAt(1));
                String country_two = getOrDefault("" + input.charAt(0) + input.charAt(1) + input.charAt(2));

                if(!country_one.equals("Desconocido")){
                    return " " + country_one;
                }else{
                    return " " + country_two;
                }
            }
        }else{
            return "";
        }
    }

    public static String getOrDefault(String key){
        String result = map.get(key);
        return result == null ? "Desconocido": result;
    }
}
