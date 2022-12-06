package Profiles;

public class ClubMember {
    private String name;
    private int age;
    private boolean active;
    private boolean isSenior;
    private String swimType;
    private String membershipNumber;
    private int payment;
    private boolean randomPay;


    public ClubMember(){

    }
    public ClubMember(String membershipNumber, String name, int age, boolean active, boolean membershipType, String swimType, int payment, boolean randomPay) {
        this.membershipNumber = membershipNumber;
        this.name = name;
        this.age = age;
        this.active = active;
        this.isSenior = membershipType;
        this.swimType = swimType;
        this.payment = payment;
        this.randomPay = randomPay;

    }
    public ClubMember(String name, int age, boolean active, String swimType) {
        this.name = name;
        this.age = age;
        this.active = active;
        this.swimType = swimType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


    public void setAge(String age) {
        this.age = Integer.parseInt(age);
    }

    public boolean active() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getSenior() {
        return isSenior;
    }

    public void setSenior(boolean senior) {
        this.isSenior = senior;
    }

    public String isSwimType() {
        return swimType;
    }

    public void setSwimType(String swimType) {
        this.swimType = swimType;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(String membershipNumber) {

        this.membershipNumber = membershipNumber;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public boolean isRandomPay() {
        return randomPay;
    }

    public void setRandomPay(boolean randomPay) {
        this.randomPay = randomPay;
    }
}
