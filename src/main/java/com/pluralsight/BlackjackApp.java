package com.pluralsight;

import com.pluralsight.util.UserInput;

public class BlackjackApp {

    public static void main(String[] args) {

        boolean addPlayer = true;
        int totalPlayers = 1;

        while (addPlayer && totalPlayers <= 7) {
            UserInput.promptForString("Enter player " + totalPlayers + "'s name ");

            if (totalPlayers == 7) {
                return;
            } else
                switch (UserInput.promptForChar("Add another player?", "YN")) {
                    case 'Y':
                        totalPlayers += 1;
                        break;
                    case 'N':
                        addPlayer = false;
                        break;
            }
        }
    }
}

