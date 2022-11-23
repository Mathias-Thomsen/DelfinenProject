package DataSouce;

import ClubMember.ClubMember;

import java.util.ArrayList;

public class Database {
    private boolean change = false;
    public ArrayList<ClubMember> clubMembers = new ArrayList<>();


    public void createClubMember(String name, int age, boolean activityStatus, String membershipType, String swimType, int membershipNumber) {
        ClubMember clubMember = new ClubMember(name, age, activityStatus, membershipType, swimType, membershipNumber);
        clubMembers.add(clubMember);

        change = true; // To the save method, so we only save to the txt file if a change has been made.

    }

    public ArrayList<ClubMember> getClubmembers() {
        return clubMembers;
    }

    public void clearData() {
        clubMembers.clear();

    }
}
