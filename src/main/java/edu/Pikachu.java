package edu;

public class Pikachu extends Pokemon{

    public Pikachu() {
        this.attack = "Pikachu can do a slash with a tail";
        this.health = 100;
    }

    @Override
    public int getAttackPower() {
        return 5;
    }
}
