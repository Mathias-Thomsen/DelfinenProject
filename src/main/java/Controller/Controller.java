package Controller;

import DataSouce.Database;
import DataSouce.Filehandler;

import java.io.FileNotFoundException;

public class Controller {
    Database database = new Database();
    Filehandler filehandler = new Filehandler();
    public void createClubMember(String name, int age, boolean activityStatus, String membershipType, String swimType, int membershipNumber){
    database.createClubMember(name, age, activityStatus, membershipType, swimType, membershipNumber);
    }

    public void saveData(){
        try {
            filehandler.saveData(database.getClubmembers());
        } catch (FileNotFoundException e) {
            System.out.println("fail");
        }
    }
    public void loadData(){
        try {
            database.clearData();
            filehandler.loadData(database.getClubmembers());
        } catch (FileNotFoundException e) {
            System.out.println("fail");
        }
    }
}
