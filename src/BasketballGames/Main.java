package BasketballGames;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Human h1 = new Human("Pirmas", "Pirmaitis", LocalDate.of(1990, 01, 01), "Lithuanian");
        Human h2 = new Human("Antras", "Anraitis", LocalDate.of(1996, 01, 01), "Lithuanian");
        Human h3 = new Human("Treačias", "Trečiaitis", LocalDate.of(1998, 01, 01), "Lithuanian");
        Human h4 = new Human("Ketvirtas", "Ketvirtaitis", LocalDate.of(2000, 01, 01), "Lithuanian");
        Human h5 = new Human("Penktas", "Penktaitis", LocalDate.of(1989, 01, 01), "Lithuanian");
        Human h6 = new Human("Šeštas", "Šeštaitis", LocalDate.of(1988, 01, 01), "Lithuanian");
        Human h7 = new Human("Septintas", "Septintaitis", LocalDate.of(1980, 01, 01), "Lithuanian");

        Human h8 = new Human("Jonas", "Jonaitis", LocalDate.of(1990, 01, 01), "Lithuanian");
        Human h9 = new Human("Petras", "Petraitis", LocalDate.of(1996, 01, 01), "Lithuanian");
        Human h10 = new Human("Donatas", "Donataitis", LocalDate.of(1998, 01, 01), "Lithuanian");
        Human h11 = new Human("Tomas", "Tomaitis", LocalDate.of(2000, 01, 01), "Lithuanian");
        Human h12 = new Human("Giedrius", "Giedraitis", LocalDate.of(1989, 01, 01), "Lithuanian");
        Human h13 = new Human("Saulius", "Saulaitis", LocalDate.of(1988, 01, 01), "Lithuanian");
        Human h14 = new Human("Karolis", "Karolaitis", LocalDate.of(1980, 01, 01), "Lithuanian");

        Player p1 = new Player(h1, 1, "Point guard");
        Player p2 = new Player(h2, 2, "Shooting guard");
        Player p3 = new Player(h3, 3, "Small forward");
        Player p4 = new Player(h4, 4, "Power forward");
        Player p5 = new Player(h5, 5, "Center");
        Player p6 = new Player(h6, 6, "Center");

        Player p7 = new Player(h7, 1, "Point guard");
        Player p8 = new Player(h8, 2, "Shooting guard");
        Player p9 = new Player(h9, 3, "Small forward");
        Player p10 = new Player(h10, 4, "Power forward");
        Player p11 = new Player(h11, 5, "Center");
        Player p12 = new Player(h12, 6, "Center");

        Player[] teamPlayers1 = {p1, p2, p3, p4, p5};
        Player[] teamPlayers2 = {p1, p2, p3, p4};
        Player[] teamPlayers3 = {p7, p8, p9, p10, p11};

        Coach c1 = new Coach(h13);
        Coach c2 = new Coach(h14);

        Team t1 = new Team("Pirmoji", teamPlayers1, c1);
        Team t2 = new Team("Antroji", teamPlayers3, c2);
        Team[] teamsForGame1 = {t1, t2};
        int[] game1Score = {90, 100};

        Game g1 = new Game(teamsForGame1, game1Score, LocalDateTime.of(2020, 11, 16, 22, 00, 00));
        GamesRegister gr1 = new GamesRegister();
        gr1.addGame(g1);

        LocalDate date = LocalDate.of(2020, 11, 17);
        LocalTime time = LocalTime.of(23, 0);
        LocalDateTime Datetime = LocalDateTime.of(date, time);

        for (Game i : gr1.getGamesAtMonth(Datetime)) {
            System.out.println(i.toString());
        }
    }
}
