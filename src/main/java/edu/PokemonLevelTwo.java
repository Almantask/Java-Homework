package edu;

public class PokemonLevelTwo extends PokemonLevelUp{

    private final Pokemon pokemon;

    public PokemonLevelTwo(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public String additionalAttack(String attack) {
        return pokemon.getAttackDescription() + " " + attack;
    }

    @Override
    public int getAttackPower() {
        return 10 + pokemon.getAttackPower();
    }
}
