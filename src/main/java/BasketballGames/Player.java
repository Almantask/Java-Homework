package BasketballGames;

import java.time.LocalDate;

public class Player extends Human {

    private int number;
    private String position;
    private GameStats gameStats;

    public Player(String name, LocalDate birthday, String nationality, int number, String position, GameStats gameStats) {
        super(name, birthday, nationality);
        this.number = number;
        this.position = position;
        this.gameStats = gameStats;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public GameStats getGameStats() {
        return gameStats;
    }

    public void setGameStats(GameStats gameStats) {
        this.gameStats = gameStats;
    }
}