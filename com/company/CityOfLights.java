package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CityOfLights {

    public static void main(String[] args) throws IOException{

        File directory = new File("/Users/alejandro/Downloads/swerc_testcases/citylights/data/secret");

        File[] files = directory.listFiles();
        Arrays.sort(files);


        for (File f: files){
            if(f.getName().contains(".in")){

                String sol = "";
                for (File fi: files)
                    if(fi.getName().contains(f.getName().substring(0,f.getName().length()-3)) && fi.getName().contains(".ans")){
                        BufferedReader br = new BufferedReader(new FileReader(fi));
                        sol = br.readLine();
                    }

                long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
                TInicio = System.currentTimeMillis();

                ejecuta(f);

                System.out.println("Solución: " + sol);

                TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
                tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
                System.out.println("Tiempo de ejecución en segundos: " + (double) tiempo/1000);
            }
        }
    }
    public static void ejecuta(File file) throws IOException {

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),true);
        BufferedReader br = new BufferedReader(new FileReader(file));

        int N = Integer.parseInt(br.readLine());
        boolean[] array = new boolean[N+1];

        int k = Integer.parseInt(br.readLine());
        int MAX = 0;
        int cont = 0;
        for (int i = 0; i < k; i++) {
            int j = Integer.parseInt(br.readLine());
            for (int l = j; l <= N; l+=j) {
                array[l] = !array[l];
                if(array[l])
                    cont++;
                else
                    cont--;
            }
            MAX = Math.max(MAX,cont);
        }
        pw.println(MAX);
    }
}
