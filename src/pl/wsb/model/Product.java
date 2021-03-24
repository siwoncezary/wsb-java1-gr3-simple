package pl.wsb.model;

import java.io.Serializable;

abstract public class Product implements Serializable {
    private final String name;

    protected Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int price();
}
