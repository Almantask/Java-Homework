package edu;

public class AttackWithConfusion implements Attacker {

    private final Attacker attacker;

    public AttackWithConfusion(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void attack(Damagable target) {
        attacker.attack(target);
        System.out.println("confuses an enemy");
        target.setIsConfused(true);
    }

    @Override
    public int getBasePower() {
        return 5;
    }
}
