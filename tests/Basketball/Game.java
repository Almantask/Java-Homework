package Basketball;

//Game has 2 teams, a score and a datetime.
//It also has a function `Team getWinner()` to return the winner team.


import java.time.LocalDateTime;

public class Game {

    private Team team1;
    private Team team2;
    private int team1Score;
    private int team2Score;
    private LocalDateTime teamDateTime;

    public Game(Team team1, Team team2, int team1Score, int team2Score, LocalDateTime teamDateTime) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Score = team1Score;
        this.team2Score = team2Score;
        this.teamDateTime = teamDateTime;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public LocalDateTime getTeamDateTime() {
        return teamDateTime;
    }
    public Team getWinner() {
        if (team1Score > team2Score) {
            return team1;
        }else {
            return team2;
        }
    }

}





