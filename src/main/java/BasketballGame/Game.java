package BasketballGame;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Game {


    private Team teamOne;
    private Team teamTwo;
    private int teamOneScore;
    private int teamTwoScore;
    private LocalDateTime gameTime;


    public Game(Team teamOne, int teamOneScore, Team teamTwo, int teamTwoScore, LocalDateTime gameTime) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.teamOneScore = teamOneScore;
        this.teamTwoScore = teamTwoScore;
        this.gameTime = gameTime;
    }

    public static String getWinner(Game game) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("Game time: " + game.getGameTime().format(myFormatObj));
        if (game.getTeamOneScore() > game.getTeamTwoScore() ) {
            return String.valueOf(game.getTeamOne().getTeamName());
        } else if (game.getTeamTwoScore() > game.getTeamOneScore()) {
            return String.valueOf(game.getTeamTwo().getTeamName());
        } else
            System.out.println("Draw.");
        return "Draw.";
    }

    public Team getTeamOne() {
        return teamOne;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }

    public int getTeamOneScore() {
        return teamOneScore;
    }

    public int getTeamTwoScore() {
        return teamTwoScore;
    }

    public LocalDateTime getGameTime() {
        return gameTime;
    }
}
