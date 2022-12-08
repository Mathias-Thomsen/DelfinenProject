package dataSource;

import comparatorer.CompetitiveBackCrawlTime;
import comparatorer.CompetitiveBreaststrokeSwimmers;
import comparatorer.CompetitiveButterflySwimmers;
import comparatorer.CompetitiveCrawlTime;
import profiles.ClubMember;
import subscription.Subscription;

import java.util.ArrayList;
import java.util.Random;
import profiles.Coach;

public class Database {
    private Subscription subscription = new Subscription();
    private ArrayList<ClubMember> clubMembers = new ArrayList<>();
    private ArrayList<Coach> coaches = new ArrayList<>();

    //________________Member______________________
    public void createClubMember(int membershipNumber, String name, int age, boolean activityStatus,  String swimType, boolean isCrawl, double crawlTime, boolean isBackCrawl, double backCrawlTime, boolean isButterfly, double butterflyTime, boolean isBreaststroke, double breaststrokeTime) {
        ClubMember clubMember = new ClubMember(membershipNumber, name, age, activityStatus, swimType, isCrawl,  crawlTime,  isBackCrawl,  backCrawlTime,  isButterfly,  butterflyTime,  isBreaststroke,  breaststrokeTime);
        clubMembers.add(clubMember);
    }
    public boolean deleteMember(ClubMember clubMember){
        boolean result = clubMembers.remove(clubMember);
        return result;
    }
    public ArrayList<ClubMember> getClubMembers() {
        return clubMembers;
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
    public void teamName(){
        for (ClubMember member : clubMembers){
            if (member.getSwimType().equals("Competition") && member.isSenior()){
                member.setTeamName("Team senior dolphins");
            } else if (member.getSwimType().equals("Competition") && !member.isSenior()) {
                member.setTeamName("Team junior dolphins");
            } else {
                member.setTeamName("No team");
            }
        }
    }
    public int getNextMemberNumber() {
        int number = clubMembers.size() + 1;
        return number;
    }


    //_______________Coach_________________________

    public void createCoach(String name, int age){
        Coach coach = new Coach(name, age);
        coaches.add(coach);
    }
    public ArrayList<Coach> getCoaches(){
        return coaches;
    }
    public void setCoachNumber() {
        int number = 1;

        for(Coach coach : coaches){
            coach.setEmployeeNumber("COACH" + number++);
        }
    }

    //___________________Clear arrayList data_________________
    public void clearDataMember() {
        clubMembers.clear();
    }
    public void clearDataCoach() {
        coaches.clear();
    }

    //__________________SORT METHODS__________________________

    public void sortCrawlTime(){
        clubMembers.sort(new CompetitiveCrawlTime());
    }
    public void sortBackCrawlTime(){
        clubMembers.sort(new CompetitiveBackCrawlTime());
    }
    public void sortButterflyTime(){
        clubMembers.sort(new CompetitiveButterflySwimmers());
    }
    public void sortBreaststrokeTime(){
        clubMembers.sort(new CompetitiveBreaststrokeSwimmers());
    }

    //___________________Finacials_____________________________

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
            if (members.isSenior()){
                totalSeniorMembers++;
            }
        }
        return totalSeniorMembers;
    }
    public int getTotalJuniorMembers() {
        int totalJuniorMembers = 0;

        for(ClubMember members : clubMembers) {
            if (!members.isSenior()){
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
