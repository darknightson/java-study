package javacodingtechnic.chapter2;

import javacodingtechnic.Supply;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Supply> supplies = new ArrayList<>();

    // 오염된 물품 폐기
    void disposeContaminatedSupplies() {

        for (Supply supply : supplies) {
            if (supply.isContaminated()) {
                supplies.remove(supply);
            }
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.supplies.add(new Supply("apple"));
        inventory.supplies.add(new Supply("banana"));
        inventory.supplies.add(new Supply("Contaminated apple"));
        inventory.supplies.add(new Supply("Contaminated banana"));
        inventory.disposeContaminatedSupplies();
        System.out.println(inventory.supplies.size());
    }
}
