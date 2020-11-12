package BasketballGames;

public class Player {

    private Human human;
    private int playerNumber;
    private String position;

    public Player(Human human, int playerNumber, String position) {
        this.human = human;
        this.playerNumber = playerNumber;
        this.position = position;
    }

    public class GameStats {
        private int fouls;
        private int threePointScores;
        private int twoPointScores;
        private int threePointShots;
        private int twoPointShots;
        private int twoPointAccuracy;
        private int threePointAccuracy;
        private int rebounds;
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

}
