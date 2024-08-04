package CongoRise;

import java.util.Random;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int RandomNumber = rand.nextInt(100) + 1;
        System.out.println("Random number is : " + RandomNumber);

        while (true) {
            System.out.println("Enter the number b/w 1 - 100 : ");
            int GussedNum = sc.nextInt();

            if (RandomNumber == GussedNum) {
                System.out.println("Currect! you Win!");
                break;
            } else if (RandomNumber < GussedNum) {
                System.out.println("Nope! the number is higher! Guess again : ");
            } else if (RandomNumber > GussedNum) {
                System.out.println("Nope! the number is lower!Guess again : ");
            } else {
                System.out.println("Inviled Entered!");
            }
        }
    }
}
