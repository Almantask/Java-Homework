# Java-Homework

## Basketball Games

### Intro

A school close by in your town/city asked you for help. 
They heard you've been studying programming recently and wanted a process automated.
Specifically, a process of getting information on basketball games history.
They asked you to program a console application, which would support searching for a game by date,
find past and future games, find games for tomorrow, yesterday and today.
Also print information about the teams (coach and roaster) in each game and score if any.

### 0- Human (EASY)

Every memeber of a team has a name, birthday, age, nationality.

### 1- Player is a human (EASY)

Player is a human, but it also has number (player number), position, game stats: 

- fouls
- 3-point score
- 2-point scores
- 3-point shots
- 2-point shots
- 2-point accuracy
- 3-point accuracy
- rebounds

### 2- Coach (EASY)

Coah is a human, it has nothing extra.

### 3- Team (EASY)

Team has members (at least 5) and a coach. It also has a name.

### 4- Game (EASY)

Game has 2 teams, a score and a datetime. 
It also has a function `Team getWinner()` to return the winner team.

### 5- New games (EASY)

`GamesRegister` Has all the known games stored. You can 
add games to it `void addGame(Game game)` and
return all games added `Game[] getGames()`

### 6- Past and Future games (EASY)

In `GamesRegister`, add two functions:
`Game[] getPastGames()` - returns past games
`Game[] getFutureGames()` - returns future games

### 7- Games Today (EASY)

In `GamesRegister` add a function 
`Game[] getTodayGames()` to get games of today

### 8- Games this week (MEDIUM)

In `GamesRegister` add a function
`Game[] getGamesOfThisWeek()` to get games of this week.

### 9- Games at datetime (MEDIUM)

In `GamesRegister` add a function
`Game[] getGamesAtDateTime(DateTime dateTime)` to get games at that dateTime.
If DateTime only includes year and month, you should return all games that month,
If DateTime includes day, return games at that day,
If DateTime includes daytime, returns games at the exact time.

### 10- Text (HARD)

Print all info about a game:
- Each team
- Each member and coach (only names and numbers)
- Score
- Datetime

Should be printed in the following format
```
| Team1Name |                |   | 50:52 |   | Team2Name |                        |
|-----------|----------------|---|-------|---|-----------|------------------------|
| Coach     | Tomas Bumblys  |               | Coach     | Eimantas Staniulis     |
| Player 1  | Tadas Kirkilas |               | Player1   | Giedrius Kasparavičius |
| ...       |                |               | ...       |                        |
```