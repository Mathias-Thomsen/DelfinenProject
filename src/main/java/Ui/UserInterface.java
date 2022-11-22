package Ui;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private boolean userChoiceFalse = false;

    public void menu(){
        int menuChoise = 0;
        while (menuChoise != 9) {
            System.out.println("""
            -------------------------
            Sign in as:
            -------------------------
            1. Club manager
            2. Coach
            3. Cashier
            4. Exit program
            """);

            do {
                String valg = scanner.nextLine().trim();
                try {
                    menuChoise = Integer.parseInt(valg);
                    userChoiceFalse = true;
                } catch (NumberFormatException e) {
                    System.out.print("There has been a error enter a valid number: ");
                    scanner.nextLine();
                }

            } while (!userChoiceFalse);

            InitiateProgram(menuChoise);
        }

    }
    public void InitiateProgram(int menuChoice) {
        switch (menuChoice) {
            //case 1 ->
            //case 2 ->
            //case 3 ->
            case 4 -> exitProgram();
            default -> System.out.println("Invalid Input\n");
        }
    }


    public void exitProgram()  {
        try {
            System.out.print("Exiting Program");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            System.exit(1);

        } catch (InterruptedException e) {
            System.out.println("System can not exit");
        }


    }
}
