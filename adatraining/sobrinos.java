package adatraining;

import java.util.Scanner;

public class sobrinos {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr;
        boolean malo;

        int sobs, lect, mid;

        while(scn.hasNext()){
            sobs = scn.nextInt();
            lect = scn.nextInt();
            arr = new int[sobs];
            malo = false;
            mid = 1;
            arr[0] = lect;
            arr[1] = lect;

            sobs--;
            while(sobs != 0){
                sobs--;
                lect = scn.nextInt();
                for (int i = mid; i > 0 && arr[i-1] < lect; i-=2) {
                    if (arr[i - 1] < lect && arr[i] > lect) {
                        malo = true;
                        break;
                    }
                }

                if(malo)
                    break;

                if (arr[mid - 1] < lect){
                    arr[mid] = lect;
                }else if (arr[mid - 1] == arr[mid]){
                    arr[mid - 1] = lect;
                    arr[mid] = lect;
                }else {
                    mid += 2;
                    if(mid>=arr.length) {
                        mid--;
                    }

                    arr[mid - 1] = lect;
                    arr[mid] = lect;
                }
            }

            while(sobs!=0){
                sobs--;
                scn.nextInt();
            }

            if (malo)
                System.out.println("ELEGIR OTRA");
            else
                System.out.println("SIEMPRE PREMIO");

        }
    }
}
