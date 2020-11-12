package BasketballGames;

import java.util.Set;

public class Team {
    private final String teamName;
    private final Coach coach;
    private final Set<Player> players;

    public Team(String teamName, Coach coach, Set<Player> players) {
        this.teamName = teamName;
        this.coach = coach;
        this.players = players;
    }

    public String getTeamName() {
        return teamName;
    }

    public Coach getCoach() {
        return coach;
    }

    public Set<Player> getPlayers() {
        return players;
    }
}