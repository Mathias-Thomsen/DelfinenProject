package Controller;

import DataSouce.Database;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

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
        //Act
        //Assert
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