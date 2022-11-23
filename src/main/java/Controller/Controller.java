package Controller;

import ClubMember.ClubMember;
import DataSouce.Database;
import DataSouce.Filehandler;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {
    Database database = new Database();
    Filehandler filehandler = new Filehandler();
    public void createClubMember(String name, int age, boolean activityStatus, String membershipType, String swimType, int membershipNumber){
    database.createClubMember(name, age, activityStatus, membershipType, swimType, membershipNumber);
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
}
