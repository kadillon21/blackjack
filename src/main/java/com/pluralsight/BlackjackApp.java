package com.pluralsight;

import com.pluralsight.util.UserInput;

import java.util.ArrayList;

public class BlackjackApp {

    public static void main(String[] args) {

        boolean addPlayer = true;
        String winner = "";
        int highestScore = 0;
        ArrayList<Player> players = new ArrayList<>(); // Players will be stored in this list

        // Loop ask player for name and if they want to add a new player
        while (addPlayer && players.size() <= 7) {
            String name = UserInput.promptForString("Enter Player " + (players.size() + 1) + "'s name ");
            Player player = new Player(name);

            players.add(player);

            if (players.size() != 7) {
                if (UserInput.promptForChar("Add another player? [Y/N] ", "YN") == 'N') {
                    addPlayer = false;
                }
            }
        }

        // Creates a new deck
        Deck deck = new Deck();
        deck.shuffle();

        // Adds two cards to each players hand
        for(Player player : players){
            Hand hand = player.getHand();
            hand.deal(deck.deal());
            hand.deal(deck.deal());

            System.out.println(player.getName() + " got a score of " + hand.getValue());

            if (hand.getValue() > highestScore){
                winner = player.getName();
                highestScore = hand.getValue();
            } else if (hand.getValue() == highestScore){
                System.out.println("Multiple winners, try again");
            }
        }

        System.out.println("The winner is: " + winner);
    }
}

