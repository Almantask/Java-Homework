package BasketballGames;

import java.time.LocalDateTime;

public class Game {

    private final Team teamOne;
    private final Team teamTwo;
    private final int teamOneScore;
    private final int teamTwoScore;
    private final LocalDateTime gameDateTime;

    public Game(Team teamOne, Team teamTwo, int teamOneScore, int teamTwoScore, LocalDateTime gameDateTime) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.teamOneScore = teamOneScore;
        this.teamTwoScore = teamTwoScore;
        this.gameDateTime = gameDateTime;
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

    public LocalDateTime getGameDateTime() {
        return gameDateTime;
    }

    public Team getWinner() {
        if (teamOneScore > teamTwoScore) {
            return teamOne;
        } else {
            return teamTwo;
        }
    }
}