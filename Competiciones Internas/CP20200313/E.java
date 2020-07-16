package CP20200313;

import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        HashMap<String, Integer> seguros = new HashMap<>();
        HashMap<String, Integer> posibles = new HashMap<>();
        int P = scn.nextInt();

        for (int i = 0; i < P; i++) {
            String c = scn.next();
            seguros.put(c, 0);
            posibles.put(c, 0);
        }

        int C = scn.nextInt();
        int max_votos = -1;

        for (int i = 0; i < C; i++) {
            HashSet<String> candidatos_info = new HashSet<>();
            scn.next();
            int n_candidatos = scn.nextInt(), votos_totales = scn.nextInt();
            int votos_candidato, votos_until = 0;
            String candidato;
            for (int j = 0; j < n_candidatos; j++) {
                candidato = scn.next();
                candidatos_info.add(candidato);
                try {
                    votos_candidato = scn.nextInt();
                }catch (InputMismatchException e){
                    String s = scn.next();
                    double aux = Double.parseDouble(s.substring(0,s.length()-1))/100;
                    votos_candidato = (int) (aux*votos_totales);
                }

                seguros.put(candidato, seguros.get(candidato) + votos_candidato);
                posibles.put(candidato, posibles.get(candidato) + votos_candidato);

                max_votos = Math.max(max_votos, seguros.get(candidato));
                votos_until += votos_candidato;
            }

            int n = 0;
            String remember_c = "";
            for(String c: seguros.keySet())
                if(!candidatos_info.contains(c)){
                    posibles.put(c, posibles.get(c) + votos_totales - votos_until);
                    n++;
                    remember_c = c;
                }

            if(n == 1)
                seguros.put(remember_c, seguros.get(remember_c) + votos_totales - votos_until);
        }

        LinkedList<String> solucion = new LinkedList<>();

        for(String s: posibles.keySet())
            if(posibles.get(s) >= max_votos)
                solucion.add(s);

        System.out.println(solucion.size());

        Collections.sort(solucion);

        for(String s: solucion)
            System.out.println(s);

    }
}
