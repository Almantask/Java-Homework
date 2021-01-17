package edu;

public class AttackWithLighting implements Attacker {

    private final Attacker attacker;

    public AttackWithLighting(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void attack(Damagable target) {
        attacker.attack(target);
        System.out.println("does a lightining attack");
        target.setHP(target.getHP() - this.getBasePower());
    }

    @Override
    public int getBasePower() {
        return 5;
    }
}
