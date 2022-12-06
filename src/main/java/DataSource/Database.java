package DataSource;

import ClubMember.ClubMember;
import Financials.Financials;
import Subscription.Subscription;

import java.util.ArrayList;
import java.util.Random;
import ClubMember.Coach;


public class Database {
    Subscription subscription = new Subscription();
    Financials financials = new Financials();
    public ArrayList<ClubMember> clubMembers = new ArrayList<>();
    public ArrayList<Coach> coaches = new ArrayList<>();


    public void createClubMember(String name, int age, boolean activityStatus,  String swimType) {
        ClubMember clubMember = new ClubMember(name, age, activityStatus, swimType);
        clubMembers.add(clubMember);
    }

    public void createCoach(String name, int age){
        Coach coach = new Coach(name, age);
        coaches.add(coach);

    }

    public boolean deleteMember(ClubMember clubMember){
        boolean result = clubMembers.remove(clubMember);
        return result;
    }

    public ArrayList<ClubMember> getClubMembers() {
        return clubMembers;
    }

    public ArrayList<Coach> getCoaches(){
        return coaches;
    }

    public void clearDataMember() {
        clubMembers.clear();

    }

    public void clearDataCoach() {
        coaches.clear();
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
                member.setSenior(true);
            } else if (member.getAge() < 18) {
                member.setSenior(false);
            }
        }
    }

    public void setClubMemberNumber() {

        int number = 1;

        for (ClubMember member : clubMembers) {
            if(member.getSenior()) {
                member.setMembershipNumber("S" + number++);
            }else {
                member.setMembershipNumber("J" + number++);
            }
        }
    }

    public void createSubscriptionInDatabase(){
        for (ClubMember member : clubMembers ) {
            if (!member.active()) {
                member.setPayment(subscription.getPASSIVE_PAY());
            } else if (member.getAge() >= 18 && member.getAge() <= 60) {
                member.setPayment(subscription.getSENIOR_PAY());
            } else if (member.getAge() > 60) {
                member.setPayment(subscription.getSENIOR_PLUS_PAY());
            } else {
                member.setPayment(subscription.getJUNIOR_PAY());
            }
        }
    }

    public int getTotalIncome() {
        int total = 0;
        for (ClubMember member : clubMembers) {
            total += member.getPayment();
        }
        return total;
    }

    public int getTotalSeniorMembers() {
        int totalSeniorMembers = 0;

        for(ClubMember members : clubMembers) {
            if (members.getSenior()){
                totalSeniorMembers++;
            }
        }
        return totalSeniorMembers;
    }

    public int getTotalJuniorMembers() {
        int totalJuniorMembers = 0;

        for(ClubMember members : clubMembers) {
            if (!members.getSenior()){
                totalJuniorMembers++;
            }
        }
        return totalJuniorMembers;
    }


    public int getTotalSeniorPlusMembers() {
        int totalSeniorPlusMembers = 0;
        for(ClubMember members : clubMembers) {
            if (members.getAge() >= 60){
                totalSeniorPlusMembers++;
            }
        }
        return totalSeniorPlusMembers;

    }

    public int getTotalPassiveMembers() {
        int totalPassiveMembers = 0;
        for(ClubMember members : clubMembers) {
            if (!members.active()){
                totalPassiveMembers++;
            }
        }
        return totalPassiveMembers;
    }

    public void getRandomPay(){
        Random random = new Random();
        for (ClubMember member : clubMembers){
                member.setRandomPay(random.nextBoolean());

        }
    }

    public int getTotalRandomPay(){
        int totalRandomPay = 0;
        for (ClubMember member : clubMembers){
            if (!member.isRandomPay()){
                totalRandomPay++;
            }
        }
        return totalRandomPay;
    }

    public int getUnpaidAmount() {
        int total = 0;
        for (ClubMember member : clubMembers) {
            if (!member.isRandomPay()) {
                total += member.getPayment();
            }
        }
        return total;
    }

    public int getTotalAmount(){
        int total = 0;
        for (ClubMember member : clubMembers){
            if (member.isRandomPay()){
                total += member.getPayment();
            }
        }
        return total;
    }

    public ArrayList<ClubMember> getUnpaidMember(){
        ArrayList<ClubMember> searchResult = new ArrayList<>();
        for (ClubMember member : clubMembers) {
            if (!member.isRandomPay()) {
                searchResult.add(member);
            }
        }return searchResult;

    }

}
