package javacodingtechnic.chapter3;

import javacodingtechnic.Supply;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    List<Supply> supplies = new ArrayList<>();

    int countContaminateSupplies() {
       if ( supplies == null || supplies.isEmpty()) {
           // 제품이 없으면 오염도 없다는 뜻이다.
           return 0;
       }

       int contaminatedCounter = 0;
        for (Supply supply : supplies) {
            if (supply.isContaminated()) {
                contaminatedCounter++;
            }
        }
        return contaminatedCounter;
    }
}
