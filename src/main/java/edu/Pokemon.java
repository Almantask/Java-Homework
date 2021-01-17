package edu;

public class Pokemon implements Attacker, Damagable{

    protected String name;
    protected String baseAttackText;
    protected int basePower;
    protected int health;
    protected boolean isConfused;

    public Pokemon(String name, int basePower, int health, String baseAttackText) {
        this.name = name;
        this.basePower = basePower;
        this.health = health;
        this.baseAttackText = baseAttackText;
    }

    public int getBasePower() {
        return basePower;
    }

    @Override
    public void attack(Damagable target) {
        target.setHP(target.getHP() - this.basePower);
        System.out.println(baseAttackText);
    }

    @Override
    public int getHP() {
        return health;
    }

    @Override
    public void setHP(int hp) {
        health = hp;
    }

    @Override
    public void setIsConfused(Boolean confused) {
        isConfused = confused;
    }

    @Override
    public boolean getIsConfused() {
        return isConfused;
    }
}
