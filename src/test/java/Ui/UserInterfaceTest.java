package Ui;

import ClubMember.ClubMember;
import Controller.Controller;
import DataSouce.Database;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceTest {

    @Test
    void menu() {
    }

    @Test
    void clubManagerMenu() {
    }

    @Test
    void createMember() {
        //Arrange
        Database database = new Database();
        Controller controller = new Controller();
        //Act
        controller.createClubMember("Christian", 22, true, "senior", "exerciser", 132523);
        controller.createClubMember("Anton", 25, false, "junior", "exerciser", 132524);
        controller.getClubMembers();
        int actual = controller.getClubMembers().size();
        int expected = 2;
        //assert
        assertEquals(actual, expected);
    }

    @Test
    void showMenmbers() {
        //Arrange
        Database database = new Database();
        Controller controller = new Controller();
        //Act
        controller.createClubMember("Christian", 22, true, "senior", "exerciser", 132523);
        controller.createClubMember("Anton", 25, false, "junior", "exerciser", 132524);

        for (ClubMember controllerr : controller.getMembers()) {
            System.out.println("------------------\n"
                    + "Name:................. " + controllerr.getName() + "\n"
                    + "Age:.................. " + controllerr.getAge() + "\n"
                    + "activityStatus:....... " + controllerr.isActivityStatus() + "\n"
                    + "membershipType:....... " + controllerr.isSwimType() + "\n"
                    + "swimType:............. " + controllerr.getMembershipType() + "\n"
                    + "membershipNumber:..... " + controllerr.getMembershipNumber());
        }

        int actual = controller.getClubMembers().size();
        int expected = 2;

        assertEquals(actual, expected);

        //Assert
    }

    @Test
    void editMember() {
        //Arrange
        Database database = new Database();
        Controller controller = new Controller();
        ArrayList<ClubMember> searchEditResult = new ArrayList<>();

        //Act
        controller.createClubMember("Anton", 25, false, "junior", "exerciser", 132524);
        String userEditMember = "Anton";

        int index = 1;

        for (ClubMember editMember : controller.getMembers()) {
            String member = editMember.getName().toLowerCase();
            if (member.contains(userEditMember.toLowerCase())) {
                searchEditResult.add(editMember);
                System.out.println("Original name is: " + editMember.getName());

            }
        }

        String userEditNumberString = "1";
        int userEditNumberInteger = Integer.parseInt(userEditNumberString);
        ClubMember editMember = searchEditResult.get(userEditNumberInteger - 1);
        String newMemberName = "Phillip";
        editMember.setName(newMemberName);

        String actual = newMemberName;
        String expected = "Phillip";
        System.out.println("Changed name too: " + newMemberName);


        //Assert
        assertEquals(actual, expected);
    }

    @Test
    void deleteMember() {
    }

    @Test
    void exitProgram() {
    }
}