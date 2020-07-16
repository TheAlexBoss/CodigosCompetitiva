package com.company;

import java.io.*;

public class pollitos2 {
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

                Mov movement = new Mov(x,y,d,1,dir);

                while(movement.x < f && movement.y < c && movement.x >= 0 && movement.y >= 0 && movement.energy > 0)
                    movement.move(matrix);

                if(movement.x < f && movement.y < c && movement.x >= 0 && movement.y >= 0)
                    matrix[movement.x][movement.y]++;
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

class Mov{
    int d, x, y, energy;
    boolean bol;
    char dir;

    public Mov(int x, int y, int energy, int d, char dir) {
        this.x = x;
        this.y = y;
        this.energy = energy;
        this.d = d;
        this.dir = dir;
        this.bol = false;
    }

    public void move(int[][] matrix){
        int movement = Math.min(this.d, this.energy);
        if(this.dir == 'N' || this.dir == 'E'){
            if(this.dir == 'N') {
                this.x = this.update(matrix,this.x, this.y,true, movement, -1);
            }else {
                this.y = this.update(matrix,this.x, this.y,false, movement, 1);
            }
        }else{
            if(this.dir == 'S') {
                this.x = this.update(matrix,this.x, this.y,true, movement, 1);
            }else {
                this.y = this.update(matrix,this.x, this.y,false, movement, -1);
            }
        }
        this.energy -= movement;
        this.next();
    }

    private int update(int[][] matrix, int c1, int c2, boolean first, int move, int sign){
        if(first){
            for (int i = 0; i < move; i++) {
                matrix[c1][c2]++;
                c1 += sign;
            }
            return c1;
        }else{
            for (int i = 0; i < move; i++) {
                matrix[c1][c2]++;
                c2 += sign;
            }
            return c2;
        }
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