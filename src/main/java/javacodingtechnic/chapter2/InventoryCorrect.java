package javacodingtechnic.chapter2;

import javacodingtechnic.Supply;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InventoryCorrect {

    private final List<Supply> supplies = new ArrayList<>();

    void disposeContaminatedSupplies() {
        Iterator<Supply> iterator = supplies.iterator();
        while (iterator.hasNext()) {
            Supply supply = iterator.next();
            if (supply.isContaminated()) {
                iterator.remove();
            }
        }

        supplies.forEach(supply -> {
            System.out.println("supply = " + supply.getName());
        });
    }

    void disposeContaminatedSuppliesCollectionRemoveIf() {
        supplies.removeIf(Supply::isContaminated);
        System.out.println("supplies.size() = " + supplies.size());
        for (Supply supply : supplies) {
            System.out.println("supply.getName() = " + supply.getName());
        }
    }

    public static void main(String[] args) {
        InventoryCorrect inventory = new InventoryCorrect();
        inventory.supplies.add(new Supply("apple"));
        inventory.supplies.add(new Supply("banana"));
        inventory.supplies.add(new Supply("Contaminated apple"));
        inventory.supplies.add(new Supply("Contaminated banana"));
        inventory.disposeContaminatedSuppliesCollectionRemoveIf();
    }
}
