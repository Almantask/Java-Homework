package edu;

public class Person {
    private String name;
    private int height;
    private int weight;
    private long ID;

    public Person(String name, int height, int weight, long ID) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public long getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", ID=" + ID +
                '}';
    }
}
