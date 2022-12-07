package Controller;

import Competitive.Competitive;
import DataSource.Database;
import DataSource.Filehandler;
import Profiles.ClubMember;
import Financials.Financials;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Controller {
    Competitive competitive = new Competitive();
    Database database = new Database();
    Filehandler filehandler = new Filehandler();
    Financials financials = new Financials();


    public void createClubMember(String name, int age, boolean activityStatus, String swimType){
        database.createClubMember( name, age, activityStatus, swimType);
    }
    public void createCoach(String name, int age){
        database.createCoach(name, age);
    }


    public ArrayList<ClubMember> getClubMembers(){
        return database.getClubMembers();
    }
    public void deleteMember(ClubMember deleteMember){
        database.deleteMember(deleteMember);
    }

    public void saveData(){
        try {
            filehandler.saveData(database.getClubMembers());
        } catch (FileNotFoundException e) {
            System.out.println("fail");
        }
    }

    public void saveDataCoach(){
        try {
            filehandler.saveCoachData(database.getCoaches());
        } catch (FileNotFoundException e) {
            System.out.println("fail");
        }
    }

    public void saveCompetitiveData(){
        try {
            filehandler.saveCompetitiveData(database.getCompetitors());
        } catch (FileNotFoundException e) {
            System.out.println("fail");
        }
    }

    public void loadDataCoach(){
        try {
            database.clearDataCoach();
            filehandler.loadCoachData(database.getCoaches());
        } catch (FileNotFoundException e) {
            System.out.println("fail");
        }
    }
    public void loadData(){
        try {
            database.clearDataMember();
            filehandler.loadData(database.getClubMembers());
        } catch (FileNotFoundException e) {
            System.out.println("fail");
        }
    }
    public void loadCompetitiveData(){
        try {
            database.clearCompetitive();
            filehandler.loadCompetitiveData(database.getCompetitors());
        } catch (FileNotFoundException e) {
            System.out.println("fail");
        }
    }

    public ArrayList<ClubMember> getMembers() {
        return database.getClubMembers();
    }

    public ArrayList<Competitive> getCompetitors(){
        return database.getCompetitors();
    }



    public ArrayList<ClubMember> findMember(String searchTerm) {
        return database.findMember(searchTerm);
    }


    public void junoirOrsenoir() {
        database.juniorOrSenior();
    }

    public void teamName(){
        database.teamName();
    }


    public void setClubMemberNumber(){
        database.setClubMemberNumber();
    }

    public void setCoachNumber(){
        database.setCoachNumber();
    }


    public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }



    //________________Financials______________________

    public void getCreatePayment() {
        database.createSubscriptionInDatabase();
    }


    public void setTotaleIncome() {
        financials.setTotalIncome(database.getTotalIncome());

    }

    public int getTotalIncome() {
        return financials.getTotalIncome();
    }

    public int getTotalSeniorMembers() {
        return database.getTotalSeniorMembers();
    }

    public int getTotalJuniorMembers() {
        return database.getTotalJuniorMembers();
    }

    public int getTotalSeniorPlusMembers() {
        return database.getTotalSeniorPlusMembers();
    }

    public int getTotalPassiveMembers() {
        return database.getTotalPassiveMembers();
    }

    public void getRandomPay(){
        database.getRandomPay();
    }

    public int getUnpaidAmount(){
        return database.getUnpaidAmount();
    }

    public int getTotalAmount(){
        return database.getTotalAmount();
    }

    public ArrayList<ClubMember> getUndpaidMembers() {
        return database.getUnpaidMember();
    }





    //___________Competitive_________________

    public void createCompetitive(String membershipNumber, String name, boolean isCrawl, double crawlTime, boolean isBackCrawl, double backCrawlTime, boolean isButterfly, double butterflyTime, boolean isBreaststroke, double breaststrokeTime){
        database.createCompetitive(membershipNumber, name, isCrawl, crawlTime, isBackCrawl, backCrawlTime, isButterfly, butterflyTime, isBreaststroke, breaststrokeTime);
    }

    public void setCrawl(){
        competitive.setCrawl(true);
    }

    public void setBackCrawl(){
        competitive.setBackCrawl(true);
    }

    public void setButterfly(){
        competitive.setButterfly(true);
    }

    public void setBreaststroke(){
        competitive.setBreaststroke(true);
    }

    public boolean isCrawl(){
        return competitive.isCrawl();
    }

    public boolean isBackCrawl(){
        return competitive.isBackCrawl();
    }

    public boolean isButterfly(){
        return competitive.isButterfly();
    }

    public boolean isBreaststroke(){
        return competitive.isBreaststroke();
    }


















}

