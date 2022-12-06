package Controller;

import Profiles.ClubMember;
import DataSource.Database;
import DataSource.Filehandler;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void createClubMember() {
        //Arrange
        Database database = new Database();
        //Act
        database.createClubMember("Christian", 22, true, "exerciser");
        database.createClubMember("Christian", 22, false, "exerciser");
        database.createClubMember("Christian", 22, true, "exerciser");
        database.createClubMember("Christian", 22, true, "exerciser");
        database.createClubMember("Christian", 22, true, "exerciser");
        database.createClubMember("Christian", 22, true, "exerciser");
        database.createClubMember("Christian", 22, false, "exerciser");
        database.createClubMember("Christian", 22, false, "exerciser");
        database.createClubMember("Christian", 22, false, "exerciser");
        database.createClubMember("Christian", 22, false, "exerciser");
        database.createClubMember("Christian", 22, false, "exerciser");
        database.createClubMember("Christian", 22, false, "exerciser");
        database.createClubMember("Christian", 22, false, "exerciser");
        database.createClubMember("Christian", 22, false, "exerciser");



        int actual = database.getClubMembers().size();
        int expected = 14;
        //Assert
        assertEquals(actual, expected);
    }

    @Test
    void getClubMembers() {
        //Arrange
        Database database = new Database();
        database.createClubMember("Christian", 22, false, "exerciser");
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
        database.createClubMember("Christian", 22, true, "exerciser");
        String userDeleteMember = "Christian";
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
        database.createClubMember("Christian", 22, false, "exerciser");
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
        database.createClubMember("Christian", 22, true, "exerciser");
        //Act
        System.out.println(database.getClubMembers());
        database.clearDataMember();
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

    @Test
    void findMember() {
    }

    @Test
    void junoirOrsenoir() {
    }

    @Test
    void setClubMemberNumber() {
    }

    @Test
    void calculateAge() {
        // setup
        Controller controller = new Controller();
        LocalDate birthDate = LocalDate.of(2002, 06, 18);
        // exercise
        int actual = controller.calculateAge(birthDate, LocalDate.now());
        // assert
        System.out.println(actual);
        assertEquals(20, actual);
    }
}