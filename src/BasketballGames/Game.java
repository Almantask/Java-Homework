package BasketballGames;

import java.time.LocalDateTime;

public class Game {
    private Team[] teams = new Team[2];
    private int[] score = new int[2];
    private LocalDateTime dateTime;

    public Game(Team[] teams, int[] score, LocalDateTime dateTime) {
        this.teams = teams;
        this.score = score;
        this.dateTime = dateTime;
    }

    public Team[] getTeams() {
        return teams;
    }

    public int[] getScore() {
        return score;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Team getWinner() {
        if (score[0] > score[1]) {
            return teams[0];//the winner team.
        } else if (score[1] > score[0]) {
            return teams[1];
        } else {
            System.out.println("There is no winner.");
        }
        return null;
    }

    @Override
    public String toString() {
        String textPlayers = "";
        for (int j = 0; j < teams[0].getPlayers().length; j++) {
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    textPlayers += "\n";
                }
                textPlayers += String.format("|Player %s | %-10s %-15s |",
                        teams[i].getPlayers()[j].getPlayerNumber(),
                        teams[i].getPlayers()[j].getHuman().getName(),
                        teams[i].getPlayers()[j].getHuman().getSurname());
                if (i == 0) {
                    textPlayers += "               ";
                }
            }
        }

        return String.format("| %s |                            |   |%3s:%3s|   | %s |                            |", teams[0].getName(), score[0], score[1], teams[1].getName()) +
                        "\n|---------|----------------------------|---|-------|---|---------|----------------------------|" +
                        String.format("\n| Coach   | %-10s %-15s |               ", teams[0].getCoach().getHuman().getName(), teams[0].getCoach().getHuman().getSurname()) +
                        String.format("| Coach   | %-10s %-15s |", teams[1].getCoach().getHuman().getName(), teams[1].getCoach().getHuman().getSurname()) +
                        textPlayers;
    }
}
