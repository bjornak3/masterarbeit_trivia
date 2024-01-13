package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.trivia.PlayerManager;
import com.adaptionsoft.games.trivia.QuestionManager;

public class Game {

	private final QuestionManager questionManager;
	private final PlayerManager playerManager;
    
    int currentPlayerPosition = 0;
    boolean isGettingOutOfPenaltyBox;
    
    public  Game(){
		questionManager = new QuestionManager();
		playerManager = new PlayerManager();
    }

	public void roll(int roll) {
		String currentPlayer = playerManager.getPlayer(currentPlayerPosition);
		System.out.println(currentPlayer + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (playerManager.isInPenaltyBox(this.currentPlayerPosition)) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;
				
				System.out.println(currentPlayer + " is getting out of the penalty box");
				managePlaces(roll);
			} else {
				System.out.println(currentPlayerPosition + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}
			
		} else {
			managePlaces(roll);
		}
		
	}

	private void managePlaces(int roll) {
		playerManager.setPlace(currentPlayerPosition, roll);
		if(playerManager.getPlace(currentPlayerPosition) > 11) playerManager.setPlace(currentPlayerPosition, -12);

		System.out.println(currentPlayerPosition
				+ "'s new location is "
				+ playerManager.getPlace(currentPlayerPosition));
		System.out.println("The category is " + questionManager.currentCategory(playerManager.getPlace(currentPlayerPosition)));
		questionManager.askQuestion(playerManager.getPlace(currentPlayerPosition));
	}

	public boolean wasCorrectlyAnswered() {
		if (playerManager.isInPenaltyBox(currentPlayerPosition)){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				return managePurses();
			} else {
				currentPlayerPosition++;
				if (currentPlayerPosition == playerManager.howManyPlayers()) currentPlayerPosition = 0;
				return true;
			}
		} else {
			System.out.println("Answer was corrent!!!!");
			return managePurses();
		}
	}

	private boolean managePurses() {
		playerManager.setPurse(currentPlayerPosition, 1);
		System.out.println(playerManager.getPlayer(currentPlayerPosition)
				+ " now has "
				+ playerManager.getPurse(currentPlayerPosition)
				+ " Gold Coins.");

		boolean winner = didPlayerWin();
		currentPlayerPosition++;
		if (currentPlayerPosition == playerManager.howManyPlayers()) currentPlayerPosition = 0;

		return winner;
	}

	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(playerManager.getPlayer(currentPlayerPosition)+ " was sent to the penalty box");
		playerManager.setPenaltyBox(currentPlayerPosition, true);
		
		currentPlayerPosition++;
		if (currentPlayerPosition == playerManager.howManyPlayers()) currentPlayerPosition = 0;
		return true;
	}


	private boolean didPlayerWin() {
		return !(playerManager.getPurse(currentPlayerPosition) == 6);
	}
}
