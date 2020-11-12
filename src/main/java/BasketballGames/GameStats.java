package BasketballGames;

public class GameStats {

    private int fouls;
    private int threePointScore;
    private int twoPointScore;
    private int threePointShots;
    private int twoPointShots;
    private float threePointAccuracy;
    private float twoPointAccuracy;
    private int rebounds;

    public GameStats(int fouls, int threePointScore, int twoPointScore, int threePointShots, int twoPointShots, float threePointAccuracy, float twoPointAccuracy, int rebounds) {
        this.fouls = fouls;
        this.threePointScore = threePointScore;
        this.twoPointScore = twoPointScore;
        this.threePointShots = threePointShots;
        this.twoPointShots = twoPointShots;
        this.threePointAccuracy = threePointAccuracy;
        this.twoPointAccuracy = twoPointAccuracy;
        this.rebounds = rebounds;
    }

    public int getFouls() {
        return fouls;
    }

    public void setFouls(int fouls) {
        this.fouls = fouls;
    }

    public int getThreePointScore() {
        return threePointScore;
    }

    public void setThreePointScore(int threePointScore) {
        this.threePointScore = threePointScore;
    }

    public int getTwoPointScore() {
        return twoPointScore;
    }

    public void setTwoPointScore(int twoPointScore) {
        this.twoPointScore = twoPointScore;
    }

    public int getThreePointShots() {
        return threePointShots;
    }

    public void setThreePointShots(int threePointShots) {
        this.threePointShots = threePointShots;
    }

    public int getTwoPointShots() {
        return twoPointShots;
    }

    public void setTwoPointShots(int twoPointShots) {
        this.twoPointShots = twoPointShots;
    }

    public float getThreePointAccuracy() {
        return threePointAccuracy;
    }

    public void setThreePointAccuracy(float threePointAccuracy) {
        this.threePointAccuracy = threePointAccuracy;
    }

    public float getTwoPointAccuracy() {
        return twoPointAccuracy;
    }

    public void setTwoPointAccuracy(float twoPointAccuracy) {
        this.twoPointAccuracy = twoPointAccuracy;
    }

    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    @Override
    public String toString() {
        return "GameStats{" +
                "fouls=" + fouls +
                ", threePointScore=" + threePointScore +
                ", twoPointScore=" + twoPointScore +
                ", threePointShots=" + threePointShots +
                ", twoPointShots=" + twoPointShots +
                ", threePointAccuracy=" + threePointAccuracy +
                ", twoPointAccuracy=" + twoPointAccuracy +
                ", rebounds=" + rebounds +
                '}';
    }
}