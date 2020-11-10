package BasketballGame;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GameRegister {
    //I know we didn't lear anything about ArrayList, but i have did that on my own and for
    // it's a lot easier to do it with ArrayList.
    private ArrayList<Game> game;

    public GameRegister() {
        this.game = new ArrayList<Game>();
    }

    public void addGame(Game game) {
        this.game.add(game);
    }

    public void printGameRegister () {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (int i = 0; i < game.size(); i++) {
            System.out.println("********[The match date: " + game.get(i).getGameTime().format(myFormatObj) + "]**********");
            System.out.println("Team " + game.get(i).getTeamOne().getTeamName() + " vs " + "team " + game.get(i).getTeamTwo().getTeamName());
        }
    }

    public void printPastGames() {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.now();
        for (int i = 0; i < game.size(); i++) {
            if (game.get(i).getGameTime().isBefore(localDateTime)) {
                System.out.println("********[The match date: " + game.get(i).getGameTime().format(myFormatObj) + "]**********");
                System.out.println("Team " + game.get(i).getTeamOne().getTeamName() + " score (" + game.get(i).getTeamOneScore() + ") vs (" + game.get(i).getTeamTwoScore() + ") team " + game.get(i).getTeamTwo().getTeamName());

            }
        }
    }

    public void printFutureGames() {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.now();
        for (int i = 0; i < game.size(); i++) {
            if (game.get(i).getGameTime().isAfter(localDateTime)) {
                System.out.println("********[The match date: " + game.get(i).getGameTime().format(myFormatObj) + "]**********");
                System.out.println("Team " + game.get(i).getTeamOne().getTeamName() + " vs " + " team " + game.get(i).getTeamTwo().getTeamName());

            }
        }
    }

    public void getGamesOfThisWeek () {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime monday = today.with(previousOrSame(MONDAY));
        LocalDateTime sunday = today.with(nextOrSame(SUNDAY));
        for (int i = 0; i < game.size(); i++) {
            if (monday.getDayOfMonth() <= game.get(i).getGameTime().getDayOfMonth() && sunday.getDayOfMonth() >= game.get(i).getGameTime().getDayOfMonth()) {
                System.out.println("********[The match date: " + game.get(i).getGameTime().format(myFormatObj) + "]**********");
                System.out.println("Team " + game.get(i).getTeamOne().getTeamName() + " vs " + "team " + game.get(i).getTeamTwo().getTeamName());
            }
        }
    }

    public void getGamesAtDateTime(DateTime dateTime) {
        int year = dateTime.getYear();
        int month = dateTime.getMonth();
        int day = dateTime.getDay();
        int hour = dateTime.getHour();

        if (year != 0 && month != 0 && day != 0 && hour != 0) {

            System.out.println("All fields filled");
        } else if (year != 0 && month != 0 && day != 0) {
            System.out.println("Three fields filled");
        } else if (year != 0 && month != 0) {
            System.out.println("Two fields filled");
        }

    }

    public void printTodaysGames () {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        int localDate = LocalDateTime.now().getDayOfMonth();
        for (int i = 0; i < game.size(); i++) {
            if (localDate == (game.get(i).getGameTime().getDayOfMonth())) {
                System.out.println("********[The match date: " + game.get(i).getGameTime().format(myFormatObj) + "]**********");
                System.out.println("Team " + game.get(i).getTeamOne().getTeamName() + " vs " + "team " + game.get(i).getTeamTwo().getTeamName());
            }
        }
    }
    public String printPlayerNameTwo(String player, Game game) {
        if (player.equals("One")) {
            return game.getTeamTwo().getPlayerOne().getHuman().getName();
        } else if (player.equals("Two")) {
            return game.getTeamTwo().getPlayerOTwo().getHuman().getName();
        }else if (player.equals("Three")) {
            return game.getTeamTwo().getPlayerThree().getHuman().getName();
        }else if (player.equals("Four")) {
            return game.getTeamTwo().getPlayerFour().getHuman().getName();
        }else if (player.equals("Five")) {
            return game.getTeamTwo().getPlayerFive().getHuman().getName();
        }
        return null;
    }

    public String printPlayerName(String player, Game game) {
        if (player.equals("One")) {
            return game.getTeamOne().getPlayerOne().getHuman().getName();
        } else if (player.equals("Two")) {
            return game.getTeamOne().getPlayerOTwo().getHuman().getName();
        }else if (player.equals("Three")) {
            return game.getTeamOne().getPlayerThree().getHuman().getName();
        }else if (player.equals("Four")) {
            return game.getTeamOne().getPlayerFour().getHuman().getName();
        }else if (player.equals("Five")) {
            return game.getTeamOne().getPlayerFive().getHuman().getName();
        }
        return null;
    }

    public int printPlayerNumber (String player, Game game) {
        if (player.equals("One")) {
            return game.getTeamOne().getPlayerOne().getPlayerNumber();
        } else if (player.equals("Two")) {
            return game.getTeamOne().getPlayerOTwo().getPlayerNumber();
        }else if (player.equals("Three")) {
            return game.getTeamOne().getPlayerThree().getPlayerNumber();
        }else if (player.equals("Four")) {
            return game.getTeamOne().getPlayerFour().getPlayerNumber();
        }else if (player.equals("Five")) {
            return game.getTeamOne().getPlayerFive().getPlayerNumber();
        }
        return -1;
    }

    public int printPlayerNumberTwo (String player, Game game) {
        if (player.equals("One")) {
            return game.getTeamTwo().getPlayerOne().getPlayerNumber();
        } else if (player.equals("Two")) {
            return game.getTeamTwo().getPlayerOTwo().getPlayerNumber();
        }else if (player.equals("Three")) {
            return game.getTeamTwo().getPlayerThree().getPlayerNumber();
        }else if (player.equals("Four")) {
            return game.getTeamTwo().getPlayerFour().getPlayerNumber();
        }else if (player.equals("Five")) {
            return game.getTeamTwo().getPlayerFive().getPlayerNumber();
        }
        return -1;
    }

    // Create program for spaces in info template

    public void printGameInformation(Game game) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("| " + game.getTeamOne().getTeamName() + " |                         |    | " + game.getTeamOneScore() +  ":" + game.getTeamTwoScore() + " |    | " + game.getTeamTwo().getTeamName() + " |                     |" );
        System.out.println("|--------------|-------------------------|----|-------|----|---------------------|---------------------|");
        System.out.println("|" + game.getTeamOne().getCoach().getCoachTitle() + "         |"+ game.getTeamOne().getCoach().getCoach().getName()                  +"           |    |       |    |"+ game.getTeamTwo().getCoach().getCoachTitle() +"                |"+ game.getTeamTwo().getCoach().getCoach().getName() +"         |");
        System.out.println("|" + printPlayerNumber("One", game) + "            |"+ printPlayerName("One",game)                  +"             |    |       |    |"+ printPlayerNumberTwo("One", game) +"                   |"+ printPlayerNameTwo("One",game) +"         |");
        System.out.println("|" + printPlayerNumber("Two", game) + "            |"+ printPlayerName("Two",game)                   +"              |    |       |    |"+ printPlayerNumberTwo("Two", game) +"                   |"+ printPlayerNameTwo("Two",game) +"          |");
        System.out.println("|" + printPlayerNumber("Three", game) + "            |"+ printPlayerName("Three",game)                   +"             |    |       |    |"+ printPlayerNumberTwo("Three", game) +"                   |"+ printPlayerNameTwo("Three",game) +"         |");
        System.out.println("|" + printPlayerNumber("Four", game) + "            |"+ printPlayerName("Four",game)                   +"          |    |       |    |"+ printPlayerNumberTwo("Four", game) +"                   |"+ printPlayerNameTwo("Four",game) +"      |");
        System.out.println("|" + printPlayerNumber("Five", game) + "            |"+ printPlayerName("Five",game)                   +"              |    |       |    |"+ printPlayerNumberTwo("Five", game) +"                    |"+ printPlayerNameTwo("Five",game) +"          |");
        System.out.println("|------------------------------------------------------------------------------------------------------|");
        System.out.println("Match started at: " + game.getGameTime().format(myFormatObj));
    }


}


