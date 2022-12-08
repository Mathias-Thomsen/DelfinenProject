package profiles;

public class ClubMember {
    private int membershipNumber;
    private String name;
    private int age;
    private boolean active;
    private boolean isSenior;
    private String swimType;
    private int payment;
    private boolean randomPay;
    private String teamName;

    private boolean isCrawl;
    private double crawlTime;
    private boolean isBackCrawl;
    private double backCrawlTime;
    private boolean isButterfly;
    private double butterflyTime;
    private boolean isBreaststroke;
    private double breaststrokeTime;



    public ClubMember(){

    }

    public ClubMember(int membershipNumber, String name, int age, boolean active, String swimType,  boolean isCrawl, double crawlTime, boolean isBackCrawl, double backCrawlTime, boolean isButterfly, double butterflyTime, boolean isBreaststroke, double breaststrokeTime) {
        this.membershipNumber = membershipNumber;
        this.name = name;
        this.age = age;
        this.active = active;
        this.swimType = swimType;
        this.isCrawl = isCrawl;
        this.crawlTime = crawlTime;
        this.isBackCrawl = isBackCrawl;
        this.backCrawlTime = backCrawlTime;
        this.isButterfly = isButterfly;
        this.butterflyTime = butterflyTime;
        this.isBreaststroke = isBreaststroke;
        this.breaststrokeTime = breaststrokeTime;
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


    public boolean isSenior() {
        return isSenior;
    }
    public void setSenior(boolean senior) {
        this.isSenior = senior;
    }

    public String getSwimType() {
        return swimType;
    }
    public void setSwimType(String swimType) {
        this.swimType = swimType;
    }


    public int getMembershipNumber() {
        return membershipNumber;
    }
    public void setMembershipNumber(int membershipNumber) {

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


    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public boolean isCrawl() {
        return isCrawl;
    }

    public void setCrawl(boolean crawl) {
        isCrawl = crawl;
    }

    public double getCrawlTime() {
        return crawlTime;
    }

    public void setCrawlTime(String crawlTime) {
        this.crawlTime = Double.parseDouble(crawlTime);
    }

    public boolean isBackCrawl() {
        return isBackCrawl;
    }

    public void setBackCrawl(boolean backCrawl) {
        isBackCrawl = backCrawl;
    }

    public double getBackCrawlTime() {
        return backCrawlTime;
    }

    public void setBackCrawlTime(String backCrawlTime) {
        this.backCrawlTime = Double.parseDouble(backCrawlTime);
    }

    public boolean isButterfly() {
        return isButterfly;
    }

    public void setButterfly(boolean butterfly) {
        isButterfly = butterfly;
    }

    public double getButterflyTime() {
        return butterflyTime;
    }

    public void setButterflyTime(String butterflyTime) {
        this.butterflyTime = Double.parseDouble(butterflyTime);
    }

    public boolean isBreaststroke() {
        return isBreaststroke;
    }

    public void setBreaststroke(boolean breaststroke) {
        isBreaststroke = breaststroke;
    }

    public double getBreaststrokeTime() {
        return breaststrokeTime;
    }

    public void setBreaststrokeTime(String breaststrokeTime) {
        this.breaststrokeTime = Double.parseDouble(breaststrokeTime);
    }
}
