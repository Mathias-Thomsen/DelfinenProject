package ClubMember;

public class ClubMember {
    private String name;
    private int age;
    private String activityStatus;
    private String membershipType;
    private String swimType;

    public ClubMember(String name, int age, String activityStatus, String membershipType, String swimType){
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
    public void setAge(int age) {
        this.age = age;
    }
    public String getActivityStatus() {
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
    public String getSwimType() {
        return swimType;
    }
    public void setSwimType(String swimType) {
        this.swimType = swimType;
    }
}
