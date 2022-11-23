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
        controller.createClubMember("JN123523", "Christian", 22, "j", "senior", "exerciser");
        controller.createClubMember("SN132524", "Anton", 25, "false", "junior", "exerciser");
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
        controller.createClubMember("JN123523", "Christian", 22, "j", "senior", "exerciser");
        controller.createClubMember("SN132524", "Anton", 25, "false", "junior", "exerciser");

        for (ClubMember controllerr : controller.getMembers()) {
            System.out.println("------------------\n"
                    + "Membership Number:......... " + controllerr.getMembershipNumber() + "\n"
                    + "Name:...................... " + controllerr.getName() + "\n"
                    + "Age:....................... " + controllerr.getAge() + "\n"
                    + "Active Status:............. " + controllerr.isActivityStatus() + "\n"
                    + "Junior or senior:.......... " + controllerr.isSwimType() + "\n"
                    + "Exerciser or competition:.. " + controllerr.getMembershipType());
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
        controller.createClubMember("SN132524", "Anton", 25, "false", "junior", "exerciser");
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
                System.out.println("You have selected: " + deleteMember.getName());
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
    void exitProgram() {
    }
}