package Controller;

import ClubMember.ClubMember;
import DataSource.Database;
import DataSource.Filehandler;
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



}

