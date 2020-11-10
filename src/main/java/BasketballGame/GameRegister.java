package BasketballGame;



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
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        for (int i = 0; i < game.size(); i++) {
            System.out.println("********[The match date: " + game.get(i).getGameTime().format(myFormatObj) + "]**********");
            System.out.println("Team " + game.get(i).getTeamOne().getTeamName() + " vs " + "team " + game.get(i).getTeamTwo().getTeamName());
        }
    }

    public void printPastGames() {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        int localDateDay = LocalDateTime.now().getDayOfMonth();
        int localDateYear = LocalDateTime.now().getYear();
        int localDateMonth = LocalDateTime.now().getMonthValue();
        for (int i = 1; i < game.size(); i++) {
            if ((localDateYear <= game.get(i).getGameTime().getYear() ||
                    (localDateMonth <= game.get(i).getGameTime().getMonthValue()) ||
                    (localDateDay < game.get(i).getGameTime().getDayOfMonth()))) {
                System.out.println("********[The match date: " + game.get(i).getGameTime().format(myFormatObj) + "]**********");
                System.out.println("Team " + game.get(i).getTeamOne().getTeamName() + " vs " + "team " + game.get(i).getTeamTwo().getTeamName());
            }
        }
    }


    public void printTodaysGames () {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        int localDate = LocalDateTime.now().getDayOfMonth();
        for (int i = 1; i < game.size(); i++) {
            if (localDate == (game.get(i).getGameTime().getDayOfMonth())) {
                System.out.println("********[The match date: " + game.get(i).getGameTime().format(myFormatObj) + "]**********");
                System.out.println("Team " + game.get(i).getTeamOne().getTeamName() + " vs " + "team " + game.get(i).getTeamTwo().getTeamName());
            }
        }
    }

    // Create program for spaces in info template

    public void infoTemplate(Game game) {
        System.out.println("| " + game.getTeamOne().getTeamName() + " |                         |    | " + game.getTeamOneScore() +  ":" + game.getTeamTwoScore() + " |    | " + game.getTeamTwo().getTeamName() + " |                     |" );
        System.out.println("|--------------|-------------------------|----|-------|----|---------------------|---------------------|");
        System.out.println("|" + game.getTeamOne().getCoach().getCoachTitle() + "         |"+ game.getTeamOne().getCoach().getCoach().getName()                  +"           |    |       |    |"+ game.getTeamTwo().getCoach().getCoachTitle() +"                |"+ game.getTeamTwo().getCoach().getCoach().getName() +"       |");
        System.out.println("|" + game.getTeamOne().getPlayerOne().getPlayerNumber() + "            |"+ game.getTeamOne().getPlayerOne().getHuman().getName()                  +"             |    |       |    |"+ game.getTeamTwo().getPlayerOne().getPlayerNumber() +"                   |"+ game.getTeamTwo().getPlayerOne().getHuman().getName() +"         |");
        System.out.println("|" + game.getTeamOne().getPlayerOTwo().getPlayerNumber() + "            |"+ game.getTeamOne().getPlayerOTwo().getHuman().getName()                  +"              |    |       |    |"+ game.getTeamTwo().getPlayerOTwo().getPlayerNumber() +"                   |"+ game.getTeamTwo().getPlayerOTwo().getHuman().getName() +"          |");
    }


}


