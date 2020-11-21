package edu;

public class Demo {
    public static void main(String[] args) {
        //demoProgressBar();
        demoPlayer();
    }

    private static void demoPlayer(){
        Human human = new Human("Marius", 200, 100);
        Player player = new Player("Tomas", 187, 80, "Zalgiris");
        BasketballPlayer basketballPlayer = new BasketballPlayer("Giedrius", 210, 105, "Zalgiris");

        // Polymorphism (Basketball player as a human)
        // Poly- many
        // morph- shapes
        // So polymorphism means that we can interact with classes using their generalized forms
        // For example instead of player, we can use human, instead of basketball player, we can user player.
        Player footBallPlayer1 = new FootBallPlayer(basketballPlayer, "Gargzdu");
        Human footBallPlayer2 = new FootBallPlayer(human, "Gargzdu");
        // From human back to footBallPlayer2- ok
        FootBallPlayer backToOriginalfootBallPlayer2 = (FootBallPlayer)footBallPlayer2;
        // Error
        BasketballPlayer toBasketballPlayer = (BasketballPlayer)footBallPlayer2;
        // Use different types as the same type
        // Using what generalized type had.
        Human[] humans = {human, player, basketballPlayer, footBallPlayer1, footBallPlayer2};
        for (Human human1 :
                humans) {
            System.out.println("Name: "+ human1.getName());
        }

        System.out.println(human.getName());
        System.out.println(player.getName());
        System.out.println(basketballPlayer.getName());
        basketballPlayer.setGamesWon(4);
        System.out.println(basketballPlayer.getGamesWon());
    }

    private static void demoProgressBar() {
        ProgressBar bar = new ProgressBar(0, 100);
        for (int i = 0; i < 100; i++) {
            bar.addProgress(1);
            clearScreen();
            System.out.println(bar);
        }
    }

    // TODO: figure out how to clear a console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
