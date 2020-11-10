package BasketballGame;

public class Player{

    private Human human;
    private int playerNumber;
    private String position;

    public Player(Human human, int playerNumber, String position) {
        this.human = human;
        this.playerNumber = playerNumber;
        this.position = position;
    }

    public Human getHuman() {
        return human;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public String getPosition() {
        return position;
    }

    public static class gameStats {

        private int fouls;
        private int rebounds;
        private int threePointScore;
        private int twoPointScore;
        private int threePointShots;
        private int twoPointShots;

        public float threePointAccuracy() {
            return (getThreePointShots() / getThreePointScore()) * 100;
        }

        public float twoPointAccuracy() {
            return (getTwoPointShots() / getTwoPointScore()) * 100;
        }

        public int getFouls() {
            return fouls;
        }

        public void setFouls(int fouls) {
            this.fouls = fouls;
        }

        public int getRebounds() {
            return rebounds;
        }

        public void setRebounds(int rebounds) {
            this.rebounds = rebounds;
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

    }
}