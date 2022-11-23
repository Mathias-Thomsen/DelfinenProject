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
            System.out.println("""
                    -------------------------
                    Club manager menu:
                    -------------------------
                    1. Create new member
                    2. Show list of members
                    3. edit member information
                    4. Delete current member
                    9. go back to sign in
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
            case 1 -> createMember();
            case 2 -> showMenmbers();
            case 3 -> editMember();
            case 4 -> deleteMember();
            case 9 -> menu();
            default -> System.out.println("Invalid Input\n");
        }
    }

    public void createMember() {

        //Name
        System.out.println("--------------------------------------------------------");
        System.out.println("Input new member name: ");
        String nameInput = scanner.nextLine();
        while (nameInput.isEmpty() || nameInput.equals(" ")) {
            System.out.print("Invalid input try again:");
            nameInput = scanner.nextLine();
        }

        //Age
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
        } while (!userChoiceFalse);


        //Activity status
        System.out.println("--------------------------------------------------------");
        System.out.println("Input new member activity status (active/passive): ");
        String activity = scanner.nextLine();
        while (activity.isEmpty() || activity.equals(" ")) {
            System.out.print("Invalid input try again:");
            activity = scanner.nextLine();
        }


        //Junior or senior
        System.out.println("--------------------------------------------------------");
        String juniorOrSenior = "";

        if (ageInput < 18) {
            juniorOrSenior = "junior";
        } else {
            juniorOrSenior = "senior";
        }
        System.out.println("The age of the member is " + ageInput + " so the person's membership is a " + juniorOrSenior + " membership");



        //Exerciser/competition

        System.out.println("--------------------------------------------------------");
        System.out.print("Input new member activity status (Exerciser/competition): ");
        String swim = scanner.nextLine().trim().toLowerCase();

        while (swim.isEmpty() || swim.equals(" ")) {
            System.out.print("Invalid input try again:");
            swim = scanner.nextLine();
        }

        int memberNumber = 0;
        memberNumber = controller.getSizeOfDatabase();
        String finalMemberNumber = "";


        if (juniorOrSenior.equals("senior"))  {
            finalMemberNumber = "S" + memberNumber;
        } else {
            finalMemberNumber = "J" + memberNumber;
        }





        //Create member
        controller.createClubMember(finalMemberNumber, nameInput, ageInput, activity, juniorOrSenior, swim);

        controller.saveData(); //save to the file every time we make a new member.
    }

    public void showMenmbers() {
        for (ClubMember controller : controller.getMembers()) {
            System.out.println("------------------\n"
                    + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                    + "Name:...................... " + controller.getName() + "\n"
                    + "Age:....................... " + controller.getAge() + "\n"
                    + "Active Status:............. " + controller.isActivityStatus() + "\n"
                    + "Junior or senior:.......... " + controller.isSwimType() + "\n"
                    + "Exerciser or competition:.. " + controller.getMembershipType());
        }
    }

    public void editMember() {
        System.out.println("-----------------------------------------------------");
        System.out.println("Search for the member you want to edit: ");
        String userEditMember = scanner.nextLine();
        ArrayList<ClubMember> searchEditResult = new ArrayList<>();

        int index = 1;

        for (ClubMember editMember : controller.getMembers()) {
            String member = editMember.getName().toLowerCase();
            if (member.contains(userEditMember.toLowerCase())) {
                searchEditResult.add(editMember);
                System.out.println(index++ + ":" + editMember.getName());

            }
        }

        System.out.print("Indtast nummeret på den superhero du vil redigere: ");
        String userEditNumberString = scanner.nextLine();
        int userEditNumberInteger = Integer.parseInt(userEditNumberString);


        ClubMember editMember = searchEditResult.get(userEditNumberInteger - 1);
        System.out.println("Du har valgt at redigere: " + editMember.getName());

        System.out.println("Ønsker du ikke redigere tryk ENTER for at fortsætte!");


        do {
            System.out.println("Member name: " + editMember.getName());

            try {
                System.out.print("Type your update here: ");
                String newMemberName = scanner.nextLine().trim();
                if (!newMemberName.isEmpty()) {
                    editMember.setName(newMemberName);
                }
                userChoiceFalse = true;
            } catch (NumberFormatException var11) {
                System.out.println("Skriv venligst din rettelse med tekst bogstaver eller ENTER hvis du ikke vil rette!");
            }
        } while (userChoiceFalse);

        do {
            System.out.println("Member age: " + editMember.getAge());

            try {
                System.out.print("Type your update here: ");
                String newAge = scanner.nextLine().trim().toLowerCase();
                if (!newAge.isEmpty()) {
                    editMember.setAge(newAge);
                }

                userChoiceFalse = true;
            } catch (NumberFormatException var10) {
                System.out.println("Skriv venligst din rettelse med tekst bogstaver eller ENTER hvis du ikke vil rette!");
            }
        } while (userChoiceFalse);

        do {
            System.out.println("Activity status " + editMember.isActivityStatus());

            try {
                System.out.print("Type your update here:  ");
                String newActivityStatus = scanner.nextLine().trim();//trim cutter mellemrum fra brugerinputet.
                if (!newActivityStatus.isEmpty()) {
                    editMember.setActivityStatus(newActivityStatus);
                }

                userChoiceFalse = true;
            } catch (NumberFormatException var9) {
                System.out.println("Skriv venligst din rettelse med tekst bogstaver eller ENTER hvis du ikke vil rette!");
            }
        } while (userChoiceFalse);

        do {
            System.out.println("Membership type " + editMember.getMembershipType());

            try {
                System.out.print("Type your update here: ");
                String newMembershipType = scanner.nextLine().trim();
                if (!newMembershipType.isEmpty()) {
                    editMember.setMembershipType(newMembershipType);
                }

                userChoiceFalse = true;
            } catch (NumberFormatException var8) {
                System.out.println("Skriv venligst din rettelse med tal eller ENTER hvis du ikke vil rette!");
            }
        } while (userChoiceFalse);

        do {
            System.out.println("Membership number: " + editMember.getMembershipNumber());

            try {
                System.out.print("Type your update here: ");
                String newMembershipNumber = scanner.nextLine().trim();
                if (!newMembershipNumber.isEmpty()) {
                    editMember.setMembershipNumber(newMembershipNumber);
                }

                userChoiceFalse = true;
            } catch (NumberFormatException var7) {
                System.out.println("Skriv venligst din rettelse med (j/n) eller ENTER hvis du ikke vil rette!");
            }
        } while (userChoiceFalse);

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