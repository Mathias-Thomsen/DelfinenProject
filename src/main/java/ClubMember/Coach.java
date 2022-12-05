package ClubMember;

public class Coach {
    private String employeeNumber;
    private String name;
    private int age;
    private int team;
    private int coachTime;

    public Coach(){

    }

    public Coach(String employeeNumber, String name, int age, int team, int coachTime) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.age = age;
        this.team = team;
        this.coachTime = coachTime;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
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

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public int getCoachTime() {
        return coachTime;
    }

    public void setCoachTime(int coachTime) {
        this.coachTime = coachTime;
    }
}
