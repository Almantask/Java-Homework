package BasketballGame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Game {

    //    private Team team;
    private Team teamOne;
    private Team teamTwo;
    private int teamOneScore;
    private int teamTwoScore;
    private LocalDateTime gameTime;




    public Game(Team teamOne, int teamOneScore,Team teamTwo, int teamTwoScore, LocalDateTime gameTime) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.teamOneScore = teamOneScore;
        this.teamTwoScore = teamTwoScore;
        this.gameTime = gameTime;
    }

    public Game () {

    }

    public static String getWinner (Game game) {
        System.out.println("Game time: " + game.getGameTime());
        if (game.getTeamOneScore() > game.getTeamTwoScore()) {
            return "The game won team " + game.getTeamOne().getTeamName() + " by " + (game.getTeamOneScore() - game.getTeamTwoScore()) + " points.";
        } else if (game.getTeamTwoScore() > game.getTeamOneScore()) {
            return "The game won team " + game.getTeamTwo().getTeamName() + " by " + (game.getTeamTwoScore() - game.getTeamOneScore()) + " points.";
        }else
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
