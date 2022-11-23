package Ui;

import ClubMember.ClubMember;
import Controller.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    boolean userChoiceFalse = false;
    private String nameInput;
    Controller controller = new Controller();

    public void menu() {
        controller.loadData();
        int menuChoise = 0;
        while (menuChoise != 9) {
            System.out.println("""
                    -------------------------
                    Sign in as:
                    -------------------------
                    1. Club manager
                    2. Coach
                    3. Cashier
                    9. Exit program
                    """);

            do{
                String valg = scanner.nextLine().trim();
                try {
                    menuChoise = Integer.parseInt(valg);
                    userChoiceFalse = true;
                } catch (NumberFormatException e) {
                    System.out.print("There has been a error enter a valid number: ");
                    scanner.nextLine();
                }

            } while (!userChoiceFalse);

            switch (menuChoise) {
                case 1 -> clubManagerMenu();
                //case 2 -> coachMenu();
                //case 3 -> cashierMenu();
                case 9 -> exitProgram();
                default -> System.out.println("Invalid Input\n");
            }
        }

    }

    public void clubManagerMenu() {
        int menuChoise = 0;
        while (menuChoise != 9) {
            System.out.println("""
                    -------------------------
                    Club manager menu:
                    -------------------------
                    1. Create new member
                    2. delete current member
                    3. edit member info
                    9. go back to sign in
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


        }
        switch (menuChoise) {
            case 1 -> createMember();
            case 2 -> deleteMember();
            //case 3 ->
            case 9 -> menu();
            default -> System.out.println("Invalid Input\n");
        }
    }

        public void createMember() {
            System.out.println("--------------------------------------------------------");
            System.out.println("Input new member name: ");
            String nameinput = scanner.nextLine();
            while (nameinput.isEmpty() || nameinput.equals(" ")) {
                System.out.print("Invalid input try again:");
                nameinput = scanner.nextLine();
            }
            System.out.println("--------------------------------------------------------");
            System.out.print("Input new member age: ");

            int ageInput = 0;
            do {
                try {
                    String ageInputString = scanner.nextLine();
                    ageInput = Integer.parseInt(ageInputString);
                    userChoiceFalse = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input try again:");
                }
            }
            while (!userChoiceFalse);

            boolean activityStatus = false;
            String activity;
            do {
                System.out.println("--------------------------------------------------------");
                System.out.print("Input new member activity status (passive/active): ");

                activity = scanner.nextLine().trim().toLowerCase();
                if (activity.equals("active") || activity.equals("a")) {
                    activityStatus = true;
                } else if (activity.equals("passive") || activity.equals("p")) {
                    activityStatus = false;
                } else {
                    System.out.println("Invalid input");
                    System.out.println("please enter active or passive: ");
                }
            } while (activity.isEmpty());

            System.out.println("--------------------------------------------------------");
            System.out.print("Input new member activity status (junior/senior): ");
            String membership = scanner.nextLine().trim().toLowerCase();

            while (membership.isEmpty() || membership.equals(" ")) {
                System.out.print("Invalid input try again:");
                membership = scanner.nextLine();
            }

            System.out.println("--------------------------------------------------------");
            System.out.print("Input new member activity status (Exerciser/competition): ");
            String swim = scanner.nextLine().trim().toLowerCase();

            while (swim.isEmpty() || swim.equals(" ")) {
                System.out.print("Invalid input try again:");
                swim = scanner.nextLine();
            }

        controller.createClubMember(nameInput, ageInput, activityStatus, membership, swim, 0);

        controller.saveData();
    }
    public void deleteMember(){
        System.out.println("--------------------------------------------------------");
        System.out.println("Input the name of a member you want to delete: ");
        String userDeleteMember = scanner.nextLine().trim().toLowerCase();
        ArrayList<ClubMember> searchDeleteMember = new ArrayList<>();

        int index = 1;

        for (ClubMember deleteMember : controller.getClubMembers()){
            nameInput = deleteMember.getName().toLowerCase();
            if (nameInput.contains(userDeleteMember.toLowerCase())){
                searchDeleteMember.add(deleteMember);
                System.out.println(index++ + ": " + deleteMember.getName());
            }
        }
        System.out.println("Select the number of the member you want to delete: ");
        String userDeleteNumberString = scanner.nextLine();
        int userDeleteNumberInt = Integer.parseInt(userDeleteNumberString);

        ClubMember deleteMember = searchDeleteMember.get(userDeleteNumberInt - 1);
        controller.deleteMember(deleteMember);
        System.out.println("You have now deleted: " + deleteMember.getName() + " from you membership");

        controller.saveData();
    }
    public void exitProgram() {
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