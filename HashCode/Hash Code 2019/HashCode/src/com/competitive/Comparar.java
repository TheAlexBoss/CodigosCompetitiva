package com.competitive;

import java.util.Comparator;

public class Comparar implements Comparator <Ordenacion> {

    @Override
    public int compare(Ordenacion o1, Ordenacion o2) {

        if((o1.getOrientacion() == 'H' && o2.getOrientacion() == 'H' )||(o1.getOrientacion() == 'V' && o2.getOrientacion() == 'V') ){//HORIZONTALES MEJOR
            if(o1.getOrientacion() == 'H'){
                if(o1.getNumTags()<o2.getNumTags()){//ES MEJOR O2
                    return 1;
                }else if(o1.getNumTags()>o2.getNumTags()){//ES MEJOR O1
                    return -1;
                }else{//IGUALES EN NUMTAGS
                    return 0;
                }
            }else{
                if(o1.getNumTags()<o2.getNumTags()){//ES MEJOR O2
                    return -1;
                }else if(o1.getNumTags()>o2.getNumTags()){//ES MEJOR O1
                    return 1;
                }else{//IGUALES EN NUMTAGS
                    return 0;
                }
            }
        }else if(o1.getOrientacion() == 'H' && o2.getOrientacion() == 'V'){//HV
            return -1;
        }else{//VH
            return 1;
        }
    }
}
