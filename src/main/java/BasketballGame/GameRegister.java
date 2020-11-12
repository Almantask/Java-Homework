package BasketballGame;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

public class GameRegister {
    //I know we didn't lear anything about ArrayList, but i have did that on my own and for
    // it's a lot easier to do it with ArrayList.
    private final ArrayList<Game> game;
    private LocalDateTime localDateTime = LocalDateTime.now();
    private final DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public GameRegister() {
        this.game = new ArrayList<Game>();
    }

    public void addGame(Game game) {
        this.game.add(game);
    }

    public void printGameRegister() {
        for (int i = 0; i < game.size(); i++) {
            printDate(i);
        }
    }

    public void printPastGames() {
        for (int i = 0; i < game.size(); i++) {
            if (game.get(i).getGameTime().isBefore(localDateTime)) {
                printDateWithScores(i);
            }
        }
    }

    public void printFutureGames() {
        for (int i = 0; i < game.size(); i++) {
            if (game.get(i).getGameTime().isAfter(localDateTime)) {
                printDate(i);
            }
        }
    }

    public void getGamesOfThisWeek() {
        LocalDateTime monday = localDateTime.with(previousOrSame(MONDAY));
        LocalDateTime sunday = localDateTime.with(nextOrSame(SUNDAY));
        for (int i = 0; i < game.size(); i++) {
            if (monday.getDayOfMonth() <= game.get(i).getGameTime().getDayOfMonth() && sunday.getDayOfMonth() >= game.get(i).getGameTime().getDayOfMonth()) {
                printDate(i);
            }
        }
    }

    public void getGamesAtDateTime(DateTime dateTime) {
        int year = dateTime.getYear(),month = dateTime.getMonth(), day = dateTime.getDay(), hour = dateTime.getHour();
        for (int i = 0; i < game.size(); i++) {
            int gameYear = game.get(i).getGameTime().getYear(), gameMonth = game.get(i).getGameTime().getMonth().getValue();
            int gameDay = game.get(i).getGameTime().getDayOfMonth(), gameHour = game.get(i).getGameTime().getHour();
            if (year != 0 && month != 0 && day != 0 && hour != 0) {
                if (year == gameYear && month == gameMonth && day == gameDay && hour == gameHour) {
                    printDate(i);
                }
            } else if (year != 0 && month != 0 && day != 0) {
                if (year == gameYear && month == gameMonth && day == gameDay) {
                    printDate(i);
                }
            } else if (year != 0 && month != 0) {
                if (year == gameYear && month == gameMonth) {
                    printDate(i);
                }
            }
        }
    }

    public void printTodaysGames() {
        for (int i = 0; i < game.size(); i++) {
            if (localDateTime.getDayOfMonth() == (game.get(i).getGameTime().getDayOfMonth())) {
                printDate(i);
            }
        }
    }

    public void printGameInformation (Game game) {
        topOrBottom(game,"Top");
        printRow(game);
        topOrBottom(game,"Bottom");
    }

    private String topOrBottom (Game game, String topOrBottom) {
        if (topOrBottom.equals("Top")) {
            System.out.println("|" + fixedLengthString(game.getTeamOne().getTeamName(),22) + fixedLengthString("|",23) + "|    | " + game.getTeamOneScore() + ":"
                    + game.getTeamTwoScore() + " |    | " + fixedLengthString(game.getTeamTwo().getTeamName(),22) + fixedLengthString(" |",23) + "|");
            System.out.println("|----------------------|----------------------|----|-------|----|------------------------|---------------------|");
            System.out.println("|" + fixedLengthString("Coach",22) + "|" + fixedLengthString(game.getTeamOne().getCoach().getName(),22) + "|    |       |    |"
                    + fixedLengthString("Coach",24) + "|" + fixedLengthString(game.getTeamTwo().getCoach().getName(),21) + "|");
            return " ";
        } else if (topOrBottom.equals("Bottom")) {
            System.out.println("|----------------------|----------------------|----|-------|----|------------------------|---------------------|");
            System.out.println("Match started at: " + game.getGameTime().format(myFormatObj));
            return "";
        }
        return null;
    }

    private void printRow (Game game) {
        String [] teamOneNumbers = generateTeamNumbers(game,"TeamOne");
        String [] teamTwoNumbers = generateTeamNumbers(game,"TeamTwo");
        String [] teamOneNames = generateTeamNames(game,"TeamOne");
        String [] teamTwoNames = generateTeamNames(game,"TeamTwo");
        for (int i = 0; i < teamOneNames.length; i++) {
            System.out.println("|"+fixedLengthString(teamOneNames[i],22)+"|" + fixedLengthString(teamOneNumbers[i],22)+"|    |       |    |"
                    + fixedLengthString(teamTwoNames[i],24)+"|"+fixedLengthString(teamTwoNumbers[i], 21)+"|");
        }
    }

    private String [] generateTeamNumbers (Game game, String team) {
        String [] teamOneNames = {PlayerName("One", game),PlayerName("Two", game),PlayerName("Three", game), PlayerName("Four", game),PlayerName("Five", game) };
        String [] teamTwoNames = {PlayerNameTwo("One", game),PlayerNameTwo("Two", game),PlayerNameTwo("Three", game), PlayerNameTwo("Four", game),PlayerNameTwo("Five", game) };
        if (team.equals("TeamOne")) {
            return teamOneNames;
        } else if (team.equals("TeamTwo")) {
            return teamTwoNames;
        }
        return null;
    }

    private String [] generateTeamNames (Game game, String team) {
        String [] teamOne = {PlayerNumber("One", game),PlayerNumber("Two", game), PlayerNumber("Three", game), PlayerNumber("Four", game),PlayerNumber("Five", game)};
        String [] teamTwo = {PlayerNumberTwo("One", game),PlayerNumberTwo("Two", game), PlayerNumberTwo("Three", game),PlayerNumberTwo("Four", game),PlayerNumberTwo("Five", game)};
        if (team.equals("TeamOne")) {
            return teamOne;
        } else if (team.equals("TeamTwo")) {
            return teamTwo;
        }
        return null;
    }

    private String PlayerNameTwo(String player, Game game) {
        if (player.equals("One")) {
            return game.getTeamTwo().getPlayerOne().getHuman().getName();
        } else if (player.equals("Two")) {
            return game.getTeamTwo().getPlayerOTwo().getHuman().getName();
        } else if (player.equals("Three")) {
            return game.getTeamTwo().getPlayerThree().getHuman().getName();
        } else if (player.equals("Four")) {
            return game.getTeamTwo().getPlayerFour().getHuman().getName();
        } else if (player.equals("Five")) {
            return game.getTeamTwo().getPlayerFive().getHuman().getName();
        }
        return null;
    }

    private String PlayerName(String player, Game game) {
        if (player.equals("One")) {
            return game.getTeamOne().getPlayerOne().getHuman().getName();
        } else if (player.equals("Two")) {
            return game.getTeamOne().getPlayerOTwo().getHuman().getName();
        } else if (player.equals("Three")) {
            return game.getTeamOne().getPlayerThree().getHuman().getName();
        } else if (player.equals("Four")) {
            return game.getTeamOne().getPlayerFour().getHuman().getName();
        } else if (player.equals("Five")) {
            return game.getTeamOne().getPlayerFive().getHuman().getName();
        }
        return null;
    }

    private String PlayerNumber(String player, Game game) {
        if (player.equals("One")) {
            return String.valueOf(game.getTeamOne().getPlayerOne().getPlayerNumber());
        } else if (player.equals("Two")) {
            return String.valueOf(game.getTeamOne().getPlayerOTwo().getPlayerNumber());
        } else if (player.equals("Three")) {
            return String.valueOf(game.getTeamOne().getPlayerThree().getPlayerNumber());
        } else if (player.equals("Four")) {
            return String.valueOf(game.getTeamOne().getPlayerFour().getPlayerNumber());
        } else if (player.equals("Five")) {
            return String.valueOf(game.getTeamOne().getPlayerFive().getPlayerNumber());
        }
        return null;
    }

    private String PlayerNumberTwo(String player, Game game) {
        if (player.equals("One")) {
            return String.valueOf(game.getTeamTwo().getPlayerOne().getPlayerNumber());
        } else if (player.equals("Two")) {
            return String.valueOf(game.getTeamTwo().getPlayerOTwo().getPlayerNumber());
        } else if (player.equals("Three")) {
            return String.valueOf(game.getTeamTwo().getPlayerThree().getPlayerNumber());
        } else if (player.equals("Four")) {
            return String.valueOf(game.getTeamTwo().getPlayerFour().getPlayerNumber());
        } else if (player.equals("Five")) {
            return String.valueOf(game.getTeamTwo().getPlayerFive().getPlayerNumber());
        }
        return null;
    }

    private void printDate (int i) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.println("********[The match date: " + game.get(i).getGameTime().format(myFormatObj) + "]**********");
        System.out.println("Team " + game.get(i).getTeamOne().getTeamName() + " vs " + "team " + game.get(i).getTeamTwo().getTeamName());
    }

    private void printDateWithScores (int i) {
        System.out.println("********[The match date: " + game.get(i).getGameTime().format(myFormatObj) + "]**********");
        System.out.println("Team " + game.get(i).getTeamOne().getTeamName() + " score (" + game.get(i).getTeamOneScore() + ") vs (" + game.get(i).getTeamTwoScore() + ") team " + game.get(i).getTeamTwo().getTeamName());
    }

    private String fixedLengthString(String string, int length) {
        return String.format("%-" + length + "." + length + "s", string);
    }


}


