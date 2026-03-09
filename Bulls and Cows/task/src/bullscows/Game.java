package bullscows;

import java.util.Scanner;

public class Game {


    public void start() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        //user input

        int n = input.nextInt();
        while(true){
            if(n > 10){
                System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
                n = input.nextInt();
                continue;
            }else {
                break;
            }
        }
        System.out.println("Okay, let's start the game!");
        boolean stopGame = true;
        int turns = 1;
        // generate once the secretcode.
        String secretCode = generateSecretCode(n);
        while(stopGame) {

            System.out.println("Turn " +  turns++ + ":");
            String userInput = input.next();

            int[] arr = checkBullsAndCows(userInput, secretCode);
            int bulls = arr[0];
            int cows = arr[1];
            if (bulls == n) {
                System.out.println("Grade: " + bulls + " bulls.");
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }else if (bulls > 0 && cows > 0) {
                System.out.println("Grade: " + bulls + " bull(s) " + cows + " cow(s).");
            } else if (bulls > 0 && cows == 0) {
                System.out.println("Grade: " + bulls + " bull(s).");
            } else if (bulls == 0 && cows > 0) {
                System.out.println("Grade: " + cows + " cow(s).");
            } else {
                System.out.println("Grade: None.");
            }

        }
    }

    //private void playGame(){}

    private int[] checkBullsAndCows(String userInput, String secretCode) {
        int[] answer = new int[2];
        //for loop
        for(int i = 0; i < userInput.length(); i++){
            if(userInput.charAt(i) == secretCode.charAt(i)){
                answer[0] += 1;
            }else if(userInput.contains(secretCode.charAt(i) + "")){
                answer[1] += 1;
            }
        }
        return answer;
    }

    private String generateSecretCode(int n){
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while(sb2.length() < n){
            long random = System.nanoTime();
            sb.append(random);
            sb.reverse();
            char[] arr = sb.toString().toCharArray();

            for(int i = 0; i < arr.length; i++){
                if(sb2.length() != n){
                    if(sb2.isEmpty() && arr[i] == '0'){
                        continue;
                    }
                    if(!sb2.toString().contains(String.valueOf(arr[i]))){
                        sb2.append(arr[i]);
                    }
                }
            }
            sb.setLength(0);
        }

        //System.out.println("The random secret number is " + sb2.toString() + ".");
        return sb2.toString();
    }
}
