package com.pluralsight;

import com.pluralsight.util.UserInput;

import java.util.ArrayList;

public class BlackjackApp {

    public static void main(String[] args) {

        boolean addPlayer = true;
        ArrayList<Player> players = new ArrayList<>();

        while (addPlayer && players.size() <= 7) {
            String name = UserInput.promptForString("Enter Player " + (players.size() + 1) + "'s name ");
            Player player = new Player(name);

            players.add(player);

            if (players.size() != 7) {
                if (UserInput.promptForChar("Add another player? [Y/N] ", "YN") == 'N') {
                    addPlayer = false;
                }
            }

            System.out.println(players.toString());
        }

        Deck deck = new Deck();
        Hand hand = new Hand();

        deck.shuffle();
    }
}

