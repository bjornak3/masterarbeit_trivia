
package com.adaptionsoft.games.trivia.runner;
import java.lang.management.ManagementFactory;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	public static void main(String[] args) {
		String processName = ManagementFactory.getRuntimeMXBean().getName();
		long processId = Long.parseLong(processName.split("@")[0]);

		// Print the process ID
		System.out.println("Process ID: " + processId);
		Game aGame = new Game();
		
		Random rand = new Random();

		boolean notAWinner;
		do {
			
			aGame.roll(rand.nextInt(5) + 1);
			
			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}
			
			
			
		} while (notAWinner);
		
	}
}
