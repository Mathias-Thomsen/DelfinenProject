package controller;


import dataSource.Database;
import dataSource.Filehandler;
import profiles.ClubMember;
import financials.Financials;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Controller {
    Database database = new Database();
    Filehandler filehandler = new Filehandler();
    Financials financials = new Financials();
    public void startProgram(){
        loadData();
        loadDataCoach();
    }

    public void createClubMember(int membershipNumber, String name, int age, boolean active, String swimType, boolean isCrawl, double crawlTime, boolean isBackCrawl, double backCrawlTime, boolean isButterfly, double butterflyTime, boolean isBreaststroke, double breaststrokeTime){
        database.createClubMember(membershipNumber, name, age, active, swimType, isCrawl,  crawlTime,  isBackCrawl,  backCrawlTime,  isButterfly,  butterflyTime,  isBreaststroke,  breaststrokeTime);
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

    public ArrayList<ClubMember> getMembers() {
        return database.getClubMembers();
    }


    //SORT METHODS
    public void sortCrawlTime(){
        database.sortCrawlTime();
    }

    public void sortBackCrawlTime(){
        database.sortBackCrawlTime();
    }

    public void sortButterflyTime(){
        database.sortButterflyTime();
    }

    public void sortBreastStrokeTime(){
        database.sortBreaststrokeTime();
    }

    //-------------



    public ArrayList<ClubMember> findMember(String searchTerm) {
        return database.findMember(searchTerm);
    }


    public void junoirOrsenoir() {
        database.juniorOrSenior();
    }

    public void teamName(){
        database.teamName();
    }




    public int getNextMemberNumber(){
        return database.getNextMemberNumber();

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




}

