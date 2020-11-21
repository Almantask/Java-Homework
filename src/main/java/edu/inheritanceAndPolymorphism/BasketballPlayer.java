package edu.inheritanceAndPolymorphism;

// It's hard to design inheritance so that:
// 1- we get only what we need
// 2- we do not use parent stuff in child class
// 3- in the future, logical relationships do not break
// 4- not deep inheritance
// Doing inheritance is hard because it tends to break and is harder to maintain
// Prefer a simple composition over inheritance.
public class BasketballPlayer extends Player {
    private int twoPointsShots;
    private int twoPointsScored;

    public BasketballPlayer(Human human, String team){
        super(human.getName(), human.getHeight(), human.getWeight(), team);
    }

    public BasketballPlayer(String name, float height, float weight, String team, int twoPointsShots, int twoPointsScored) {
        super(name, height, weight, team);
        this.twoPointsShots = twoPointsShots;
        this.twoPointsScored = twoPointsScored;
    }

    public BasketballPlayer(String name, float height, float weight, String team) {
        super(name, height, weight, team);
    }

    public float getTwoPointsAccuracy(){
        if(twoPointsShots == 0) return 0;

        return twoPointsScored / (float)twoPointsShots;
    }

    public int getTwoPointsShots() {
        return twoPointsShots;
    }

    public void setTwoPointsShots(int twoPointsShots) {
        this.twoPointsShots = twoPointsShots;
    }

    public int getTwoPointsScored() {
        return twoPointsScored;
    }

    public void setTwoPointsScored(int twoPointsScored) {
        this.twoPointsScored = twoPointsScored;
    }
}
