package Controller;

import ClubMember.ClubMember;
import DataSouce.Database;
import DataSouce.Filehandler;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void createClubMember() {
        //Arrange
        Database database = new Database();
        //Act
        database.createClubMember("JN123523", "Christian", 22, "j", "senior", "exerciser");
        database.createClubMember("JN123523", "Christian", 22, "j", "senior", "exerciser");
        database.createClubMember("JN123523", "Christian", 22, "j", "senior", "exerciser");
        database.createClubMember("JN123523", "Christian", 22, "j", "senior", "exerciser");
        database.createClubMember("JN123523", "Christian", 22, "j", "senior", "exerciser");
        database.createClubMember("JN123523", "Christian", 22, "j", "senior", "exerciser");
        database.createClubMember("JN123523", "Christian", 22, "j", "senior", "exerciser");
        database.createClubMember("JN123523", "Christian", 22, "j", "senior", "exerciser");
        database.createClubMember("JN123523", "Christian", 22, "j", "senior", "exerciser");
        database.createClubMember("JN123523", "Christian", 22, "j", "senior", "exerciser");
        database.createClubMember("JN123523", "Christian", 22, "j", "senior", "exerciser");
        database.createClubMember("JN123523", "Christian", 22, "j", "senior", "exerciser");
        database.createClubMember("JN123523", "Christian", 22, "j", "senior", "exerciser");
        database.createClubMember("JN123523", "Christian", 22, "j", "senior", "exerciser");


        int actual = database.getClubMembers().size();
        int expected = 14;
        //Assert
        assertEquals(actual, expected);
    }

    @Test
    void getClubMembers() {
        //Arrange
        Database database = new Database();
        database.createClubMember("JN123523", "Christian", 22, "j", "senior", "exerciser");
        //Act
        database.getClubMembers();
        int actual = database.getClubMembers().size();
        int expected = 1;
        //Assert
        assertEquals(actual, expected);
    }

    @Test
    void deleteMember() {
        //Arrange
        Database database = new Database();
        Controller controller = new Controller();
        controller.createClubMember("SN132524", "Anton", 25, "false", "junior", "exerciser");
        String userDeleteMember = "Anton";
        ArrayList<ClubMember> searchDeleteMember = new ArrayList<>();
        //Act
        int index = 1;

        for (ClubMember deleteMember : controller.getClubMembers()){
            String nameInput = deleteMember.getName().toLowerCase();
            if (nameInput.contains(userDeleteMember.toLowerCase())){
                searchDeleteMember.add(deleteMember);
            }
        }
        String userDeleteNumberString = "1";
        int userDeleteNumberInt = Integer.parseInt(userDeleteNumberString);
        ClubMember deleteMember = searchDeleteMember.get(userDeleteNumberInt - 1);
        controller.deleteMember(deleteMember);

        int actual = controller.getClubMembers().size();
        int expected = 0;
        //Assert
        assertEquals(actual, expected);
    }

    @Test
    void saveData() throws FileNotFoundException {
        //Arrange
        Filehandler filehandler = new Filehandler();
        Database database = new Database();
        database.createClubMember("SN132524", "Anton", 25, "false", "junior", "exerciser");
        //Act
        filehandler.saveData(database.getClubMembers());
        System.out.println(database.getClubMembers());
        //Assert
        int actual = database.getClubMembers().size();
        int expected = 1;

        assertEquals(actual, expected);
    }

    @Test
    void loadData() throws FileNotFoundException {
        //Arrange
        Database database = new Database();
        Filehandler filehandler = new Filehandler();
        database.createClubMember("SN132524", "Anton", 25, "false", "junior", "exerciser");
        //Act
        System.out.println(database.getClubMembers());
        database.clearData();
        System.out.println(database.getClubMembers());
        filehandler.loadData(database.getClubMembers());
        System.out.println(database.getClubMembers());
        //Assert
        int actual = database.getClubMembers().size();
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    void getMembers() {
        //Arrange
        //Act
        //Assert
    }
}