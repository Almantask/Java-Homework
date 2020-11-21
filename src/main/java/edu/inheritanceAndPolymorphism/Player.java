package edu.inheritanceAndPolymorphism;

// This demonstrates inheritance
// Inheritance forms an "is-a" relationship
// Where a child class (Player) is a parent class (Human) (logically)

public class Player extends Human{
    private String team;
    private int gamesPlayed;
    private int gamesWon;

    public Player(String name, float height, float weight, String team) {
        super(name, height, weight);
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public void whoAmI(){
        System.out.println("Player");
    }

    @Override
    public String toString() {
        return "Player{" +
                "team='" + team + '\'' +
                ", gamesPlayed=" + gamesPlayed +
                ", gamesWon=" + gamesWon +
                '}';
    }
}
