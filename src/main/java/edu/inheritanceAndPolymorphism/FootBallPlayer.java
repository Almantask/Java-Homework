package edu.inheritanceAndPolymorphism;

public class FootBallPlayer extends Player{
    private float attempts;
    private float goals;

    public FootBallPlayer(Human human, String team) {
        super(human.getName(), human.getHeight(), human.getWeight(), team);
    }

    public FootBallPlayer(String name, float height, float weight, String team) {
        super(name, height, weight, team);
    }

    public float getAttempts() {
        return attempts;
    }

    public void setAttempts(float attempts) {
        this.attempts = attempts;
    }

    public float getGoals() {
        return goals;
    }

    public void setGoals(float goals) {
        this.goals = goals;
    }
}
