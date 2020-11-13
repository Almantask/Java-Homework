package Basketball;

/*### 3- Team (EASY)
        Team has members (at least 5) and a coach. It also has a name.*/

public class Team {
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private Player player5;
    private Coach coach;
    private String teamName;

    private class Coach {
    }

    public Team(Player player1, Player player2, Player player3, Player player4, Player player5, Coach coach, String teamName) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.player5 = player5;
        this.coach = coach;
        this.teamName = teamName;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getPlayer3() {
        return player3;
    }

    public Player getPlayer4() {
        return player4;
    }

    public Player getPlayer5() {
        return player5;
    }

    public Coach getCoach() {
        return coach;
    }

    public String getTeamName() {
        return teamName;
    }
}









