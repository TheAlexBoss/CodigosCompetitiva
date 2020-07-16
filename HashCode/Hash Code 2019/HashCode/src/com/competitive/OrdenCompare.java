package com.competitive;

import java.util.Comparator;

public class OrdenCompare implements Comparator<OrdenTamanno> {
    @Override
    public int compare(OrdenTamanno o1, OrdenTamanno o2) {
        return o2.getValor()-o1.getValor();
    }
}
