package Controller;

import ClubMember.ClubMember;
import DataSouce.Database;
import DataSouce.Filehandler;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {
    Database database = new Database();
    Filehandler filehandler = new Filehandler();
    ClubMember clubMember = new ClubMember();
    public void createClubMember(String membershipNumber, String name, int age, String activityStatus, String membershipType, String swimType){
        database.createClubMember(membershipNumber, name, age, activityStatus, membershipType, swimType);
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

    public int getSizeOfDatabase() {
        int sizeOfDatabase = database.getClubMembers().size();
        return sizeOfDatabase + 1;

    }


    public ArrayList<ClubMember> findMember(String searchTerm) {
        return database.findMember(searchTerm);
    }



}

