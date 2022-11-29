package DataSource;

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
            output.print(member.getMembershipNumber());
            output.print(";");
            output.print(member.getName());
            output.print(";");
            output.print(member.getAge());
            output.print(";");
            output.print(member.active());
            output.print(";");
            output.print(member.getSenior());
            output.print(";");
            output.print(member.isSwimType());
            output.print(";");
            output.print(member.getPayment());
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
            loadClubmemberData.setMembershipNumber(parts[0]);
            loadClubmemberData.setName(parts[1]);
            loadClubmemberData.setAge(parts[2]);
            loadClubmemberData.setActive(Boolean.parseBoolean(parts[3]));
            loadClubmemberData.setSenior(Boolean.parseBoolean(parts[4]));
            loadClubmemberData.setSwimType(parts[5]);
            loadClubmemberData.setPayment(Integer.parseInt(parts[6]));


            return loadClubmemberData;

        } catch (NumberFormatException e ){
            System.out.println("Kan ikke loade data");
            return null;
        }
    }

}