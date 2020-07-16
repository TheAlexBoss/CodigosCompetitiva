package com.competitive;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class Main {

    public static void main(String[] args) throws IOException{
	// write your code here
        File fileIn = new File("e_shiny_selfies.txt");
        BufferedReader br = new BufferedReader(new FileReader(fileIn));
        File fileOut = new File("out_e.txt");
        fileOut.createNewFile();
        PrintWriter pw = new PrintWriter(new FileWriter(fileOut),true);


        HashMap<String,ArrayList<Ordenacion>> mapa = new HashMap<>();
        ArrayList<Integer> cojas = new ArrayList<>();

        int numPhotos = Integer.parseInt(br.readLine());

        for (int i = 0; i < numPhotos; i++) {
            String str[] = br.readLine().split(" ");
            ArrayList<String> tags = new ArrayList<>();
            Ordenacion ordenacion = new Ordenacion(str[0].charAt(0),i,Integer.parseInt(str[1]));
            for (int j = 0; j < Integer.parseInt(str[1]); j++) {

                tags.add(str[j+2]);

                if(mapa.containsKey(str[j+2])){
                    mapa.get(str[j+2]).add(ordenacion);
                }else{
                    ArrayList <Ordenacion> aux = new ArrayList<>();
                    aux.add(ordenacion);
                    mapa.put(str[j+2],aux);
                }


            }
        }

        for(String str: mapa.keySet()){
            mapa.get(str).sort(new Comparar());
        }

        HashSet<Integer> indicesMetidos = new HashSet<>();
        ArrayList<Slide> diapos = new ArrayList<>();
        HashMap<String,ArrayList<Ordenacion>> mapa2 = new HashMap<>();

        ArrayList<OrdenTamanno> ordenTamannos = new ArrayList<>();
        for(String str: mapa.keySet()){
            ordenTamannos.add(new OrdenTamanno(str,mapa.get(str).size()));
        }
        ordenTamannos.sort(new OrdenCompare());

        for(OrdenTamanno or: ordenTamannos){
            mapa2.put(or.getKey(),mapa.get(or.getKey()));
        }


        for(String str: mapa2.keySet()){
            ArrayList<Ordenacion> auxiliar = mapa2.get(str);
            for (Ordenacion or: auxiliar) {
                int index = or.getOrdenEntrada();

                if(!indicesMetidos.contains(index)){

                    if(or.getOrientacion() == 'H'){
                        indicesMetidos.add(index);
                        diapos.add(new Slide(index,-1));
                    }else{//ES V

                        if(!diapos.isEmpty()){
                            if(diapos.get(diapos.size()-1).getFoto2() == -2){
                                indicesMetidos.add(index);
                                diapos.set(diapos.size()-1,new Slide(diapos.get(diapos.size()-1).getFoto1(),index));
                            }else{
                                indicesMetidos.add(index);
                                diapos.add(new Slide(index,-2));
                            }
                        }else{
                            indicesMetidos.add(index);
                            diapos.add(new Slide(index,-2));
                        }


                    }


                }

            }

            if(diapos.get(diapos.size()-1).getFoto2() == -2){
                int indexCorrect = diapos.get(diapos.size()-1).getFoto1();
                diapos.remove(diapos.size()-1);
                indicesMetidos.remove(indexCorrect);
                if(!cojas.contains(indexCorrect)){
                    cojas.add(indexCorrect);
                }

            }

        }


        if(cojas.size()>=2){
            int tam=cojas.size();
            if (tam % 2 != 0) {
                tam--;
            }
            for(int i=0;i<cojas.size()-1;i++){
                for (int j = 0; j < cojas.size()-1; j++) {

                    if((i!= j) && (!indicesMetidos.contains(cojas.get(i)) && !indicesMetidos.contains(cojas.get(j)))){
                        if(cojas.get(i) != cojas.get(j)){
                            diapos.add(new Slide(cojas.get(i),cojas.get(j)));
                            indicesMetidos.add(cojas.get(i));
                            indicesMetidos.add(cojas.get(j));
                        }
                    }

                }
            }
        }





        //IMPRESION
        int c = 0;
        for(String str: mapa2.keySet()){
            c++;
        }
        System.out.println(c);
        pw.println(diapos.size());
        for (Slide s: diapos){

            pw.print(s.getFoto1());
            if(s.getFoto2()>=0){
                pw.print(" " + s.getFoto2());
            }

            pw.println();
        }


    }
}
