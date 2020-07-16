package hashCode2020;

import CP0911.A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class testing {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();

        a.add(0);
        a.add(30);
        a.add(40);

        //System.out.println(a.get(binaryMaxIndex(a,-1,0,a.size())-1));


        TreeSet<Integer> set = new TreeSet<>();

        set.add(1);
        set.add(5);
        set.add(10);

        System.out.println(set.first());

    }

    public static int binaryMaxIndex(ArrayList<Integer> array, Integer elem, int low, int up){

        if(low+1 == up)
            if(elem < array.get(low))
                return low;
            else
                return up;

        if(low == up)
            return low;

        int med = (low+up)/2;

        if(elem<array.get(med))
            return binaryMaxIndex(array,elem,low,med);
        else
            return binaryMaxIndex(array,elem,med,up);
    }
}
