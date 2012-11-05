package sdrguessinggame;

import java.util.Random;

/**
 *
 * @author Scott Roethle
 */
public class GuessingGame {
    
    private int computerNumber;
    private int guessNumber;
    private boolean correctGuess;
    private boolean guessTooHigh;
   

    GuessingGame(){
        computerNumber = generateRandomNumber();
    }
   
    
    public void startNewGuessingGame() {
        computerNumber = generateRandomNumber();
        guessTooHigh = false;
        correctGuess = false;
    }
    
    private void resetGuessCheckers() {
        correctGuess = false;
        guessTooHigh = false;

    }
    
    public void makeGuess(String number){
        resetGuessCheckers();
        setGuess(number);
        compareGuess();
    }
    
    public String getGuessResult() {
        String outputText;
        if (guessTooHigh == true) {
            outputText = "Your Guess is Too High!";
        } else if (correctGuess == true) {
            outputText = "Correct! You Win! Please Play Again!";
            startNewGuessingGame();

        } else {
            outputText = "Your Guess is Too Low!";
        }
        return outputText;
    }
   

    
    private void setGuess(String number){
        //validate String Number
        guessNumber = Integer.parseInt(number);
    }
    private void compareGuess() {
        if (guessNumber == computerNumber) {
            correctGuess = true;
        } else if (guessNumber > computerNumber) {
            guessTooHigh = true;
        } 
    }
    
    
    private int generateRandomNumber(){
        Random r = new Random(System.nanoTime());
        int randomInt = r.nextInt(10);
        return randomInt+1;
    }
    
}
