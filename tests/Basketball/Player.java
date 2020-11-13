package Basketball;

/*### 1- Player is a human (EASY)
        Player is a human, but it also has number (player number), position, game stats:*/


public class Player extends Human {
    private int playerNumber;
    private int position;
    private int gameStats;

    public Player(String name, String birthday, int age, String nationality, int playerNumber, int position, int gameStats) {
        super(name, birthday, age, nationality);
        this.playerNumber = playerNumber;
        this.position = position;
        this.gameStats = gameStats;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getGameStats() {
        return gameStats;
    }

    public void setGameStats(int gameStats) {
        this.gameStats = gameStats;
    }
}





