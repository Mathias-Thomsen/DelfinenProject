package DataSouce;

import ClubMember.ClubMember;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {
    public void saveData(ArrayList<ClubMember> clubMembers) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("data/clubmembersData.csv"));

        for (ClubMember member : clubMembers) {
            output.print(member.getName());
            output.print(";");
            output.print(member.getAge());
            output.print(";");
            output.print(member.isActivityStatus());
            output.print(";");
            output.print(member.getMembershipType());
            output.print(";");
            output.print(member.isSwimType());
            output.print(";");
            output.print(member.getMembershipNumber());
            output.println();


        }
        output.close();
    }
    public void loadData(ArrayList<ClubMember> allClubmember) throws FileNotFoundException {

        Scanner reader = new Scanner(new File("data/clubmembersData.csv"));
        while(reader.hasNextLine()) {
            String line = reader.nextLine();

            ClubMember dataObjekt = parseCsvLine(line);
            allClubmember.add(dataObjekt);
        }
    }
    private ClubMember parseCsvLine(String line) {
        try {
            String[] parts = line.split(";");

            ClubMember loadClubmemberData = new ClubMember();
            loadClubmemberData.setName(parts[0]);
            loadClubmemberData.setAge(parts[1]);
            loadClubmemberData.setActivityStatus(parts[2]);
            loadClubmemberData.setMembershipType(parts[3]);
            loadClubmemberData.setSwimType(parts[4]);
            loadClubmemberData.setMembershipNumber(parts[5]);
            return loadClubmemberData;

        } catch (NumberFormatException e ){
            System.out.println("Kan ikke loade data");
            return null;
        }
    }

    public int numberOfMembers() throws FileNotFoundException {

        Scanner reader = new Scanner(new File("data/clubmembersData.csv"));
        int memberShipNumber = 0;

        while (reader.hasNextLine()) {
            memberShipNumber++;
        }
        return memberShipNumber;






    }

}