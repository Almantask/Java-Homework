package Advent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day22 {

    public static void solve(List<String> input) {
        List<String> winnersDeck = getWinnersDeck(input);
        List<String> player1CardsDeck = getCardsDecks(input).get(0);
        List<String> player2CardsDeck = getCardsDecks(input).get(1);
        List<String> recursiveCombatWinnersDeck = getRecursiveWinnersDeck(player1CardsDeck, player2CardsDeck);
        System.out.println("The answer of Day22 part1 is: " + countWinnersScore(winnersDeck));
        System.out.println();
        System.out.println("The answer of Day22 part2 is: " + countWinnersScore(recursiveCombatWinnersDeck));
    }

    private static List<String> getRecursiveWinnersDeck(List<String> players1deck, List<String> players2deck) {
        List<List<String>> deck1History = new ArrayList<>();
        List<List<String>> deck2History = new ArrayList<>();
        List<String> deck1 = new ArrayList<>(players1deck);
        List<String> deck2 = new ArrayList<>(players2deck);
        while (playerHasCards(deck1) && playerHasCards(deck2)) {
            deck1History.add(deck1);
            deck2History.add(deck2);
            int card1 = Integer.parseInt(deck1.get(1));
            int card2 = Integer.parseInt(deck2.get(1));
            if (isNeedSubGame(card1, card2, deck1.size(), deck2.size())) {
                List<String> deck3 = getRecursiveWinnersDeck(getDeckToSubGame(card1, deck1), getDeckToSubGame(card2, deck2));
                deck1 = playRecursiveRound(deck3.get(0), card2, deck1);
                deck2 = playRecursiveRound(deck3.get(0), card1, deck2);
            } else {
                deck1 = playRound(deck1, card2);
                deck2 = playRound(deck2, card1);
            }
            if (isInfiniteGame(deck1, deck1History) || isInfiniteGame(deck2, deck2History))
                return deck1;
        }
        return returnNotEmptyDeck(deck1, deck2);
    }

    private static boolean isInfiniteGame(List<String> deck, List<List<String>> deckHistory) {
        for (List<String> list : deckHistory)
            if (list.equals(deck))
                return true;
        return false;
    }

    private static List<String> playRecursiveRound(String winner, int opponentCard, List<String> deck) {
        List<String> newDeck = new ArrayList<>(deck);
        if (newDeck.get(0).equals(winner)) {
            newDeck.add(deck.get(1));
            newDeck.add(String.valueOf(opponentCard));
        }
        newDeck.remove(1);
        return newDeck;
    }

    private static List<String> getDeckToSubGame(int card, List<String> deck) {
        List<String> deckToSubGame = new ArrayList<>();
        deckToSubGame.add(deck.get(0));
        for (int i = 2; i < card + 2; i++)
            deckToSubGame.add(deck.get(i));
        return deckToSubGame;
    }

    private static boolean isNeedSubGame(int card1, int card2, int deck1Size, int deck2Size) {
        return card1 <= deck1Size - 2 && card2 <= deck2Size - 2;
    }

    private static int countWinnersScore(List<String> winnersDeck) {
        Collections.reverse(winnersDeck);
        int score = 0;
        for (int i = 0; i < winnersDeck.size() - 1; i++)
            score += Integer.parseInt(winnersDeck.get(i)) * (i + 1);
        return score;
    }

    private static List<String> getWinnersDeck(List<String> input) {
        List<String> player1Deck = new ArrayList<>(getCardsDecks(input).get(0));
        List<String> player2Deck = new ArrayList<>(getCardsDecks(input).get(1));
        while (playerHasCards(player1Deck) && playerHasCards(player2Deck)) {
            int card1 = Integer.parseInt(player1Deck.get(1));
            int card2 = Integer.parseInt(player2Deck.get(1));
            player1Deck = playRound(player1Deck, card2);
            player2Deck = playRound(player2Deck, card1);
        }
        return returnNotEmptyDeck(player1Deck, player2Deck);
    }

    private static List<String> returnNotEmptyDeck(List<String> deck1, List<String> deck2) {
        if (deck1.size() == 1)
            return deck2;
        return deck1;
    }

    private static List<String> playRound(List<String> deck, int opponentsCard) {
        List<String> newDeck = new ArrayList<>(deck);
        if (Integer.parseInt(deck.get(1)) > opponentsCard) {
            newDeck.add(deck.get(1));
            newDeck.add(String.valueOf(opponentsCard));
        }
        newDeck.remove(1);
        return newDeck;
    }

    private static boolean playerHasCards(List<String> deck) {
        return deck.size() > 1;
    }

    private static List<List<String>> getCardsDecks(List<String> input) {
        List<List<String>> cardsDecks = new ArrayList<>();
        List<String> cardsDeck = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            String s = input.get(i);
            if (!s.isEmpty())
                cardsDeck.add(s);
            if (s.isEmpty() || i == input.size() - 1) {
                cardsDecks.add(cardsDeck);
                cardsDeck = new ArrayList<>();
            }
        }
        return cardsDecks;
    }
}
