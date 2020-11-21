package edu;

import edu.abstraction.*;
import edu.encapsulation.ProgressBar;
import edu.inheritanceAndPolymorphism.BasketballPlayer;
import edu.inheritanceAndPolymorphism.FootBallPlayer;
import edu.inheritanceAndPolymorphism.Human;
import edu.inheritanceAndPolymorphism.Player;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        //demoProgressBar();
        //demoFlyers();
        demoPlayer();
    }

// Without an interface I would have to do this:
//    public void PrintId(Plane plane){
//        System.out.println(plane.getId());
//    }
//
//    public void PrintId(Dog dog){
//        System.out.println(dog.getId());
//    }
//
//    public void PrintId(Bird bird){
//        System.out.println(bird.getId());
//    }

    // With interface, I can do this:
    private void PrintId(Identifiable identifiable){
        System.out.println(identifiable.getId());
    }

    private static void demoWorker(){
        Worker worker1 = new LazWorker("asd");
        Worker worker2 = new GoodWorker("asd");
    }

    private static void demoFlyers(){
        Plane plane1 = new Plane(3);
        Bird bird1 = new Bird(2);
        Dog dog1 = new Dog("ricky", 1);

        Plane plane2 = new Plane(3);
        Bird bird2 = new Bird(2);
        Dog dog2 = new Dog("ricky", 1);

        // Also cat, cow, house, human...



//        Identifiable[] identifiables = {plane, bird, dog};
//        for (Identifiable identifiable : identifiables) {
//            System.out.println(identifiable.getId());
//        }
//        Flyer[] flyers = {plane, bird};
//        for (Flyer flyer : flyers) {
//            flyer.fly();
//        }
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
        //BasketballPlayer toBasketballPlayer = (BasketballPlayer)footBallPlayer2;

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

        System.out.println("----------=--------");
        Human humaOfHuman = human;
        humaOfHuman.whoAmI();
        System.out.println(humaOfHuman);
        Human humanOfPlayer = player;
        humanOfPlayer.whoAmI();
        System.out.println(humanOfPlayer);
        Player playerOfPlayer = player;
        playerOfPlayer.whoAmI();
        System.out.println(playerOfPlayer);
    }

    private static void demoProgressBar() throws IOException {
        ProgressBar bar = new ProgressBar(0, 100);
        for (int i = 0; i < 100; i++) {
            bar.addProgress(1);
            System.out.println(bar);
        }
    }
}
