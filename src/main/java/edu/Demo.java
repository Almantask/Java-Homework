package edu;

import edu.abstraction.*;
import edu.encapsulation.ProgressBar;
import edu.inheritanceAndPolymorphism.BasketballPlayer;
import edu.inheritanceAndPolymorphism.FootBallPlayer;
import edu.inheritanceAndPolymorphism.Human;
import edu.inheritanceAndPolymorphism.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {
    public static void main(String[] args) throws IOException {
        demoUser();
        //demoDictionary();
        //demoProcess();
    }


    private static void demoUser(){
        Person person4 = new Person("Arnoldas", 220, 120, 125846L);
//        String User = getUser(2145);
//        System.out.println(User);
        PersonRegister register1 = BuildPersonRegister();
        register1.add(person4);
        Person person5 = register1.get(333845L);
        System.out.println(person5);

    }

    private static PersonRegister BuildPersonRegister() {
        Person person1 = new Person("Marius", 175,46,123456L);
        Person person2 = new Person("Jonas", 181, 68, 123845L);
        Person person3 = new Person("Jonas2", 185, 78, 333845L);
        Person[]persons = {person1,person2,person3};
        PersonRegister register1 = new PersonRegister(persons);
        return register1;
    }

    private static String getUser(int ID){

        Map<Integer,String>people = new HashMap<>();
        people.put(2145, "Antanas");
        people.put(1145, "Marius");

        String User = people.get(ID);

        return User;
    }

    private static void demoProcess(){
        SomeProcess process1 = new Process1();
        SomeProcess process2 = new Process2();

        process1.execute();
        process2.execute();
    }

    private static void demoDictionary(){
        String translation = translateGood("iki");
        System.out.println(translation);
    }

    private static String translateGood(String word) {
        Map<String, String> dictionaryLtToEn = new HashMap<>();
        dictionaryLtToEn.put("labas", "hello");
        dictionaryLtToEn.put("iki", "bye");
        dictionaryLtToEn.put("iki", "bye2");

        // If we used array instead
        // We would need two array
        // we would also need a foreach loop
        // because a search needs to be made

        // With maps, we can immediately retrieve the value by key.
        String translation = dictionaryLtToEn.get(word);

        return translation;
    }

    private static void demoList() {
        String[] words = new String[0];
        // Add 1 add the end of array
        words = new String[words.length+1];
        words[words.length-1] = "hello";
        // Adding a second time I would need to copy the original array
        // Expand the old array
        // And add value in the end.

        List<String> words2 = new ArrayList<>();
        words2.add("hello");
        words2.add("labas111");
        words2.add("hello");
        words2.add("labas111");
        words2.add("hello");
        words2.add("labas111");
        words2.add("hello");
        words2.clear();
        for (String word : words2){
            System.out.println(word);
        }

        // Instead of an int I have to write an object
        // Primitives don't work
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(54);
        for (int number : numbers){
            System.out.println(number);
        }
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
