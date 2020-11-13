package Basketball;

/*## 5- New games (EASY)

        `GamesRegister` Has all the known games stored. You can
        add games to it `void addGame(Game game)` and
        return all games added `Game[] getGames()`*/


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GamesRegister {

    private final Set<Game> games = new HashSet<>();

    public void addGame(Game game) {
        games.add(game);
    }

    public Game[] getGames() {
        return games.toArray(new Game[0]);

       /* ### 6- Past and Future games (EASY)

        In `GamesRegister`, add two functions:
`Game[] getPastGames()` - returns past games
`Game[] getFutureGames()` - returns future games*/
    }
    public Game[] getPastGames() {
        LocalDateTime currentTime = LocalDateTime.now();
        return games.stream()
                .filter(game -> currentTime.isAfter(game.getTeamDateTime()))
                .collect(Collectors.toSet())
                .toArray(new Game[0]);
    }
    public Game[] getFutureGames() {
        LocalDateTime currentTime = LocalDateTime.now();
        return games.stream()
                .filter(game -> currentTime.isBefore(game.getTeamDateTime()))
                .collect(Collectors.toSet())
                .toArray(new Game[0]);
/*### 7- Games Today (EASY)

        In `GamesRegister` add a function
`Game[] getTodayGames()` to get games of today*/

    }
    public Game[] getTodayGames() {
        LocalDate currentDate = LocalDate.now();
        return games.stream()
                .filter(game -> currentDate.equals(game.getTeamDateTime()))
                .collect(Collectors.toSet())
                .toArray(new Game[0]);


    }

}