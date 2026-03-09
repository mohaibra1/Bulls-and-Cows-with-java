package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//       Game game = new Game();
//       game.start();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        if(n > 10){
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            return;
        }
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

        System.out.println("The random secret number is " + sb2.toString() + ".");
    }

}
