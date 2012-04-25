package ru.spbau.bashorov.sd.coffemachine;

import ru.spbau.bashorov.sd.MachineRunner;

/**
 * Created with IntelliJ IDEA.
 * User: zalim
 * Date: 4/25/12
 * Time: 3:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        MachineRunner.run(new CoffeeMachine(20));
    }
}
