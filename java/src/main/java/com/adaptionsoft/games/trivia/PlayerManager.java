package com.adaptionsoft.games.trivia;

import java.util.ArrayList;

public class PlayerManager {
    private final ArrayList<String> players = new ArrayList<String>();
    private final int[] places = new int[6];
    private final int[] purses  = new int[6];
    private final boolean[] inPenaltyBox  = new boolean[6];

    public PlayerManager(){
        players.add("Chet");
        players.add("Pat");
        players.add("Sue");
    }

    public boolean add(String playerName) {
        players.add(playerName);
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    public String getPlayer(int currentPlayerPosition){
        return this.players.get(currentPlayerPosition);
    }

    public boolean isInPenaltyBox(int currentPlayerPosition){
        return inPenaltyBox[currentPlayerPosition];
    }

    public void setPenaltyBox(int currentPlayerPosition, boolean value){
        inPenaltyBox[currentPlayerPosition] = value;
    }

    public void setPlace(int currentPlayerPosition, int value){
        places[currentPlayerPosition] = places[currentPlayerPosition] + value;
    }

    public int getPlace(int currentPlayerPosition) {
        return places[currentPlayerPosition];
    }

    public void setPurse(int currentPlayerPosition, int value){
        purses[currentPlayerPosition] = purses[currentPlayerPosition] + value;
    }

    public int getPurse(int currentPlayerPosition) {
        return purses[currentPlayerPosition];
    }
}
