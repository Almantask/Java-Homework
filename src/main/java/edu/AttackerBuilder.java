package edu;

public class AttackerBuilder {

    private Attacker attacker;

    public AttackerBuilder(Attacker attacker) {
        this.attacker = attacker;
    }

    public Attacker build() {
        return attacker;
    }

    public AttackerBuilder withConfusion () {
        attacker = new AttackWithConfusion(attacker);
        return this;
    }

    public AttackerBuilder withLighting () {
        attacker = new AttackWithLighting(attacker);
        return this;
    }
}
