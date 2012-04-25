package ru.spbau.bashorov.sd.coffemachine;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zalim
 * Date: 4/25/12
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoffeeMachine {
    final protected Map<Product, Integer> PRODUCTS = new HashMap<Product, Integer>() {{
        put(new Product("c", 4, true), 3);
        put(new Product("l", 6, true), 100);
    }};

    final protected Set<Integer> VALID_COINS = new HashSet<Integer>(Arrays.asList(1, 2, 3, 5));

//    public CoffeeMachine putProduct(Product product, Integer count) {
//        PRODUCTS.put(product, count);
//        return this;
//    }

    private int balance = 0;
    private int maxSugarCount;
    final private int SUGAR_COST = 1;

    public int getSugarCount() {
        return sugarCount;
    }

    private int sugarCount = 0;

    public CoffeeMachine(int maxSugarCount) {
        this.maxSugarCount = maxSugarCount;
    }

    public void insert(int coin) {
        if (!VALID_COINS.contains(coin))
            throw new IllegalArgumentException("Invalid coin");

        balance += coin;
    }

    public void addSugar() {
        if (sugarCount == maxSugarCount)
            throw new RuntimeException("The Sugar has ended.");

        ++sugarCount;
    }

    public List<Integer> select(String product) {
        for (Map.Entry<Product, Integer> s : PRODUCTS.entrySet()) {
            Product p = s.getKey();
            if (p.getName().equals(product)) {
                if (s.getValue() <= 0)
                    throw new RuntimeException("This product has ended.");

                Integer cost = p.getCost();
                if (p.isMaybeWithSugar())
                    cost += sugarCount * SUGAR_COST;

                if (cost <= balance) {
                    if (p.isMaybeWithSugar()) {
                        maxSugarCount -= sugarCount;
                        sugarCount = 0;
                    }

                    balance -= cost;
                    s.setValue(s.getValue() - 1);
                    return returnMoney();
                } else {
                    throw new RuntimeException("Not enough money.");
                }
            }
        }
        throw new RuntimeException("Product not found.");
    }

    public List<Integer> cancel() {
        return returnMoney();
    }

    private List<Integer> returnMoney() {
        List<Integer> ret = new ArrayList<Integer>();
        Integer[] coins = (Integer[]) VALID_COINS.toArray(new Integer[0]);
        Arrays.sort(coins, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (Integer coin : coins) {
            Integer count = balance / coin;
            ret.addAll(Collections.nCopies(count, coin));
            balance %= coin;
        }
        return ret;
    }
}
