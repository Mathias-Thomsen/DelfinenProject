package Ui;

import Profiles.ClubMember;
import Controller.Controller;
import Competitive.Competitive;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    boolean userChoiceFalse = false;
    private String nameInput;
    Controller controller = new Controller();

    public void mainMenu() {
        controller.loadData();
        controller.loadDataCoach();
        controller.loadCompetitiveData();
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

            switch (menuChoise) {
                case 1 -> clubManagerMenu();
                case 2 -> coachMenu();
                case 3 -> cashierMenu();
                case 9 -> exitProgram();
                default -> System.out.println("Invalid Input\n");
            }
        }

    }

    public void coachMenu(){
        int menuChoise = 0;
        System.out.println("""
                -------------------------
                Club manager menu:
                -------------------------
                1. Show competitive swimmers
                2. Show Senior team
                3. Show Junior team
                4. Show top 5 swimmers in each category
                5. Show tournament result
                6. Set time results
                9. Go back to sign in
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

        switch (menuChoise) {
            case 1 -> showCompetitiveSwimmers();
            case 2 -> showSeniorTeams();
            case 3 -> showJuniorTeams();
            //case 4 -> editMember();
            case 6 -> setTimeResults();
            //case 9 -> mainMenu();
            default -> System.out.println("Invalid Input\n");
        }
    }

    public void showSeniorTeams(){
        for (ClubMember controller : controller.getMembers()) {
            if (controller.getTeamName().equals("Team senior dolphins")){
                System.out.println("------------------\n"
                        + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                        + "Name:...................... " + controller.getName() + "\n"
                        + "Age:....................... " + controller.getAge() + "\n"
                        + "Team:......................" + controller.getTeamName());
            }
        }
    }

    public void showJuniorTeams(){
        for (ClubMember controller : controller.getMembers()) {
            if (controller.getTeamName().equals("Team junior dolphins")){
                System.out.println("------------------\n"
                        + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                        + "Name:...................... " + controller.getName() + "\n"
                        + "Age:....................... " + controller.getAge() + "\n"
                        + "Team:......................" + controller.getTeamName());
            }
        }
    }

    public void showCompetitiveSwimmers(){
        for (Competitive controller : controller.getCompetitors()) {
            System.out.println("------------------\n"
                    + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                    + "Name:...................... " + controller.getName() + "\n"
                    + "Crawl:..................... " + (controller.isCrawl() ? "Active" : "Passive" )  + "\n"
                    + "Backcrawl:................. " + (controller.isBackCrawl() ? "Active" : "Passive" ) + "\n"
                    + "Butterfly:................. " + (controller.isButterfly() ? "Active" : "Passive") + "\n"
                    + "Breaststroke:.............. " + (controller.isBreaststroke() ? "Active" : "Passive" ));
        }
    }

    public void setTimeResults(){
        System.out.println("-----------------------------------------------------");
        System.out.println("Search for the member you want to set results: ");
        String editTimeResults = scanner.nextLine();
        ArrayList<Competitive> searchEditResult = new ArrayList<>();

        int index = 1;

        for (Competitive editMember : controller.getCompetitors()) {
            String member = editMember.getName().toLowerCase();
            if (member.contains(editTimeResults.toLowerCase())) {
                searchEditResult.add(editMember);
                System.out.println(index++ + ":" + editMember.getName());

            }
        }

        System.out.print("Type in that member you want to edit: ");
        String userEditNumberString = scanner.nextLine();
        int userEditNumberInteger = Integer.parseInt(userEditNumberString);


        Competitive editMember = searchEditResult.get(userEditNumberInteger - 1);
        System.out.println("You have selected: " + editMember.getName());
        System.out.println("If you don't want to edit press ENTER!");
        if (editMember.isCrawl()){
            System.out.println("Crawl: " + (editMember.isCrawl() ? "Active" : "Passvie"));
            do {
                System.out.println("Crawl time: " + editMember.getCrawlTime());
                try {
                    System.out.println("Type your updated result here: ");
                    String newCrawlTime = scanner.nextLine();
                    if (!newCrawlTime.isEmpty()) {
                        editMember.setCrawlTime(newCrawlTime);
                    }
                    userChoiceFalse = true;
                } catch (Exception e) {
                    System.out.println("Type a time with '.' (fx. 2.14) with letters. If you don't want to edit press ENTER!");
                }
            } while (!userChoiceFalse);
        } if (editMember.isBackCrawl()) {
            System.out.println("Backcrawl: " + (editMember.isBackCrawl() ? "Active" : "Passvie"));
            do {
                System.out.println("backcrawl time: " + editMember.getBackCrawlTime());
                try {
                    System.out.println("Type your updated result here: ");
                    String newBackCrawlTime = scanner.nextLine();
                    if (!newBackCrawlTime.isEmpty()) {
                        editMember.setBackCrawlTime(newBackCrawlTime);
                    }
                    userChoiceFalse = true;
                } catch (Exception e) {
                    System.out.println("Type a time with '.' (fx. 2.14) with letters. If you don't want to edit press ENTER!");
                }
            } while (!userChoiceFalse);
        } if (editMember.isButterfly()){
            System.out.println("Butterfly: " + (editMember.isButterfly() ? "Active" : "Passvie"));
            do {
                System.out.println("Butterfly time: " + editMember.getButterflyTime());
                try {
                    System.out.println("Type your updated result here: ");
                    String newButterflyTime = scanner.nextLine();
                    if (!newButterflyTime.isEmpty()) {
                        editMember.setButterflyTime(newButterflyTime);
                    }
                    userChoiceFalse = true;
                } catch (Exception e) {
                    System.out.println("Type a time with '.' (fx. 2.14) with letters. If you don't want to edit press ENTER!");
                }
            } while (!userChoiceFalse);
        } if (editMember.isBreaststroke()){
            System.out.println("Breaststroke: " + (editMember.isBreaststroke() ? "Active" : "Passvie"));
            do {
                System.out.println("Breaststroke time: " + editMember.getButterflyTime());
                try {
                    System.out.println("Type your updated result here: ");
                    String newBreastStrokeTime = scanner.nextLine();
                    if (!newBreastStrokeTime.isEmpty()) {
                        editMember.setBreaststrokeTime(newBreastStrokeTime);
                    }
                    userChoiceFalse = true;
                } catch (Exception e) {
                    System.out.println("Type a time with '.' (fx. 2.14) with letters. If you don't want to edit press ENTER!");
                }
            } while (!userChoiceFalse);
        } else {
            System.out.println("Not active");
        }

        controller.saveCompetitiveData();
    }

    public void clubManagerMenu() {
        int menuChoise = 0;
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

        switch (menuChoise) {
            case 1 -> createMember();
            case 2 -> createCoach();
            case 3 -> showMenmbers();
            case 4 -> searchMember();
            case 5 -> editMember();
            case 6 -> deleteMember();
            case 9 -> mainMenu();
            default -> System.out.println("Invalid Input\n");
        }
    }

    public void cashierMenu(){
        int menuChoise = 0;
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
                userChoiceFalse = true;
            } catch (NumberFormatException e) {
                System.out.print("There has been a error enter a valid number: ");
                scanner.nextLine();
            }

        } while (!userChoiceFalse);

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

    public void createCoach() {
        //Name
        System.out.println("--------------------------------------------------------");
        System.out.println("Input new coach name: ");
        String coachNameInput = scanner.nextLine();
        while (coachNameInput.isEmpty() || coachNameInput.equals(" ")) {
            System.out.print("Invalid input try again:");
            coachNameInput = scanner.nextLine();
        }

        //Age
        System.out.println("--------------------------------------------------------");
        System.out.println("Input new coach birthday: ");
        System.out.print("Year (fx 2000): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Coach age can only be numbers, try again");
            scanner.nextLine();
        }
        int getCoachBirthYear = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Month (fx 9): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Coach age can only be numbers, try again");
            scanner.nextLine();
        }
        int getCoachBirthMonth = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Day (fx 18):");
        while (!scanner.hasNextInt()) {
            System.out.println("Member age can only be numbers, try again");
            scanner.nextLine();
        }
        int getCoachBirthDay = scanner.nextInt();
        scanner.nextLine();

        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(getCoachBirthYear, getCoachBirthMonth, getCoachBirthDay);

        int coacheAgeInput = controller.calculateAge(birthDate, currentDate);


        //create coach

        controller.createCoach(coachNameInput, coacheAgeInput);
        controller.setCoachNumber();



        //Save Data
        controller.saveDataCoach();

    }


    public void showUnpaidMembers(){
        for(ClubMember controller : controller.getUndpaidMembers())
        System.out.println("------------------\n"
                + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                + "Name:...................... " + controller.getName() + "\n"
                + "Age:....................... " + controller.getAge() + "\n"
                + "Active Status:............. " + (controller.active() ? "Active" : "Passive" )+ "\n"
                + "Junior or senior:.......... " + (controller.getSenior() ? "Senior" : "Junior") + "\n"
                + "Exerciser or competition:.. " + controller.isSwimType() + "\n"
                + "Subscription............... " + controller.getPayment() + "\n"
                + "Subscription is paid....... " + (controller.isRandomPay() ? "Paid" : "Not paid"));
    }
    public void showFinancialData() {
        controller.setTotaleIncome();
        System.out.println("------------------\n"
                + "Total senior members (1600)...............: " + controller.getTotalSeniorMembers() + "\n"
                + "Total junior members (1000)...............: " + controller.getTotalJuniorMembers() + "\n"
                + "Total senior plus members (1200)..........: " + controller.getTotalSeniorPlusMembers() + "\n"
                + "Total passive members (500)...............: " + controller.getTotalPassiveMembers() + "\n"
                + "Total expected amount.....................: " + controller.getTotalIncome() + "\n"
                + "Total income..............................: " + controller.getTotalAmount() + "\n"
                + "Unpaid income from members................: " + controller.getUnpaidAmount()

        );

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
        System.out.println("Input new member birthday: ");
        System.out.print("Year (fx 2000): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Member age can only be numbers, try again");
            scanner.nextLine();
        }
        int getBirthYear = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Month (fx 9): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Member age can only be numbers, try again");
            scanner.nextLine();
        }
        int getBirthMonth = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Day (fx 18):");
        while (!scanner.hasNextInt()) {
            System.out.println("Member age can only be numbers, try again");
            scanner.nextLine();
        }
        int getBirthDay = scanner.nextInt();
        scanner.nextLine();

        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(getBirthYear, getBirthMonth, getBirthDay);

        int ageInput = controller.calculateAge(birthDate, currentDate);


        //Activity status
        System.out.println("--------------------------------------------------------");
        System.out.println("Input new member activity status (active/passive): ");
        String activityInput;
        boolean setActive;
        boolean activeOrPassive;
        while (true) {
            activityInput = scanner.nextLine().trim().toLowerCase();
            if (activityInput.equals("active") || activityInput.equals("a")) {
                activeOrPassive = true;
                setActive = true;
                break;
            } else if (activityInput.equals("passive") || activityInput.equals("p")) {
                activeOrPassive = true;
                setActive = false;
                break;
            } else {
                System.out.println("You have to type active/passive or (a/p)");
            }
        }

        //Exerciser/competition
        System.out.println("--------------------------------------------------------");
        System.out.println("Input new member activity status (Exerciser/competition): ");
        String swim;
        boolean exerciserOrCompetition;

        while (true) {
            swim = scanner.nextLine().trim().toLowerCase();
            if (swim.equals("exerciser") || swim.equals("e")) {
                exerciserOrCompetition = true;
                swim = "Exerciser";
                break;
            } else if (swim.equals("competition") || swim.equals("c")) {
                exerciserOrCompetition = true;
                swim = "Competition";
                break;
            } else {
                System.out.println("You have to type exerciser/competition or (e/c)");
            }
        }

        if (swim.equals("Competition")){
            System.out.println("Please, select which category you swim");
            System.out.println("Crawl active/passive?");
            String crawl;
            boolean setCrawlActive;
            boolean crawlActiveOrPassive;
            while (true) {
                crawl = scanner.nextLine().trim().toLowerCase();
                if (crawl.equals("active") || crawl.equals("a")) {
                    crawlActiveOrPassive = true;
                    setCrawlActive = true;
                    controller.setCrawl();
                    break;
                } else if (crawl.equals("passive") || crawl.equals("p")) {
                    crawlActiveOrPassive = true;
                    setCrawlActive = false;
                    break;
                } else {
                    System.out.println("You have to type active/passive or (a/p)");
                }
            }
            System.out.println("Backcrawl active/passive?");
            String backCrawl;
            boolean setBackCrawl;
            boolean backCrawlActiveOrPassive;
            while (true) {
                backCrawl = scanner.nextLine().trim().toLowerCase();
                if (backCrawl.equals("active") || backCrawl.equals("a")) {
                    backCrawlActiveOrPassive = true;
                    setBackCrawl = true;
                    controller.setBackCrawl();
                    break;
                } else if (backCrawl.equals("passive") || backCrawl.equals("p")) {
                    backCrawlActiveOrPassive = true;
                    setBackCrawl = false;
                    break;
                } else {
                    System.out.println("You have to type active/passive or (a/p)");
                }
            }
            System.out.println("Butterfly active/passive?");
            String butterfly;
            boolean setButterfly;
            boolean butterflyActiveOrPassive;
            while (true) {
                butterfly = scanner.nextLine().trim().toLowerCase();
                if (butterfly.equals("active") || butterfly.equals("a")) {
                    butterflyActiveOrPassive = true;
                    setButterfly = true;
                    controller.setButterfly();
                    break;
                } else if (butterfly.equals("passive") || butterfly.equals("p")) {
                    butterflyActiveOrPassive = true;
                    setButterfly = false;
                    break;
                } else {
                    System.out.println("You have to type active/passive or (a/p)");
                }
            }
            System.out.println("Breaststroke active/passive?");
            String breaststroke;
            boolean setBreastActive;
            boolean breastActiveOrPassive;
            while (true) {
                breaststroke = scanner.nextLine().trim().toLowerCase();
                if (breaststroke.equals("active") || breaststroke.equals("a")) {
                    breastActiveOrPassive = true;
                    setBreastActive = true;
                    controller.setBreaststroke();
                    break;
                } else if (breaststroke.equals("passive") || breaststroke.equals("p")) {
                    breastActiveOrPassive = true;
                    setBreastActive = false;
                    break;
                } else {
                    System.out.println("You have to type active/passive or (a/p)");
                }
            }
        }


        //Create member
        controller.createClubMember(nameInput, ageInput, setActive, swim);
        controller.getRandomPay();
        controller.junoirOrsenoir();
        controller.teamName();
        controller.setClubMemberNumber();
        controller.getCreatePayment();
        controller.createCompetitive(null, nameInput, controller.isCrawl(), 0, controller.isBackCrawl(), 0, controller.isButterfly(), 0, controller.isBreaststroke(), 0, null);

        controller.saveData(); //save to the file every time we make a new member.

        controller.saveCompetitiveData();

    }
    public void showMenmbers() {
        for (ClubMember controller : controller.getMembers()) {
            System.out.println("------------------\n"
                    + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                    + "Name:...................... " + controller.getName() + "\n"
                    + "Age:....................... " + controller.getAge() + "\n"
                    + "Active Status:............. " + (controller.active() ? "Active" : "Passive" ) + "\n"
                    + "Junior or senior:.......... " + (controller.getSenior() ? "Senior" : "Junior") + "\n"
                    + "Exerciser or competition:.. " + controller.isSwimType());
        }
    }
    public void showMenmbersWithCashier() {
        for (ClubMember controller : controller.getMembers()) {
            System.out.println("------------------\n"
                    + "Membership Number:......... " + controller.getMembershipNumber() + "\n"
                    + "Name:...................... " + controller.getName() + "\n"
                    + "Age:....................... " + controller.getAge() + "\n"
                    + "Active Status:............. " + (controller.active() ? "Active" : "Passive" )+ "\n"
                    + "Junior or senior:.......... " + (controller.getSenior() ? "Senior" : "Junior") + "\n"
                    + "Exerciser or competition:.. " + controller.isSwimType() + "\n"
                    + "Subscription............... " + controller.getPayment() + "\n"
                    + "Subscription is paid....... " + (controller.isRandomPay() ? "Paid" : "Not paid"));
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
                    + "Junior or senior:.......... " + (controller.getSenior() ? "Senior" : "Junior")+ "\n"
                    + "Exerciser or competition:.. " + controller.isSwimType() + "\n"
                    + "Subscription............... " + controller.getPayment());
        }
        if (controller.findMember(searchTerm).isEmpty()) {
            System.out.println("No result");
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
                    + "Junior or senior:.......... " + controller.getSenior() + "\n"
                    + "Exerciser or competition:.. " + controller.isSwimType());
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

        for (ClubMember editMember : controller.getMembers()) {
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
                userChoiceFalse = true;
            } catch (NumberFormatException var11) {
                System.out.println("Type a name with letters. If you don't want to edit press ENTER!");
            }
        } while (!userChoiceFalse);


        do {
            System.out.println("Activity status: " + (editMember.active() ? "active" : "passive"));

            try {
                System.out.print("Type your update here (active/passive):  ");
                boolean activeOrPassive;
                while (true) {
                    String activityEditInput = scanner.nextLine().trim().toLowerCase();
                    if (!activityEditInput.isEmpty()) {

                        if (activityEditInput.equals("active") || activityEditInput.equals("a")) {
                            activeOrPassive = true;
                            editMember.setActive(true);
                            break;
                        } else if (activityEditInput.equals("passive") || activityEditInput.equals("p")) {
                            activeOrPassive = true;
                            editMember.setActive(false);
                            break;
                        } else {
                            System.out.println("You have to type active/passive or (a/p)");
                        }
                    } else {
                        break;
                    }
                }
                userChoiceFalse = true;
            } catch (NumberFormatException var9) {
                System.out.println("Type with letters. If you don't want to edit press ENTER!");
            }
        } while (!userChoiceFalse);

        do {
            System.out.println("Member paid: " + (editMember.isRandomPay() ? "Has paid" : "Haven't paid"));

            try {
                System.out.print("Type your update here (Has paid/Has not paid):  ");
                boolean activeOrPassive;
                while (true) {
                    String isRandomInput = scanner.nextLine().trim().toLowerCase();
                    if (!isRandomInput.isEmpty()) {

                        if (isRandomInput.trim().toLowerCase().equals("has paid") || isRandomInput.trim().toLowerCase().equals("p")) {
                            activeOrPassive = true;
                            editMember.setRandomPay(true);
                            break;
                        } else if (isRandomInput.trim().toLowerCase().equals("has not paid") || isRandomInput.equals("n")) {
                            activeOrPassive = true;
                            editMember.setRandomPay(false);
                            break;
                        } else {
                            System.out.println("You have to type (has paid/has not paid) or (p/n)");
                        }
                    } else {
                        break;
                    }
                }
                userChoiceFalse = true;
            } catch (NumberFormatException var9) {
                System.out.println("Type with letters. If you don't want to edit press ENTER!");
            }
        } while (!userChoiceFalse);



        controller.junoirOrsenoir();
        controller.setClubMemberNumber();
        controller.saveData();


    }
    public void deleteMember() {
        System.out.println("--------------------------------------------------------");
        System.out.println("Input the name of a member you want to delete: ");
        String userDeleteMember = scanner.nextLine().trim().toLowerCase();
        ArrayList<ClubMember> searchDeleteMember = new ArrayList<>();

        int index = 1;

        for (ClubMember deleteMember : controller.getClubMembers()) {
            nameInput = deleteMember.getName().toLowerCase();
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