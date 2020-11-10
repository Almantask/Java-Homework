package BasketballGame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        GameRegister gameRegister = new GameRegister();

        Human edvinas = new Human("Edvinas Alimas", LocalDate.of(1998,8,19),22, "Lithuanian");
        Human lebron = new Human("Lebron James", LocalDate.of(1985,2,19),35, "US");
        Human kobe = new Human("Kobe Bryant", LocalDate.of(1990,8,19),30, "US");
        Human harden = new Human("James Harden", LocalDate.of(1989,8,19),31, "US");
        Human sabonis = new Human("Andrius Sabonis", LocalDate.of(1990,8,19),30, "Lithuanian");
        Human mahone = new Human("John Mahone", LocalDate.of(1992,8,19),28, "Russia");
        Human brad = new Human("Brad Stevens", LocalDate.of(1972,8,19),48, "Lithuanian");
        Coach coach = new Coach(edvinas);

        Player lebronPlayer = new Player(lebron,19,"PG");
        Player kobePlayer = new Player(kobe,25, "SG");
        Player hardenPlayer = new Player(harden,18,"C");
        Player sabonisPlayer = new Player(sabonis,15, "SF");
        Player mahonePlayer = new Player(mahone,29, "SF");

        Coach coach1 = new Coach(brad);
        Player lebronPlayer1 = new Player(lebron,23,"PG");
        Player kobePlayer1 = new Player(kobe,88, "SG");
        Player hardenPlayer1 = new Player(harden,69,"C");
        Player sabonisPlayer1 = new Player(sabonis,96, "SF");
        Player mahonePlayer1 = new Player(mahone,2, "SF");

        Team thunderCats = new Team("Thunder cats",coach,lebronPlayer, kobePlayer,hardenPlayer,sabonisPlayer,mahonePlayer);
        Team clevelandCavaliers = new Team("Cleveland cavaliers",coach1,lebronPlayer1, kobePlayer1,hardenPlayer1,sabonisPlayer1,mahonePlayer1);

        Game gameOne = new Game(thunderCats,62, clevelandCavaliers, 60, LocalDateTime.of(2020,11,1,10,50));
        Game gameTwo = new Game(thunderCats,96, clevelandCavaliers, 69, LocalDateTime.of(2020,11,10,11,55));
        Game gameThree= new Game(thunderCats,0, clevelandCavaliers, 0, LocalDateTime.of(2020,11,14,11,55));

        gameRegister.addGame(gameOne);
        gameRegister.addGame(gameTwo);
        gameRegister.addGame(gameThree);
        gameRegister.getGamesAtDateTime(new DateTime(2020, 11, 10,10));
//        gameRegister.printFutureGames();
//        gameRegister.getGamesOfThisWeek();
        gameRegister.printGameInformation(gameTwo);



    }


}
