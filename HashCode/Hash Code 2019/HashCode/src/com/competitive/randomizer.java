package com.competitive;

import java.io.*;

public class randomizer {
    public static void main(String args[]) throws IOException{
        File fileIn = new File("e_shiny_selfies.txt");
        BufferedReader br = new BufferedReader(new FileReader(fileIn));
        File fileOut = new File("out_e.txt");
        fileOut.createNewFile();
        PrintWriter pw = new PrintWriter(new FileWriter(fileOut),true);


        int rand = (int) Math.random()*10;

        for (int i = 0; i < rand; i++) {
            br.readLine();
        }
        String linea = br.readLine();


    }
}
