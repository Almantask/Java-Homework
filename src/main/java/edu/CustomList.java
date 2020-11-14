package edu;

public class CustomList {
    private int[] ints;

    public CustomList() {
        ints = new int[0];
    }

    public CustomList(int[] ints) {
        this.ints = ints;
    }

    public boolean any() {
        return ints.length > 0;
        // don't do this:
        // return !(ints.length < 1)
    }

    public int[] getAll() {
        return ints;
    }
}
