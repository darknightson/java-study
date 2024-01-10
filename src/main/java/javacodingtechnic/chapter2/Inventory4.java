package javacodingtechnic.chapter2;

import javacodingtechnic.Supply;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Inventory4 {

    private final List<Supply> supplies = new ArrayList<>();

    int getQuantity(Supply supply) {
        requireNonNull(supply, "supply is null");
        return Collections.frequency(supplies, supply);
    }

    public static void main(String[] args) {
        Inventory4 inventory = new Inventory4();

        inventory.supplies.add(new Supply("apple"));
        inventory.supplies.add(new Supply("banana"));
        inventory.supplies.add(new Supply("Contaminated apple"));
        inventory.supplies.add(new Supply("Contaminated banana"));

        int quantity = inventory.getQuantity(new Supply("apple"));
        System.out.println("quantity = " + quantity);
    }
}




