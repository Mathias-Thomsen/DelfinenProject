package delfinePackage.DataSource;

import dataSource.Database;
import profiles.ClubMember;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

class DatabaseTest {

    @Test
    void createClubMember() {
    }

    @Test
    void deleteMember() {
    }

    @Test
    void getClubMembers() {
    }

    @Test
    void clearData() {
    }

    @Test
    void findMember() {
    }

    @Test
    void juniorOrSenior() {
    }

    @Test
    void setClubMemberNumber() {
    }

    @Test
    void createSubscriptionInDatabase() {
    }

    @Test
    void getTotalIncome() {
    }

    @Test
    void getTotalSeniorMembers() {
    }

    @Test
    void getTotalJuniorMembers() {
    }

    @Test
    void getTotalSeniorPlusMembers() {
    }

    @Test
    void getTotalPassiveMembers() {
    }

    @Test
    void getRandomPay() {
        Database database = new Database();
        ClubMember clubMember = new ClubMember();
        ArrayList<ClubMember> clubMembers = new ArrayList<>();
        Random random = new Random();
        boolean randomPay;
        for (ClubMember members : clubMembers){
            randomPay = random.nextBoolean();
            members.setRandomPay(randomPay);
            System.out.println(randomPay);
        }
    }
}