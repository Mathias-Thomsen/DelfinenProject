package ClubMember;

public class ClubMember {
    private String name;
    private int age;
    private boolean active;
    private String membershipType;
    private String swimType;
    private String membershipNumber;

    public ClubMember(){

    }
    public ClubMember(String membershipNumber, String name, int age, boolean active, String membershipType, String swimType) {
        this.membershipNumber = membershipNumber;
        this.name = name;
        this.age = age;
        this.active = active;
        this.membershipType = membershipType;
        this.swimType = swimType;

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

    public boolean isActivityStatus() {
        return active;
    }

    public void setActivityStatus(boolean active) {
        this.active = active;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
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

}
