package ClubMember;

public class ClubMember {
    private String name;
    private int age;
    private String activityStatus;
    private String membershipType;
    private String swimType;
    private String membershipNumber;

    public ClubMember(){

    }
    public ClubMember(String membershipNumber, String name, int age, String activityStatus, String membershipType, String swimType) {
        this.membershipNumber = membershipNumber;
        this.name = name;
        this.age = age;
        this.activityStatus = activityStatus;
        this.membershipType = membershipType;
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

    public String isActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
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


    @Override
    public String toString() {
        return "ClubMember{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", activityStatus=" + activityStatus +
                ", membershipType=" + membershipType +
                ", swimType='" + swimType + '\'' +
                ", membershipNumber=" + membershipNumber +
                '}';
    }
}
