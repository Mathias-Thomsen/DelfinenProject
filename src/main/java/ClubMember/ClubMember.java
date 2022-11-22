package ClubMember;

public class ClubMember {
    private int age;
    private String activityStatus;
    private String membershipType;
    private boolean juniorOrSenior;
    private String swimType;
    private int memberShipNumber;

    public ClubMember(){
    }

    public ClubMember(int age, String activityStatus, String membershipType, boolean juniorOrSenior, String swimType, int memberShipNumber){
        this.age = age;
        this.activityStatus = activityStatus;
        this.membershipType = membershipType;
        this.juniorOrSenior = juniorOrSenior;
        this.swimType = swimType;
        this.memberShipNumber = memberShipNumber;
    }

    public int getAge() {
        return age;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public boolean isJuniorOrSenior() {
        return juniorOrSenior;
    }

    public String getSwimType() {
        return swimType;
    }

    public int getMemberShipNumber() {
        return memberShipNumber;
    }

    @Override
    public String toString() {
        return "ClubMember{" +
                "age=" + age +
                ", activityStatus='" + activityStatus + '\'' +
                ", membershipType='" + membershipType + '\'' +
                ", juniorOrSenior=" + juniorOrSenior +
                ", swimType='" + swimType + '\'' +
                ", memberShipNumber=" + memberShipNumber +
                '}';
    }
}
