package com.pluralsight;

import com.pluralsight.util.UserInput;

import java.util.ArrayList;

public class BlackjackApp {

    public static void main(String[] args) {

        boolean addPlayer = true;
        ArrayList<String> players = new ArrayList<>();

        while (addPlayer && players.size() <= 7) {
            players.add(UserInput.promptForString("Enter Player " + (players.size() + 1) + "'s name "));

            if (!(players.size() == 7)) {
                if (UserInput.promptForChar("Add another player? [Y/N] ", "YN") == 'N') {
                    addPlayer = false;
                }
            }

            System.out.println(players.toString());
        }
    }
}

