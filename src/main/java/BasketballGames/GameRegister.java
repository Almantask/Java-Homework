package BasketballGames;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GameRegister {

    private final Set<Game> games = new HashSet<>();

    public void addGame(Game game) {
        games.add(game);
    }

    public Game[] getGames() {
        return games.toArray(new Game[0]);
    }

    public Game[] getPastGames() {
        LocalDateTime currentTime = LocalDateTime.now();
        return games.stream()
                .filter(game -> currentTime.isAfter(game.getGameDateTime()))
                .collect(Collectors.toSet())
                .toArray(new Game[0]);
    }

    public Game[] getFutureGames() {
        LocalDateTime currentTime = LocalDateTime.now();
        return games.stream()
                .filter(game -> currentTime.isBefore(game.getGameDateTime()))
                .collect(Collectors.toSet())
                .toArray(new Game[0]);
    }

    public Game[] getTodayGames() {
        LocalDate currentDate = LocalDate.now();
        return games.stream()
                .filter(game -> currentDate.equals(game.getGameDateTime().toLocalDate()))
                .collect(Collectors.toSet())
                .toArray(new Game[0]);
    }

    public Game[] getGamesOfThisWeek() {
        LocalDate currentDate = LocalDate.now();
        LocalDate dayBeforeWeekStart = currentDate.minusDays(currentDate.getDayOfWeek().getValue() + 1);
        LocalDate dayAfterWeekEnd = dayBeforeWeekStart.plusDays(7 + 2);
        return games.stream()
                .filter(game -> game.getGameDateTime().toLocalDate().isAfter(dayBeforeWeekStart) &&
                        game.getGameDateTime().toLocalDate().isBefore(dayAfterWeekEnd))
                .collect(Collectors.toSet())
                .toArray(new Game[0]);
    }

    public Game[] getGamesAtDateTime(DateTime dateTime) {

        return games.stream()
                .filter(game -> dateTime.getYear() != null && game.getGameDateTime().getYear() == dateTime.getYear())
                .filter(game -> dateTime.getMonth() != null && game.getGameDateTime().getMonth().getValue() == dateTime.getMonth())
                .filter(game -> dateTime.getDay() != null && game.getGameDateTime().getDayOfMonth() == dateTime.getDay())
                .filter(game -> dateTime.getTime() != null && game.getGameDateTime().toLocalTime().equals(dateTime.getTime()))
                .collect(Collectors.toSet())
                .toArray(new Game[0]);
    }
}