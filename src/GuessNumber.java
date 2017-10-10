import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class GuessNumber {

	// "Field" Very Important is "Scope"
	// "Public" means any other class has access; usually BAD!
	// "Private" means only used inside of this class; usually this is very good!
	// "Protected" means can be used by any other class in this package
	private int lowerLimit = 0;
	private int upperLimit = 10;

	Random rand = new Random();
	Scanner keyboard = new Scanner(System.in);

	/*
	 * 1. set lower and upper bounds on the numbers, like 0 - 10 2. pick a random
	 * number in that range 3. start looping -- guess -- check for win -- if win
	 * congrats! -- if no win repeat -- set a guess limit, like after 5 tries game
	 * over
	 */
	public GuessNumber() {

		// placeholder, but essential - a constuctor reserves computer memory

	}// end of constuctor

	public void startGame() {

		// method scope
		Boolean gameRunning = true;
		int guess;
		int countLimit = 5;
		String startMsg = "";
		String enterGuess = "";
		String gameMsg = "";
		String victoryMsg = "";
		// get a new random number
		// example of "meth"od scope" -- can only exist in this method
		int answer = rand.nextInt(upperLimit) + lowerLimit;

		// upperLimit - 1 because it is exclusive, stops 1 number before
		startMsg = "for testing answer = " + answer;
		JOptionPane.showMessageDialog(null, startMsg);

		// later: test for bounds

		// ok, check for win
		// PAY ATTENTION! == is a test operator, ALWAYS used in if's

		while (gameRunning && countLimit > 0) {
			enterGuess ="Please enter your guess, between " + lowerLimit + " and " + (upperLimit - 1);
			JOptionPane.showMessageDialog(null, enterGuess);
			guess = Integer.parseInt(JOptionPane.showInputDialog(enterGuess));

			// test -- remove once everything is working corectly

			if (guess == answer) {
				gameMsg = "Congrats! You won!";
				JOptionPane.showMessageDialog(null, gameMsg);
				gameRunning = false;
			} else if (guess > answer) {
				gameMsg = "Your guess was too high!";
				JOptionPane.showMessageDialog(null, gameMsg);

			} else if (guess < answer) {
				gameMsg = "Sorry, your guess was too low!";
				JOptionPane.showMessageDialog(null, gameMsg);

			} else {
				gameMsg = "Whaaaaaat??? I dont understand!";
				JOptionPane.showMessageDialog(null, gameMsg);

			}

			countLimit--; // count down by one -- "decrement"

		} // end while

		if (countLimit > 2) {
			victoryMsg = "Whoa You are AWESOME";
			JOptionPane.showMessageDialog(null, victoryMsg);
		} else if (countLimit == 2 || countLimit == 1) {
			victoryMsg = "Yes! You are really good";
			JOptionPane.showMessageDialog(null, victoryMsg);
		} else if (countLimit == 0 || gameRunning == false) {
			victoryMsg = "You barely made it!";
			JOptionPane.showMessageDialog(null, victoryMsg);
		} else {
			victoryMsg = "You lost!";
			JOptionPane.showMessageDialog(null, victoryMsg);
		}

		System.out.println("\nAll Done, CU later!");

	}// end of start game

}// end of class