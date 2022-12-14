package ui;

import profiles.ClubMember;
import controller.Controller;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Controller controller = new Controller();
    private boolean userChoice = false; //The loops in edit member keeps going while userChoice is false.

    //________________Start program and main menu________________
    public void startProgram() {
        controller.startProgram();
        mainMenu();
    }
    public int menuChoise() {
        int menuChoiseInt = 0;
        do {
            String valg = scanner.nextLine().trim();
            try {
                menuChoiseInt = Integer.parseInt(valg);
                userChoice = true;
            } catch (NumberFormatException e) {
                System.out.print("There has been a error enter a valid number: ");
                scanner.nextLine();
            }

        } while (!userChoice);
        return menuChoiseInt;
    }
    public void mainMenu() {
        int mainMenuChoise = 0;
        while (mainMenuChoise != 9) {
            System.out.println("""
                    -------------------------
                    Sign in as:
                    -------------------------
                    1. Club manager
                    2. Coach
                    3. Cashier
                    9. Exit program
                    """);

            mainMenuChoise = menuChoise();

            switch (mainMenuChoise) {
                case 1 -> clubManagerMenu();
                case 2 -> coachMenu();
                case 3 -> cashierMenu();
                case 9 -> exitProgram();
                default -> System.out.println("Invalid Input\n");
            }
        }

    }

    //_________________Club Manager________________________
    public void clubManagerMenu() {
        int clubManagerChoise = 0;
        while (clubManagerChoise != 9) {
            System.out.println("""
                -------------------------
                Club manager menu:
                -------------------------
                1. Create new member
                2. Create new coach
                3. Show list of members
                4. Search for members
                5. Edit member information
                6. Delete current member
                9. Go back to sign in
                """);

           clubManagerChoise = menuChoise();

            switch (clubManagerChoise) {
                case 1 -> createMember();
                case 2 -> createCoach();
                case 3 -> showMembers();
                case 4 -> searchMember();
                case 5 -> editMember();
                case 6 -> deleteMember();
                case 9 -> mainMenu();
                default -> System.out.println("Invalid Input\n");
            }
        }
    }
    public boolean activeOrPassiveChoise() {
        boolean choiseFalse = false;
        while (userChoice) {
            String choiseString = scanner.nextLine().trim().toLowerCase();
            if (choiseString.equals("active") || choiseString.equals("a")) {
                choiseFalse = true;
                break;
            } else if (choiseString.equals("passive") || choiseString.equals("p")) {
                break;
            } else {
                System.out.println("You have to type active/passive or (a/p)");
            }
        }
       return choiseFalse;
    }
    public String createName(){
        String nameInput;
        System.out.println("--------------------------------------------------------");
        System.out.println("Input new name: ");
        nameInput = scanner.nextLine();
        while (nameInput.isEmpty() || nameInput.equals(" ")) {
            System.out.print("Invalid input try again:");
            nameInput = scanner.nextLine();
        }
        return nameInput;
    }
    public int createAge() {
        int birthYear = 0;
        int birthMonth = 0;
        int birthDay = 0;
        Year thisYear = Year.now();
        int thisYearInt = Integer.parseInt(String.valueOf(thisYear));

        System.out.print("Year (fx 2000): ");
        while(userChoice) {
            birthYear = scanner.nextInt();
            if (birthYear <= thisYearInt) {
                userChoice = true;
                break;
            }else {
                System.out.println("Please type a number between this current year or less");

            }
        }
        System.out.println("--------------------------------------------------------");
        System.out.print("Month (fx 9): ");

        while(userChoice) {
            birthMonth = scanner.nextInt();
            if (birthMonth >= 1 && birthMonth <= 12) {
                userChoice = true;
                break;
            }else {
                System.out.println("Please type a number between 1 and 12");
            }
        }

        System.out.println("--------------------------------------------------------");
        System.out.print("Day (fx 20): ");
        while(userChoice) {
            birthDay = scanner.nextInt();
            if (birthDay >= 1 && birthDay <= 30) {
                userChoice = true;
                break;
            }else {
                System.out.println("Please type a number between 1 and 12");
            }
        }
        scanner.nextLine();

        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);

        int ageInput = controller.calculateAge(birthDate, currentDate);
        return ageInput;
    }
    public void createMember() {

        //Name
        String memberName;
        memberName = createName();

        //Age
        System.out.println("--------------------------------------------------------");
        System.out.println("Input new member birthday: ");
        int memberAge;
        memberAge = createAge();

        //Activity status
        System.out.println("--------------------------------------------------------");
        System.out.println("Input new member activity status (active/passive): ");
        boolean setActive;
        setActive = activeOrPassiveChoise();



        //Exerciser/competition
        System.out.println("--------------------------------------------------------");
        System.out.println("Input new member activity status (Exerciser/competition): ");
        String swim;
        while (true) {
            swim = scanner.nextLine().trim().toLowerCase();
            if (swim.equals("exerciser") || swim.equals("e")) {
                swim = "Exerciser";
                break;
            } else if (swim.equals("competition") || swim.equals("c")) {
                swim = "Competition";
                break;
            } else {
                System.out.println("You have to type exerciser/competition or (e/c)");
            }
        }
        boolean crawl = false;
        boolean backCrawl = false;
        boolean butterfly = false;
        boolean breast = false;
        int number = controller.getNextMemberNumber();
        if (swim.equals("Competition")) {
            System.out.println("Please, select which swim catagory you are active in");
            System.out.print("Crawl active/passive: ");
            crawl = activeOrPassiveChoise();
            System.out.print("Backcrawl active/passive:");
            backCrawl = activeOrPassiveChoise();
            System.out.print("Butterfly active/passive:");
            butterfly = activeOrPassiveChoise();
            System.out.print("Breaststroke active/passive:");
            breast = activeOrPassiveChoise();

        }

        //Create member with all informations
        controller.createClubMember(number, memberName, memberAge, setActive, swim, crawl, 0, backCrawl, 0, butterfly, 0, breast, 0);
        controller.getRandomPay(); // Set random pay true/false
        controller.junoirOrsenoir(); // calculate from the age and set the member to junior or senior
        controller.teamName(); // connect to teams from junior or senior
        controller.getCreatePayment();
        controller.saveData(); //save to the file every time we make a new member.


    }
    public void createCoach() {
        //Name
        String coachName;
        coachName = createName();

        //Age
        int coachAge;
        coachAge = createAge();

        //create coach
        controller.createCoach(coachName, coachAge);
        controller.setCoachNumber();

        //Save Data
        controller.saveDataCoach();

    }
    public void showMembers() {
        for (ClubMember controller : controller.getMembers()) {
            System.out.println("------------------\n"
                    + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                    + "Name:...................... " + controller.getName() + "\n"
                    + "Age:....................... " + controller.getAge() + "\n"
                    + "Active Status:............. " + (controller.active() ? "Active" : "Passive" ) + "\n"
                    + "Junior or senior:.......... " + (controller.isSenior() ? "Senior" : "Junior") + "\n"
                    + "Exerciser or competition:.. " + controller.getSwimType());
        }
    }
    public void searchMember() {
        System.out.println("-----------------------------------------------------");
        System.out.println("Type in the member you want to search for: ");

        String searchTerm = scanner.nextLine().toLowerCase();
        for (ClubMember controller : controller.findMember(searchTerm)) {
            System.out.println("------------------\n"
                    + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                    + "Name:...................... " + controller.getName() + "\n"
                    + "Age:....................... " + controller.getAge() + "\n"
                    + "Active Status:............. " + (controller.active() ? "Active" : "Passive") + "\n"
                    + "Junior or senior:.......... " + (controller.isSenior() ? "Senior" : "Junior") + "\n"
                    + "Exerciser or competition:.. " + controller.getSwimType());
        }
        if (controller.findMember(searchTerm).isEmpty()) {
            System.out.println("No result");
        }

    }
    public void editMember() {
        System.out.println("-----------------------------------------------------");
        System.out.println("Search for the member you want to edit: ");
        String userEditMember = scanner.nextLine();
        ArrayList<ClubMember> searchEditResult = new ArrayList<>();

        int index = 1;

        for (ClubMember editMember : controller.getMembers()) { // list the search result with number so user can pick the right one
            String member = editMember.getName().toLowerCase();
            if (member.contains(userEditMember.toLowerCase())) {
                searchEditResult.add(editMember);
                System.out.println(index++ + ":" + editMember.getName());

            }
        }

        System.out.print("Type in that member you want to edit: ");
        String userEditNumberString = scanner.nextLine();
        int userEditNumberInteger = Integer.parseInt(userEditNumberString);


        ClubMember editMember = searchEditResult.get(userEditNumberInteger - 1);
        System.out.println("You have selected: " + editMember.getName());

        System.out.println("If you don't want to edit press ENTER!");


        do {
            System.out.println("Member name: " + editMember.getName());

            try {
                System.out.print("Type your update here: ");
                String newMemberName = scanner.nextLine().trim();
                if (!newMemberName.isEmpty()) {
                    editMember.setName(newMemberName);
                }
                userChoice = true;
            } catch (NumberFormatException var11) {
                System.out.println("Type a name with letters. If you don't want to edit press ENTER!");
            }
        } while (!userChoice);

        do {
            System.out.println("Activity status: " + (editMember.active() ? "active" : "passive"));

            try {
                System.out.print("Type your update here (active/passive) or (a/p):  ");
                while (true) {
                    String activityEditInput = scanner.nextLine().trim().toLowerCase();
                    if (!activityEditInput.isEmpty()) {

                        if (activityEditInput.equals("active") || activityEditInput.equals("a")) {
                            editMember.setActive(true);
                            break;
                        } else if (activityEditInput.equals("passive") || activityEditInput.equals("p")) {
                            editMember.setActive(false);
                            break;
                        } else {
                            System.out.println("You have to type active/passive or (a/p)");
                        }
                    } else {
                        break;
                    }
                }
                userChoice = true;
            } catch (NumberFormatException var9) {
                System.out.println("Type with letters. If you don't want to edit press ENTER!");
            }
        } while (!userChoice);

        do {
            System.out.println("Member paid: " + (editMember.isRandomPay() ? "Has paid" : "Haven't paid"));
            try {
                System.out.print("Type your update here (Has paid/Has not paid) or (p/n):  ");
                while (true) {
                    String isRandomInput = scanner.nextLine().trim().toLowerCase();

                    if (!isRandomInput.isEmpty()) {
                        if (isRandomInput.trim().equalsIgnoreCase("has paid") || isRandomInput.trim().equalsIgnoreCase("p")) {
                            editMember.setRandomPay(true);
                            break;
                        } else if (isRandomInput.trim().equalsIgnoreCase("has not paid") || isRandomInput.equalsIgnoreCase("n")) {
                            editMember.setRandomPay(false);
                            break;
                        } else {
                            System.out.println("You have to type (has paid/has not paid) or (p/n)");
                        }
                    } else {
                        break;
                    }
                }
                userChoice = true;
            } catch (NumberFormatException var9) {
                System.out.println("Type with letters. If you don't want to edit press ENTER!");
            }
        } while (!userChoice);

        controller.saveData();

    }
    public void deleteMember() {
        System.out.println("--------------------------------------------------------");
        System.out.println("Input the name of a member you want to delete: ");
        String userDeleteMember = scanner.nextLine().trim().toLowerCase();
        ArrayList<ClubMember> searchDeleteMember = new ArrayList<>();

        int index = 1;


        for (ClubMember deleteMember : controller.getMembers()) {
            String nameInput = deleteMember.getName().toLowerCase();
            if (nameInput.contains(userDeleteMember.toLowerCase())) {
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

    //_________________Coach________________________________
    public void coachMenu(){
        int coachMenuChoise = 0;
        while (coachMenuChoise != 9) {
            System.out.println("""
                -------------------------
                Coach menu:
                -------------------------
                1. Show competitive swimmers
                2. Show Senior team
                3. Show Junior team
                4. Show top 5 swimmers in each category
                5. Set time results
                9. Go back to sign in
                """);

           coachMenuChoise = menuChoise();

            switch (coachMenuChoise) {
                case 1 -> showCompetitiveSwimmers();
                case 2 -> showSeniorTeams();
                case 3 -> showJuniorTeams();
                case 4 -> showTop5SwimmersMenu();
                case 5 -> setTimeResults();
                case 9 -> mainMenu();
                default -> System.out.println("Invalid Input\n");
            }
        }
    }
    public void showCompetitiveSwimmers(){
        for (ClubMember controller : controller.getMembers()) {
            if (controller.getSwimType().equals("Competition")){
            System.out.println("------------------\n"
                    + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                    + "Name:...................... " + controller.getName() + "\n"
                    + "Crawl:..................... " + (controller.isCrawl() ? "Active" : "Passive" )  + "\n"
                    + "Backcrawl:................. " + (controller.isBackCrawl() ? "Active" : "Passive" ) + "\n"
                    + "Butterfly:................. " + (controller.isButterfly() ? "Active" : "Passive") + "\n"
                    + "Breaststroke:.............. " + (controller.isBreaststroke() ? "Active" : "Passive" ));
            }
        }
    }
    public void showSeniorTeams(){
        for (ClubMember controller : controller.getMembers()) {
            if (controller.getTeamName().equals("Team senior dolphins")){
                System.out.println("-------------------------------\n"
                        + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                        + "Name:...................... " + controller.getName() + "\n"
                        + "Age:....................... " + controller.getAge() + "\n"
                        + "Team:...................... " + controller.getTeamName());
            }
        }
    }
    public void showJuniorTeams(){
        for (ClubMember controller : controller.getMembers()) {
            if (controller.getTeamName().equals("Team junior dolphins")){
                System.out.println("-------------------------------\n"
                        + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                        + "Name:...................... " + controller.getName() + "\n"
                        + "Age:....................... " + controller.getAge() + "\n"
                        + "Team:...................... " + controller.getTeamName());
            }
        }
    }
    public void showTop5SwimmersMenu(){
        int menuChoise = 0;
        while (menuChoise != 9) {
            System.out.println("""
                -------------------------
                Select swim category:
                -------------------------
                1. Show top 5 crawl swimmers (Senior)
                2. Show top 5 backcrawl swimmers (Senior) 
                3. Show top 5 butterfly swimmers (Senior)
                4. Show top 5 breaststroke swimmers (Senior)
                5. Show top 5 crawl swimmers (Junior)
                6. Show top 5 backcrawl swimmers (Junior)
                7. Show top 5 butterfly swimmers (Junior)
                8. Show top 5 breaststroke swimmers (Junior)
                9. Go back to coach menu
                """);

            do {
                String valg = scanner.nextLine().trim();
                try {
                    menuChoise = Integer.parseInt(valg);
                    userChoice = true;
                } catch (NumberFormatException e) {
                    System.out.print("There has been a error enter a valid number: ");
                    scanner.nextLine();
                }

            } while (!userChoice);

            switch (menuChoise) {
                case 1 -> showTop5CrawlSwimmersSenior();
                case 2 -> showTop5BackCrawlSwimmersSenior();
                case 3 -> showTop5ButterflySwimmersSenior();
                case 4 -> showTop5BreaststrokeSwimmersSenior();
                case 5 -> showTop5CrawlSwimmersJunior();
                case 6 -> showTop5BackCrawlSwimmersJunior();
                case 7 -> showTop5ButterflySwimmersJunior();
                case 8 -> showTop5BreaststrokeSwimmersJunior();
                case 9 -> coachMenu();

                default -> System.out.println("Invalid Input\n");
            }
        }
    }
    public void showTop5CrawlSwimmersSenior(){
        System.out.println("Top 5 crawl swimmers");
        controller.sortCrawlTime();
        for (ClubMember controller : controller.getMembers()){
            if (controller.getCrawlTime() != 0 && controller.getTeamName().equals("Team senior dolphins")) {
                System.out.println("------------------\n"
                        + "Team:...................... " + controller.getTeamName() + "\n"
                        + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                        + "Name:...................... " + controller.getName() + "\n"
                        + "Time:...................... " + controller.getCrawlTime());
            }
        }
    }
    public void showTop5CrawlSwimmersJunior(){
        System.out.println("Top 5 crawl swimmers");
        controller.sortCrawlTime();
        for (ClubMember controller : controller.getMembers()){
            if (controller.getCrawlTime() != 0 && controller.getTeamName().equals("Team junior dolphins")) {
                System.out.println("------------------\n"
                        + "Team:...................... " + controller.getTeamName() + "\n"
                        + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                        + "Name:...................... " + controller.getName() + "\n"
                        + "Time:...................... " + controller.getCrawlTime());
            }
        }

    }
    public void showTop5BackCrawlSwimmersSenior(){
        System.out.println("Top 5 back crawl swimmers");
        controller.sortBackCrawlTime();
        for (ClubMember controller : controller.getMembers()){
            if (controller.getBackCrawlTime() != 0 && controller.getTeamName().equals("Team senior dolphins")) {
                System.out.println("------------------\n"
                        + "Team:...................... " + controller.getTeamName() + "\n"
                        + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                        + "Name:...................... " + controller.getName() + "\n"
                        + "Time:...................... " + controller.getBackCrawlTime());
            }
        }
    }
    public void showTop5BackCrawlSwimmersJunior(){
        System.out.println("Top 5 back crawl swimmers");
        controller.sortBackCrawlTime();
        for (ClubMember controller : controller.getMembers()){
            if (controller.getBackCrawlTime() != 0 && controller.getTeamName().equals("Team junior dolphins")) {
                System.out.println("------------------\n"
                        + "Team:...................... " + controller.getTeamName() + "\n"
                        + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                        + "Name:...................... " + controller.getName() + "\n"
                        + "Time:...................... " + controller.getBackCrawlTime());
            }
        }
    }
    public void showTop5ButterflySwimmersSenior(){
        System.out.println("Top 5 butterfly swimmers");
        controller.sortButterflyTime();
        for (ClubMember controller : controller.getMembers()){
            if (controller.getButterflyTime() != 0 && controller.getTeamName().equals("Team senior dolphins")) {
                System.out.println("------------------\n"
                        + "Team:...................... " + controller.getTeamName() + "\n"
                        + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                        + "Name:...................... " + controller.getName() + "\n"
                        + "Time:...................... " + controller.getButterflyTime());
            }
        }
    }
    public void showTop5ButterflySwimmersJunior(){
        System.out.println("Top 5 butterfly swimmers");
        controller.sortButterflyTime();
        for (ClubMember controller : controller.getMembers()){
            if (controller.getButterflyTime() != 0 && controller.getTeamName().equals("Team junior dolphins")) {
                System.out.println("------------------\n"
                        + "Team:...................... " + controller.getTeamName() + "\n"
                        + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                        + "Name:...................... " + controller.getName() + "\n"
                        + "Time:...................... " + controller.getButterflyTime());
            }
        }
    }
    public void showTop5BreaststrokeSwimmersSenior(){
        System.out.println("Top 5 breaststroke swimmers");
        controller.sortBreastStrokeTime();
        for (ClubMember controller : controller.getMembers()){
            if (controller.getBreaststrokeTime() != 0 && controller.getTeamName().equals("Team senior dolphins")) {
                System.out.println("------------------\n"
                        + "Team:...................... " + controller.getTeamName() + "\n"
                        + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                        + "Name:...................... " + controller.getName() + "\n"
                        + "Time:...................... " + controller.getBreaststrokeTime());
            }
        }
    }
    public void showTop5BreaststrokeSwimmersJunior(){
        System.out.println("Top 5 breaststroke swimmers");
        controller.sortBreastStrokeTime();
        for (ClubMember controller : controller.getMembers()){
            if (controller.getBreaststrokeTime() != 0 && controller.getTeamName().equals("Team junior dolphins")) {
                System.out.println("------------------\n"
                        + "Team:...................... " + controller.getTeamName() + "\n"
                        + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                        + "Name:...................... " + controller.getName() + "\n"
                        + "Time:...................... " + controller.getBreaststrokeTime());
            }
        }
    }
    public void setTimeResults(){
        System.out.println("-----------------------------------------------------");
        System.out.println("Search for the member you want to set results: ");
        String editTimeResults = scanner.nextLine();
        ArrayList<ClubMember> searchEditResult = new ArrayList<>();

        int index = 1;

        for (ClubMember editMember : controller.getMembers()) {
            String member = editMember.getName().toLowerCase();
            if (member.contains(editTimeResults.toLowerCase())) {
                searchEditResult.add(editMember);
                System.out.println(index++ + ":" + editMember.getName());

            }
        }

        System.out.print("Type in that member you want to edit: ");
        String userEditNumberString = scanner.nextLine();
        int userEditNumberInteger = Integer.parseInt(userEditNumberString);


        ClubMember editMember = searchEditResult.get(userEditNumberInteger - 1);
        System.out.println("You have selected: " + editMember.getName());
        System.out.println("If you don't want to edit press ENTER!");
        if (editMember.isCrawl()){
            System.out.println("Crawl: " + (editMember.isCrawl() ? "Active" : "Passvie"));
            do {
                System.out.println("Crawl time: " + editMember.getCrawlTime() + " minutes");
                try {
                    System.out.println("Type your updated result here: ");
                    String newCrawlTime = scanner.nextLine();
                    if (!newCrawlTime.isEmpty()) {
                        editMember.setCrawlTime(newCrawlTime);
                    }
                    userChoice = true;
                } catch (Exception e) {
                    System.out.println("Type a time with '.' (fx. 2.14) with letters. If you don't want to edit press ENTER!");
                }
            } while (!userChoice);
        } if (editMember.isBackCrawl()) {
            System.out.println("Backcrawl: " + (editMember.isBackCrawl() ? "Active" : "Passvie"));
            do {
                System.out.println("backcrawl time: " + editMember.getBackCrawlTime() + " minutes");
                try {
                    System.out.println("Type your updated result here: ");
                    String newBackCrawlTime = scanner.nextLine();
                    if (!newBackCrawlTime.isEmpty()) {
                        editMember.setBackCrawlTime(newBackCrawlTime);
                    }
                    userChoice = true;
                } catch (Exception e) {
                    System.out.println("Type a time with '.' (fx. 2.14) with letters. If you don't want to edit press ENTER!");
                }
            } while (!userChoice);
        } if (editMember.isButterfly()){
            System.out.println("Butterfly: " + (editMember.isButterfly() ? "Active" : "Passvie"));
            do {
                System.out.println("Butterfly time: " + editMember.getButterflyTime() + " minutes");
                try {
                    System.out.println("Type your updated result here: ");
                    String newButterflyTime = scanner.nextLine();
                    if (!newButterflyTime.isEmpty()) {
                        editMember.setButterflyTime(newButterflyTime);
                    }
                    userChoice = true;
                } catch (Exception e) {
                    System.out.println("Type a time with '.' (fx. 2.14) with letters. If you don't want to edit press ENTER!");
                }
            } while (!userChoice);
        } if (editMember.isBreaststroke()){
            System.out.println("Breaststroke: " + (editMember.isBreaststroke() ? "Active" : "Passvie"));
            do {
                System.out.println("Breaststroke time: " + editMember.getBreaststrokeTime() + " minutes");
                try {
                    System.out.println("Type your updated result here: ");
                    String newBreastStrokeTime = scanner.nextLine();
                    if (!newBreastStrokeTime.isEmpty()) {
                        editMember.setBreaststrokeTime(newBreastStrokeTime);
                    }
                    userChoice = true;
                } catch (Exception e) {
                    System.out.println("Type a time with '.' (fx. 2.14) with letters. If you don't want to edit press ENTER!");
                }
            } while (!userChoice);
        } else {
            System.out.println("Not active");
        }

        controller.saveData();
    }

    //__________________Cashier____________________________
    public void cashierMenu(){
        int menuChoise = 0;
        while (menuChoise != 9) {
            System.out.println("""
                -------------------------
                Cashier menu:
                -------------------------
                1. Show list of all members
                2. Search for members
                3. Edit member subscription
                4. Show financials
                5. Show list of unpaid members
                9. Go back to sign in
                """);

            do {
                String valg = scanner.nextLine().trim();
                try {
                    menuChoise = Integer.parseInt(valg);
                    userChoice = true;
                } catch (NumberFormatException e) {
                    System.out.print("There has been a error enter a valid number: ");
                    scanner.nextLine();
                }

            } while (!userChoice);

            switch (menuChoise) {
                case 1 -> showMenmbersWithCashier();
                case 2 -> searchMemberCashier();
                case 3 -> editMember();
                case 4 -> showFinancialData();
                case 5 -> showUnpaidMembers();
                case 9 -> mainMenu();
                default -> System.out.println("Invalid Input\n");
            }
        }

    }
    public void showMenmbersWithCashier() {
        for (ClubMember controller : controller.getMembers()) {
            System.out.println("------------------\n"
                    + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                    + "Name:...................... " + controller.getName() + "\n"
                    + "Age:....................... " + controller.getAge() + "\n"
                    + "Active Status:............. " + (controller.active() ? "Active" : "Passive" )+ "\n"
                    + "Junior or senior:.......... " + (controller.isSenior() ? "Senior" : "Junior") + "\n"
                    + "Exerciser or competition:.. " + controller.getSwimType() + "\n"
                    + "Subscription:............... " + controller.getPayment() + "\n"
                    + "Subscription is paid:...... " + (controller.isRandomPay() ? "Paid" : "Not paid"));
        }
    }
    public void searchMemberCashier() {
        System.out.println("-----------------------------------------------------");
        System.out.println("Type in the member you want to search for: ");

        String searchTerm = scanner.nextLine().toLowerCase();
        for (ClubMember controller : controller.findMember(searchTerm)) {
            System.out.println("------------------\n"
                    + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                    + "Name:...................... " + controller.getName() + "\n"
                    + "Age:....................... " + controller.getAge() + "\n"
                    + "Active Status:............. " + (controller.active() ? "Active" : "Passive") + "\n"
                    + "Junior or senior:.......... " + (controller.isSenior() ? "Senior" : "Junior")+ "\n"
                    + "Exerciser or competition:.. " + controller.getSwimType() + "\n"
                    + "adelfineProjectPackage.Subscription............... " + controller.getPayment());
        }
        if (controller.findMember(searchTerm).isEmpty()) {
            System.out.println("No result");
        }

    }
    public void showUnpaidMembers(){
        for(ClubMember controller : controller.getUndpaidMembers())
            System.out.println("------------------\n"
                    + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                    + "Name:...................... " + controller.getName() + "\n"
                    + "Age:....................... " + controller.getAge() + "\n"
                    + "Active Status:............. " + (controller.active() ? "Active" : "Passive" )+ "\n"
                    + "Junior or senior:.......... " + (controller.isSenior() ? "Senior" : "Junior") + "\n"
                    + "Exerciser or competition:.. " + controller.getSwimType() + "\n"
                    + "Subscription:.............. " + controller.getPayment() + "\n"
                    + "Subscription is paid:...... " + (controller.isRandomPay() ? "Paid" : "Not paid"));
    }
    public void showFinancialData() {
        System.out.println("------------------\n"
                + "Total senior members (1600)...............: " + controller.getTotalSeniorMembers() + "\n"
                + "Total junior members (1000)...............: " + controller.getTotalJuniorMembers() + "\n"
                + "Total senior plus members (1200)..........: " + controller.getTotalSeniorPlusMembers() + "\n"
                + "Total passive members (500)...............: " + controller.getTotalPassiveMembers() + "\n"
                + "Total expected amount.....................: " + controller.getTotaleIncome() + "\n"
                + "Total income..............................: " + controller.getTotalAmount() + "\n"
                + "Unpaid income from members................: " + controller.getUnpaidAmount()

        );

    }

    //__________________Exit Program_________________
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