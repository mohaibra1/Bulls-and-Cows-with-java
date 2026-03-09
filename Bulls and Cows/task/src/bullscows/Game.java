package bullscows;

import java.util.Scanner;

public class Game {
    private final String SECRET_CODE = "9035";

    public String getSecretCode() {
        return SECRET_CODE;
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        //user input
        String userInput = input.nextLine();
        int[] arr = checkBullsAndCows(userInput);
        int bulls = arr[0];
        int cows = arr[1];

        if(bulls == 4) {
            System.out.print("Grade: 4 bulls. Congrats!");;
        }else if(bulls > 0 && cows > 0){
            System.out.print("Grade: " + bulls + " bull(s)" + cows + "cow(s).");
        }else if(bulls > 0 && cows == 0){
            System.out.print("Grade: " + bulls + " bull(s).");
        }else if(bulls == 0 && cows > 0){
            System.out.print("Grade: " + cows + " cow(s).");
        }else {
            System.out.print("Grade: None.");
        }
        System.out.println(" The secret code is: " + SECRET_CODE);
    }

    public int[] checkBullsAndCows(String userInput) {
        int[] answer = new int[2];
        //for loop
        for(int i = 0; i < userInput.length(); i++){
            if(userInput.charAt(i) == SECRET_CODE.charAt(i)){
                answer[0] += 1;
            }else if(userInput.contains(SECRET_CODE.charAt(i) + "")){
                answer[1] += 1;
            }
        }
        return answer;
    }
}
