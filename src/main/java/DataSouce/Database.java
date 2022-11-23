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

    public boolean deleteMember(ClubMember clubMember){
        boolean result = clubMembers.remove(clubMember);

        change = true;

        return result;
    }

    public ArrayList<ClubMember> getClubMembers() {
        return clubMembers;
    }

    public void clearData() {
        clubMembers.clear();

    }
}
