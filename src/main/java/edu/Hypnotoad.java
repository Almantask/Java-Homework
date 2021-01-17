package edu;

public class Hypnotoad extends Pokemon {

    public Hypnotoad() {
        this.attack = "Hypnotoad sends a psycho attack";
        this.health = 100;
    }

    @Override
    public int getAttackPower() {
        return 5;
    }
}
