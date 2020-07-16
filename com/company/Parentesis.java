package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Parentesis {
    // https://www.aceptaelreto.com/problem/statement.php?id=141
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Character> stack;
        String string;
        int eresante;
        char mander;
        boolean flag;

        while((string = br.readLine()) != null && !string.equals("")){
            stack = new LinkedList<>();
            eresante = 0;
            flag = true;
            while(eresante < string.length()){
                mander = string.charAt(eresante);
                if(mander == '(' || mander == '[' || mander == '{'){
                    stack.add(mander);
                    eresante++;
                    continue;
                }

                if(!stack.isEmpty()){
                    if(mander == ')'){
                        mander = '(';
                    }else if(mander == ']'){
                        mander = '[';
                    }else if(mander == '}'){
                        mander = '{';
                    }else{
                        eresante++;
                        continue;
                    }

                    if(stack.peekLast() == mander)
                        stack.pollLast();
                    else{
                        flag = false;
                        break;
                    }
                }else if(mander == ')' || mander == ']' || mander == '}'){
                    flag = false;
                    break;
                }
                eresante++;
            }

            if(stack.size() == 0 && flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
}
