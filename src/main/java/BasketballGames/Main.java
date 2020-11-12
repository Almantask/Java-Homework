package BasketballGames;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Coach lakersCoach = new Coach("Frank Vogel", LocalDate.of(1973, 6, 21), "American");
        Coach heatCoach = new Coach("Erik Spoelstra", LocalDate.of(1970, 11, 1), "American");

        GameStats statsLakersPlayerOne = new GameStats(2, 21, 10, 7, 5, 50, 12, 5);
        GameStats statsLakersPlayerTwo = new GameStats(3, 18, 12, 6, 6, 35, 12, 5);
        GameStats statsLakersPlayerThree = new GameStats(4, 12, 8, 4, 4, 40, 12, 5);
        GameStats statsLakersPlayerFour = new GameStats(1, 9, 10, 3, 5, 45, 12, 5);
        GameStats statsLakersPlayerFive = new GameStats(2, 6, 12, 2, 6, 35, 12, 5);

        Player lakersPlayerOne = new Player("LeBron James", LocalDate.of(1984, 12, 30), "American", 23, "Small Forward", statsLakersPlayerOne);
        Player lakersPlayerTwo = new Player("Jared Dudley", LocalDate.of(1985, 7, 10), "American", 10, "Small Forward", statsLakersPlayerTwo);
        Player lakersPlayerThree = new Player("Kostas Antetokounmpo", LocalDate.of(1997, 10, 20), "Greece", 37, "Power Forward", statsLakersPlayerThree);
        Player lakersPlayerFour = new Player("Anthony Davis", LocalDate.of(1993, 3, 11), "American", 3, "Power Forward", statsLakersPlayerFour);
        Player lakersPlayerFive = new Player("Kyle Kuzma", LocalDate.of(1995, 7, 24), "American", 0, "Power Forward", statsLakersPlayerFive);

        GameStats statsHeatPlayerOne = new GameStats(1, 4, 5, 4, 5, 45, 12, 5);
        GameStats statsHeatPlayerTwo = new GameStats(4, 4, 5, 4, 5, 45, 12, 5);
        GameStats statsHeatPlayerThree = new GameStats(4, 4, 5, 4, 5, 45, 12, 5);
        GameStats statsHeatPlayerFour = new GameStats(3, 4, 5, 4, 5, 45, 12, 5);
        GameStats statsHeatPlayerFive = new GameStats(2, 4, 5, 4, 5, 45, 12, 5);

        Player heatPlayerOne = new Player("Bam Adebayo", LocalDate.of(1997, 7, 18), "American", 13, "Power Forward", statsHeatPlayerOne);
        Player heatPlayerTwo = new Player("Jimmy Butler", LocalDate.of(1989, 9, 14), "American", 22, "Small Forward", statsHeatPlayerTwo);
        Player heatPlayerThree = new Player("Jae Crowder", LocalDate.of(1990, 7, 6), "American", 99, "Small Forward", statsHeatPlayerThree);
        Player heatPlayerFour = new Player("Solomon Hill", LocalDate.of(1991, 3, 18), "American", 44, "Small Forward", statsHeatPlayerFour);
        Player heatPlayerFive = new Player("Derrick Jones Jr.", LocalDate.of(1997, 5, 19), "American", 5, "Small Forward", statsHeatPlayerFive);

        Team teamLosAngelesLakers = new Team("Los Angeles Lakers", lakersCoach, Set.of(lakersPlayerOne, lakersPlayerTwo, lakersPlayerThree, lakersPlayerFour, lakersPlayerFive));
        Team teamMiamiHeat = new Team("Miami Heat", heatCoach, Set.of(heatPlayerOne, heatPlayerTwo, heatPlayerThree, heatPlayerFour, heatPlayerFive));

        GameRegister gameRegister = new GameRegister();
        gameRegister.addGame(new Game(teamMiamiHeat, teamLosAngelesLakers, 55, 58, LocalDateTime.of(2020, 10, 30, 21, 0, 0)));
        gameRegister.addGame(new Game(teamLosAngelesLakers, teamMiamiHeat, 102, 99, LocalDateTime.of(2020, 11, 6, 21, 0, 0)));
        gameRegister.addGame(new Game(teamMiamiHeat, teamLosAngelesLakers, 106, 93, LocalDateTime.of(2020, 11, 11, 21, 0, 0)));
        gameRegister.addGame(new Game(teamLosAngelesLakers, teamMiamiHeat, 0, 0, LocalDateTime.of(2020, 11, 20, 21, 0, 0)));
    }
}