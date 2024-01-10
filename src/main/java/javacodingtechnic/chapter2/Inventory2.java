package javacodingtechnic.chapter2;

import javacodingtechnic.Supply;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inventory2 {
    private final List<Supply> supplies = new ArrayList<>();

    List<Supply> find(String regex) {
        List<Supply> result = new LinkedList<>();
        for (Supply supply : supplies) {
            if (supply.getName().matches(regex)) {
                result.add(supply);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Inventory2 inventory = new Inventory2();
        inventory.supplies.add(new Supply("apple"));
        inventory.supplies.add(new Supply("banana"));
        inventory.supplies.add(new Supply("Contaminated apple"));
        inventory.supplies.add(new Supply("Contaminated banana"));
        List<Supply> contaminatedBanana = inventory.find("Contaminated banana");

        contaminatedBanana.forEach(supply -> {
            System.out.println("supply = " + supply.getName());
        });

        System.out.println(contaminatedBanana.size());
    }
}
