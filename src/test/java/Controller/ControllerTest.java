package Controller;

import ClubMember.ClubMember;
import DataSouce.Database;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

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
    void saveData() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void loadData() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void getMembers() {
        //Arrange
        //Act
        //Assert
    }
}