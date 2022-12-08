package dataSource;

import profiles.ClubMember;
import profiles.Coach;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {
    public void saveData(ArrayList<ClubMember> clubMembers) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("data/clubmembersData.csv"));

        for (ClubMember member : clubMembers) {
            output.print(member.getMembershipNumber());
            output.print(";");
            output.print(member.getName());
            output.print(";");
            output.print(member.getAge());
            output.print(";");
            output.print(member.active());
            output.print(";");
            output.print(member.isSenior());
            output.print(";");
            output.print(member.getSwimType());
            output.print(";");
            output.print(member.getPayment());
            output.print(";");
            output.print(member.isRandomPay());
            output.print(";");
            output.print(member.getTeamName());
            output.print(";");
            output.print(member.isCrawl());
            output.print(";");
            output.print(member.getCrawlTime());
            output.print(";");
            output.print(member.isBackCrawl());
            output.print(";");
            output.print(member.getBackCrawlTime());
            output.print(";");
            output.print(member.isButterfly());
            output.print(";");
            output.print(member.getButterflyTime());
            output.print(";");
            output.print(member.isBreaststroke());
            output.print(";");
            output.print(member.getBreaststrokeTime());
            output.println();
        }
        output.close();
    }

    public void loadData(ArrayList<ClubMember> allClubmember) throws FileNotFoundException {

        Scanner reader = new Scanner(new File("data/clubmembersData.csv"));
        while (reader.hasNextLine()) {
            String line = reader.nextLine();

            ClubMember dataObjekt = parseCsvLine(line);
            allClubmember.add(dataObjekt);
        }
    }

    private ClubMember parseCsvLine(String line) {
        try {
            String[] parts = line.split(";");

            ClubMember loadClubmemberData = new ClubMember();
            loadClubmemberData.setMembershipNumber(Integer.parseInt(parts[0]));
            loadClubmemberData.setName(parts[1]);
            loadClubmemberData.setAge(parts[2]);
            loadClubmemberData.setActive(Boolean.parseBoolean(parts[3]));
            loadClubmemberData.setSenior(Boolean.parseBoolean(parts[4]));
            loadClubmemberData.setSwimType(parts[5]);
            loadClubmemberData.setPayment(Integer.parseInt(parts[6]));
            loadClubmemberData.setRandomPay(Boolean.parseBoolean(parts[7]));
            loadClubmemberData.setTeamName(parts[8]);
            loadClubmemberData.setCrawl(Boolean.parseBoolean(parts[9]));
            loadClubmemberData.setCrawlTime(parts[10]);
            loadClubmemberData.setBackCrawl(Boolean.parseBoolean(parts[11]));
            loadClubmemberData.setBackCrawlTime(parts[12]);
            loadClubmemberData.setButterfly(Boolean.parseBoolean(parts[13]));
            loadClubmemberData.setButterflyTime(parts[14]);
            loadClubmemberData.setBreaststroke(Boolean.parseBoolean(parts[15]));
            loadClubmemberData.setBreaststrokeTime(parts[16]);


            return loadClubmemberData;

        } catch (NumberFormatException e) {
            System.out.println("cannot load data");
            return null;
        }
    }
    public void saveCoachData(ArrayList<Coach> Coaches) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("data/coachesData.csv"));

        for (Coach coach : Coaches) {
            output.print(coach.getEmployeeNumber());
            output.print(";");
            output.print(coach.getName());
            output.print(";");
            output.print(coach.getAge());
            output.println();
        }
        output.close();
    }
    public void loadCoachData(ArrayList<Coach> coaches) throws FileNotFoundException {

        Scanner reader = new Scanner(new File("data/coachData.csv"));
        while (reader.hasNextLine()) {
            String line = reader.nextLine();

            Coach coachDataObjekt = parseCsvLineCoach(line);
            coaches.add(coachDataObjekt);
        }
    }
    private Coach parseCsvLineCoach(String line) {
        try {
            String[] parts = line.split(";");

            Coach loadCoachData = new Coach();
            loadCoachData.setEmployeeNumber(parts[0]);
            loadCoachData.setName(parts[1]);
            loadCoachData.setAge(Integer.parseInt(parts[2]));

            return loadCoachData;

        } catch (NumberFormatException e) {
            System.out.println("cannot load data");
            return null;
        }
    }












}

