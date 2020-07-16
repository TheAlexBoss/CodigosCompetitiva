package com.company;

        import java.io.*;
        import java.util.*;

public class drones {
    public static void main(String[] args) throws IOException {
        /*Scanner scn = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        while(scn.hasNext()){
            int N = scn.nextInt(), A = scn.nextInt(), B = scn.nextInt();
            PriorityQueue<Integer> pilaA = new PriorityQueue<>(A, Collections.reverseOrder());
            PriorityQueue<Integer> pilaB = new PriorityQueue<>(B, Collections.reverseOrder());

            for (int i = 0; i < A; i++) {
                pilaA.add(scn.nextInt());
            }

            for (int i = 0; i < B; i++) {
                pilaB.add(scn.nextInt());
            }

            long result;
            boolean first = true;
            while (!pilaA.isEmpty() && !pilaB.isEmpty()) {

                int i = 0;
                result = 0;
                while(i < N && !pilaB.isEmpty() && !pilaA.isEmpty()){
                    int a = pilaA.poll();
                    int b = pilaB.poll();

                    if(a == b){
                        result += a;
                    }else if(a > b){
                        result += b;
                        pilaA.offer(a-b);
                    }else{
                        result += a;
                        pilaB.offer(b-a);
                    }
                    i++;
                }

                if(first){
                    pw.print(result);
                    first = false;
                }else{
                    pw.print(" " + result);
                }
            }
            pw.println();
            pw.flush();
        }*/


        int d, A, B;
        //Scanner scn = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] lines;
        while((line = br.readLine()) != null){
            lines = line.split(" ");
            d = Integer.parseInt(lines[0]);
            A = Integer.parseInt(lines[1]);
            B = Integer.parseInt(lines[2]);

            PriorityQueue<Integer> q1 = new PriorityQueue<>(A, Collections.reverseOrder());
            PriorityQueue<Integer> q9 = new PriorityQueue<>(B, Collections.reverseOrder());
            int aux;
            lines = br.readLine().split(" ");
            for (int i = 0; i < A; i++) {
                aux = Integer.parseInt(lines[i]);
                q1.offer(aux);
            }
            lines = br.readLine().split(" ");
            for (int i = 0; i < B; i++) {
                aux = Integer.parseInt(lines[i]);
                q9.offer(aux);
            }

            LinkedList<Integer> sol = new LinkedList<>();

            while(!q1.isEmpty() && !q9.isEmpty()){
                LinkedList<Integer> aux1= new LinkedList<>(), aux9= new LinkedList<>();
                int res = 0;
                for (int i = 0; i < d; i++) {
                    int fp1 = q1.poll();
                    int fp9 = q9.poll();

                    res += Math.min(fp1, fp9);
                    if(fp9 < fp1)
                        aux1.add(fp1-fp9);
                    else if(fp1 < fp9)
                        aux9.add(fp9-fp1);

                    if(q1.isEmpty() || q9.isEmpty())
                        break;
                }

                for (Integer i: aux1) {
                    q1.offer(i);
                }

                for(Integer i: aux9){
                    q9.offer(i);
                }
                sol.add(res);

            }

            System.out.print(sol.removeFirst());
            for(Integer i: sol)
                System.out.print(" " + i);
            System.out.println();
        }

    }
}
