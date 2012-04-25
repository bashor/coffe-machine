package ru.spbau.bashorov.sd.vendingmachine;

import ru.spbau.bashorov.sd.MachineRunner;

/**
 * Created with IntelliJ IDEA.
 * User: zalim
 * Date: 4/25/12
 * Time: 5:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        MachineRunner.run(new VendingMachine(13));
    }
}
