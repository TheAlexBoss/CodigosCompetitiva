package com.company;

import com.sun.xml.internal.xsom.XSUnionSimpleType;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        int[] arr = new int[1];

        arr[0] = 5;

        elPruebas(arr);
        elPruebas(arr);

        System.out.println(arr[0]);

    }


    public static void elPruebas(int[] i){
        i[0]++;
    }

    public static int binaryMinIndex(ArrayList<Integer> array, Integer elem, int low, int up){
        if(low == up)
            return up;

        if(low > up)
            return low;

        int med = (low+up)/2;

        if(array.get(med) >= elem)
            return binaryMinIndex(array,elem,low,med);
        else
            return binaryMinIndex(array,elem,med+1,up);
    }

    public static int binaryMaxIndex(ArrayList<Long> array, Long elem, int low, int up){
        if(low == up)
            return up;

        if(low+1 == up)
            if(elem >= array.get(up)){
                return up;
            }else{
                return low;
            }

        int mid = (low+up)/2;

        if(elem >= array.get(mid)){
            return binaryMaxIndex(array,elem,mid,up);
        }else{
            return binaryMaxIndex(array,elem,low,mid);
        }
    }

    public static int binaryMinIndex2(ArrayList<Long> array, Long elem, int low, int up){
        if(low == up)
            return up;

        if(low+1 == up)
            if(elem >= array.get(up)){
                if(!elem.equals(array.get(up)) && up == array.size()-1)
                    return up+1;
                return up;
            }else{
                return low;
            }

        int mid = (low+up)/2;

        if(elem > array.get(mid)){
            return binaryMinIndex2(array,elem,mid,up);
        }else{
            return binaryMinIndex2(array,elem,low,mid);
        }
    }

    public static int binaryMaxIndex2(ArrayList<Integer> array, Integer elem, int low, int up){

        if(low+1 == up)
            if(elem < array.get(low))
                return low;
            else
                return up;

        if(low == up)
            return low;

        int med = (low+up)/2;

        if(elem<array.get(med))
            return binaryMaxIndex2(array,elem,low,med);
        else
            return binaryMaxIndex2(array,elem,med,up);
    }

    public static int lowerBound(ArrayList<Integer> array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            //checks if the value is less than middle element of the array
            if (value <= array.get(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
