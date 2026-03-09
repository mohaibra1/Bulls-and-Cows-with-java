package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Game {


    public void start() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");

        //user input
        int n = input.nextInt();
        System.out.println("Input the number of possible symbols in the code:");
        int strLength = input.nextInt();
        while(true){
            if(n > 37){
                System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
                n = input.nextInt();
                continue;
            }else if(strLength > 37) {
                System.out.println("String length should be less than 26 or equal. not Negative!");
                strLength = input.nextInt();
                continue;
            }else {
                break;
            }
        }
        System.out.println("Okay, let's start the game!");
        boolean stopGame = true;
        int turns = 1;
        // generate once the secretcode.
        String secretCode = generateSecretCode(n, strLength);
        while(stopGame) {

            System.out.println("Turn " +  turns++ + ":");
            String userInput = input.next();
            if(userInput.length() > n){
                System.out.println("Put " + n + " Numbers!");
                continue;
            }

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
        //checks how many bulls and cows are in there

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

    private String generateSecretCode(int n, int strLength) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        char[] chars = getRandom(n, strLength);
        while (sb.length() < n) {
            String num;
            if(strLength == 0){
                num = String.valueOf(random.nextInt(10));
            }else {
                num = String.valueOf(chars[random.nextInt(chars.length)]);
            }
            if (sb.toString().contains(num)) {
                continue;
            }
            sb.append(num);
        }
        return sb.toString();
    }

    private char[] getRandom(int n, int strLength){
        char[] letters = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p'
                ,'q','r','s','t','u','v','w','x','y','z'};
        StringBuilder sb = new StringBuilder();
        String star = "";
        for(int i = 0; i < n; i++){
            star += "*";
        }

        int numberOfSymbols = strLength + n;
        int index = 0;
        while(index < strLength){
            sb.append(letters[index]);
            index++;
        }
        StringBuilder numbers = new StringBuilder();
        StringBuilder chars = new StringBuilder();
        for(int i = 0; i < sb.length(); i++){
            if(Character.isDigit(sb.charAt(i))){
                numbers.append(sb.charAt(i));
            }else {
                chars.append(sb.charAt(i));
            }
        }if(strLength <= 10){
            System.out.println("The secret is prepared: " +
                    star + " ("  + numbers.charAt(0) + "-" +
                    numbers.charAt(numbers.length()-1) + ")");
        }else {

            System.out.println("The secret is prepared: " +
                    star + " (" + numbers.charAt(0) + "-" +
                    numbers.charAt(numbers.length() - 1) + ", " + chars.charAt(0) + "-" +
                    chars.charAt(chars.length() - 1) + ")");
        }
        System.out.println(sb);
        return sb.toString().toCharArray();
    }
}