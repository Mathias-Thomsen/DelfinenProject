package DataSouce;

import ClubMember.ClubMember;

import java.util.ArrayList;

public class Database {
    private boolean change = false;
    public ArrayList<ClubMember> clubMembers = new ArrayList<>();


    public void createClubMember(String membershipNumber, String name, int age, String activityStatus, String membershipType, String swimType) {
        ClubMember clubMember = new ClubMember(membershipNumber,name, age, activityStatus, membershipType, swimType);
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

    public ArrayList<ClubMember> findMember(String searchTerm){
        ArrayList<ClubMember> searchResult = new ArrayList<>();
        for (ClubMember member : clubMembers) {
            if (member.getName().toLowerCase().contains(searchTerm)) {
                searchResult.add(member);
            }
        }return searchResult;

    }


}
