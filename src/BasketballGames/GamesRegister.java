package BasketballGames;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GamesRegister {
    private static Game [] games = new Game[0];

    public void addGame(Game game){
        games = addGameToArray(games,game);
    }

    public Game[] getGames(){
        return games;
    }

    public Game[] getPastGames(){
        Game [] pastGames = new Game[0];
        for (int i = 0; i < games.length; i++){
            if (games[i].getDateTime().isBefore(LocalDateTime.now())){
                pastGames = addGameToArray(pastGames, games[i]);
            }
        }
        return pastGames;
    }

    public Game[] getFutureGames(){
        Game [] futureGames = new Game[0];
        for (int i = 0; i < games.length; i++){
            if (games[i].getDateTime().isAfter(LocalDateTime.now())){
                futureGames = addGameToArray(futureGames, games[i]);
            }
        }
        return futureGames;
    }

    public Game[] getTodayGames(){
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("YYYY-MM-d");
        return getGamesUsingFormatter(dayFormatter);
    }

    public Game[] getGamesOfThisWeek(){
        DateTimeFormatter weekFormatter = DateTimeFormatter.ofPattern("W");
        return getGamesUsingFormatter(weekFormatter);
    }

    private Game [] getGamesUsingFormatter(DateTimeFormatter formatter) {
        Game[] gamesArray = new Game[0];
        for (int i = 0; i < games.length; i++) {
            if (games[i].getDateTime().format(formatter).equals(LocalDateTime.now().format(formatter))) {
                gamesArray = addGameToArray(gamesArray, games[i]);
            }
        }
        return gamesArray;
    }

    public Game[] getGamesAtMonth (LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM");
        return getGamesUsingFormatterAndDateTime(dateTime, formatter);
    }

    public Game[] getGamesAtDay (LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-d");
        return getGamesUsingFormatterAndDateTime(dateTime, formatter);
    }

    public Game[] getGamesAtTime (LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-d HH:mm");
        return getGamesUsingFormatterAndDateTime(dateTime, formatter);
    }

    private Game [] getGamesUsingFormatterAndDateTime(LocalDateTime dateTime, DateTimeFormatter formatter) {
        Game[] gamesArray = new Game[0];
        for (int i = 0; i < games.length; i++) {
            if (games[i].getDateTime().format(formatter).equals(dateTime.format(formatter))) {
                gamesArray = addGameToArray(gamesArray, games[i]);
            }
        }
        return gamesArray;
    }

    private Game[] addGameToArray (Game [] array, Game newGame){
        Game[] newArray = new Game[array.length+1];
        for (int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        newArray[newArray.length-1] = newGame;
        return newArray;
    }

 }
