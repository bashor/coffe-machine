package ru.spbau.bashorov.sd.vendingmachine;

import ru.spbau.bashorov.sd.coffemachine.CoffeeMachine;
import ru.spbau.bashorov.sd.coffemachine.Product;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zalim
 * Date: 4/25/12
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class VendingMachine extends CoffeeMachine {
    public VendingMachine(int maxSugarCount) {
        super(maxSugarCount);
        VALID_COINS.addAll(Arrays.asList(10, 50));
        PRODUCTS.put(new Product("bonaqua", 10, false), 12);
        PRODUCTS.put(new Product("perrier", 12, false), 55);
    }
}
