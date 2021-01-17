package edu;

public abstract class Pokemon {

    protected String attack;
    protected int health;

    public String getAttackDescription() {
        return attack;
    }

    public abstract int getAttackPower();
}
