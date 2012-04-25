package ru.spbau.bashorov.sd.coffemachine;

/**
 * Created with IntelliJ IDEA.
 * User: zalim
 * Date: 4/25/12
 * Time: 4:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Product {
    private String name;
    private Integer cost;
    private boolean maybeWithSugar;

    public Product(String name, Integer cost, boolean maybeWithSugar) {
        this.name = name;
        this.cost = cost;
        this.maybeWithSugar = maybeWithSugar;
    }

    public String getName() {
        return name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public boolean isMaybeWithSugar() {
        return maybeWithSugar;
    }
}
