package Basketball;

/*      - fouls
        - 3-point score
        - 2-point scores
        - 3-point shots
        - 2-point shots
        - 2-point accuracy
        - 3-point accuracy
        - rebounds*/

public class GameStats {
    private int fouls;
    private int threePointScore;
    private int twoPointScore;
    private int threePointShots;
    private int twoPointShots;
    private int threePointAccuracy;
    private int twoPointAccuracy;

    public GameStats(int fouls, int threePointScore, int twoPointScore, int threePointShots, int twoPointShots, int threePointAccuracy, int twoPointAccuracy) {
        this.fouls = fouls;
        this.threePointScore = threePointScore;
        this.twoPointScore = twoPointScore;
        this.threePointShots = threePointShots;
        this.twoPointShots = twoPointShots;
        this.threePointAccuracy = threePointAccuracy;
        this.twoPointAccuracy = twoPointAccuracy;
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

    public int getThreePointAccuracy() {
        return threePointAccuracy;
    }

    public void setThreePointAccuracy(int threePointAccuracy) {
        this.threePointAccuracy = threePointAccuracy;
    }

    public int getTwoPointAccuracy() {
        return twoPointAccuracy;
    }

    public void setTwoPointAccuracy(int twoPointAccuracy) {
        this.twoPointAccuracy = twoPointAccuracy;
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
                '}';
    }
}
