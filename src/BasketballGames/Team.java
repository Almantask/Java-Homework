package BasketballGames;

public class Team {
    private String name;
    private Player [] players;
    private Coach coach;

    public Team(String name, Player[] players, Coach coach) {
        if (players.length < 5) {
            System.out.println("Team should have at least 5 players");
        } else{
            this.name = name;
            this.players = players;
            this.coach = coach;
        }
    }

    public String getName() {
        return name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Coach getCoach() {
        return coach;
    }
}
