package BasketballGame;

public class Team {

    private String teamName;
    private Human coach;
    private Player playerOne;
    private Player playerOTwo;
    private Player playerThree;
    private Player playerFour;
    private Player playerFive;

    public Team(String teamName, Human coach, Player playerOne, Player playerOTwo, Player playerThree, Player playerFour, Player playerFive) {
        this.teamName = teamName;
        this.coach = coach;
        this.playerOne = playerOne;
        this.playerOTwo = playerOTwo;
        this.playerThree = playerThree;
        this.playerFour = playerFour;
        this.playerFive = playerFive;
    }

    public Team() {
    }

    public String getTeamName() {
        return teamName;
    }

    public Human getCoach() {
        return coach;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerOTwo() {
        return playerOTwo;
    }

    public Player getPlayerThree() {
        return playerThree;
    }

    public Player getPlayerFour() {
        return playerFour;
    }

    public Player getPlayerFive() {
        return playerFive;
    }
}
