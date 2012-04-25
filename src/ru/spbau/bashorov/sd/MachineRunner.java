package ru.spbau.bashorov.sd;

import ru.spbau.bashorov.sd.coffemachine.CoffeeMachine;

import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: zalim
 * Date: 4/25/12
 * Time: 6:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class MachineRunner {
    public static void run(CoffeeMachine cm) {
        Scanner in = new Scanner(System.in);

        while (true) {
            String command = in.next();
            List<Integer> coins = null;
            try{
                if (command.equals("insert")) {
                    int coin = in.nextInt();
                    cm.insert(coin);

                } else if (command.equals("select")) {
                    String product = in.next();
                    final int sugarCount = cm.getSugarCount();
                    coins = cm.select(product);
                    System.out.println("The product was purchased" + (sugarCount > cm.getSugarCount() ? " with " + sugarCount + " sugar.": "."));
                } else if (command.equals("cancel")) {
                    coins = cm.cancel();
                    System.out.println("Canceled");
                } else
                if (command.equals("add") && in.next().equals("sugar")) {
                    cm.addSugar();
                    System.out.println("Sugar added");
                } else {
                    System.out.println("Unknown command");
                    continue;
                }

                if (coins != null && !coins.isEmpty()) {
                    System.out.print("Returned coins: ");
                    for (Integer c : coins) {
                        System.out.print(c.toString() + " ");
                    }
                    System.out.println();
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
