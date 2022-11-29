package DataSource;

import ClubMember.ClubMember;
import Subscription.Subscription;

import java.util.ArrayList;

public class Database {
    Subscription subscription = new Subscription();
    public ArrayList<ClubMember> clubMembers = new ArrayList<>();


    public void createClubMember(String name, int age, boolean activityStatus,  String swimType) {
        ClubMember clubMember = new ClubMember(name, age, activityStatus, swimType);
        clubMembers.add(clubMember);


    }

    public boolean deleteMember(ClubMember clubMember){
        boolean result = clubMembers.remove(clubMember);
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



    public void juniorOrSenior(){
        for (ClubMember member : clubMembers) {
            if (member.getAge() >= 18) {
                member.setMembershipType("Senior");
            } else if (member.getAge() < 18) {
                member.setMembershipType("Junior");
            }
        }
    }

    public void setClubMemberNumber() {

        int number = 1;

        for (ClubMember member : clubMembers) {
            if(member.getMembershipType() == "Senior") {
                member.setMembershipNumber("S" + number++);
            }else {
                member.setMembershipNumber("J" + number++);
            }
        }
    }

    public void createSubscriptionInDatabase(){
        for (ClubMember member : clubMembers) {
            if (!member.isActivityStatus()) {
                member.setPay(subscription.getPASSIVE_PAY());
            } else if (member.getAge() >= 18 && member.getAge() <= 60) {
                member.setPay(subscription.getSENIOR_PAY());
            } else if (member.getAge() > 60) {
                member.setPay(subscription.getSENIOR_PLUS_PAY());
            } else {
                member.setPay(subscription.getJUNIOR_PAY());
            }
        }
    }














}
