package edu;

public class Item {
    @RequiredAnnotation
    private final String name;
    @RequiredAnnotation
    private final String description;
    private final Double price;

    public Item(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}
