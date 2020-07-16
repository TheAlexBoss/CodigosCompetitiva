package com.company;

import java.io.*;

public class pollitos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);

        int NC = Integer.parseInt(br.readLine());
        int f, c, n, x, y, d;
        char dir;
        int[][] matrix;
        String[] line;

        for (int i = 0; i < NC; i++) {
            line = br.readLine().split(" ");
            f = Integer.parseInt(line[0]);
            c = Integer.parseInt(line[1]);
            n = Integer.parseInt(line[2]);
            matrix = new int[f][c];

            for (int j = 0; j < n; j++) {
                line = br.readLine().split(" ");
                x = Integer.parseInt(line[0]) - 1;
                y = Integer.parseInt(line[1]) - 1;
                dir = line[2].charAt(0);
                d = Integer.parseInt(line[3]);


                Mov1 movement = new Mov1(x,y,d,1,dir);
                int ansX = x, ansY = y, ansAnsX = ansX, ansAnsY = ansY, from, to;
                boolean flag = true;
                while(movement.x < f && movement.y < c && movement.x >= 0 && movement.y >= 0 && movement.energy > 0){
                    movement.move();

                    if(flag){
                        if(ansX < movement.x || ansY < movement.y){
                            matrix[x][y]++;
                        }
                        flag = false;
                    }
                    System.err.println("(" + movement.x + " , " + movement.y + ") direccion: \t"+movement.dir+" con energía:\t" + movement.energy);

                    if(ansX == movement.x){
                        from = Math.max(Math.min(ansY, movement.y),0);
                        to = Math.min(Math.max(ansY, movement.y),c-1);
                        for (int k = from; k <= to; k++) {
                            matrix[movement.x][k]++;
                        }
                        matrix[movement.x][from]--;
                    }else{
                        from = Math.max(Math.min(ansX, movement.x),0);
                        to = Math.min(Math.max(ansX, movement.x),f-1);
                        for (int k = from; k <= to; k++) {
                            matrix[k][movement.y]++;
                        }
                        matrix[from][movement.y]--;
                    }

                    ansAnsX = ansX;
                    ansAnsY = ansY;
                    ansX = movement.x;
                    ansY = movement.y;
                }

                if((ansAnsX > ansX || ansAnsY > ansY) && (ansX < f) && (ansY < c) && (ansX >= 0) && (ansY >= 0)){
                    matrix[ansX][ansY]++;
                }

                System.err.println();
            }
            for (int k = 0; k < f; k++) {
                for (int l = 0; l < c; l++) {
                    pw.print(matrix[k][l]);
                    if(l<c-1)
                        pw.print(" ");
                }
                pw.println();
            }

            pw.println("---");
        }
        pw.flush();
    }
}

class Mov1{
    int d, x, y, energy;
    boolean bol;
    char dir;

    public Mov1(int x, int y, int energy, int d, char dir) {
        this.x = x;
        this.y = y;
        this.energy = energy;
        this.d = d;
        this.dir = dir;
        this.bol = false;
    }

    public void move(){
        int movement = Math.min(this.d, this.energy);
        if(this.dir == 'N' || this.dir == 'E'){
            if(this.dir == 'N')
                this.x -= movement;
            else
                this.y += movement;
        }else{
            if(this.dir == 'S')
                this.x += movement;
            else
                this.y -= movement;
        }
        this.energy-=movement;
        this.next();
    }

    private void next(){

        if(bol){
            this.d++;
        }
        this.dir = nextDistance(dir);

        bol = !bol;
    }

    private char nextDistance(char prev){
        switch (prev){
            case 'E':
                return 'S';
            case 'W':
                return 'N';
            case 'N':
                return 'E';
            default:
                return 'W';
        }
    }
}