package Controller;

import ClubMember.ClubMember;
import DataSource.Database;
import DataSource.Filehandler;
import Financials.Financials;
import Subscription.Subscription;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Controller {
    Database database = new Database();
    Filehandler filehandler = new Filehandler();
    ClubMember clubMember = new ClubMember();
    Subscription subscription = new Subscription();
    Financials financials = new Financials();
    public void createClubMember(String name, int age, boolean activityStatus, String swimType){
        database.createClubMember( name, age, activityStatus, swimType);
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
    public void loadData(){
        try {
            database.clearData();
            filehandler.loadData(database.getClubMembers());
        } catch (FileNotFoundException e) {
            System.out.println("fail");
        }
    }

    public ArrayList<ClubMember> getMembers() {
        return database.getClubMembers();
    }



    public ArrayList<ClubMember> findMember(String searchTerm) {
        return database.findMember(searchTerm);
    }


    public void junoirOrsenoir() {
        database.juniorOrSenior();
    }

    public void setClubMemberNumber(){
        database.setClubMemberNumber();
    }


    public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

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

    public void setRandomPay(boolean randomPay){
        clubMember.setRandomPay(randomPay);
    }

    public int getTotalRandomPay(){
        return database.getTotalRandomPay();
    }

    public int getUnpaidMember(){
        return database.getUnpaidMember();
    }

    public int getTotalAmount(){
        return database.getTotalAmount();
    }

















}

