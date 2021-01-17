package edu;

public class Demo {
    public static void main(String[] args) {

        Pokemon pikachu = new Pokemon("Pikachu", 5, 100, "do a slash with a tail");
        Pokemon Snorlack = new Pokemon("Snorlack", 5, 100, "punches");
        Pokemon Hypnotoad = new Pokemon("Hypnotoad", 5, 100, "sends a psycho attack");

        Attacker pikachuWithLighting = new AttackWithLighting(pikachu);
        Attacker pikachuWithLightingAndConfusion = new AttackWithConfusion(pikachuWithLighting);

        Attacker hypnotoadWithDoubleLighting = new AttackerBuilder(Hypnotoad)
                .withLighting()
                .withLighting()
                .withConfusion()
                .build();

        hypnotoadWithDoubleLighting.attack(pikachu);

    }
}
