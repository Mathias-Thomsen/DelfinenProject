package Competitive;

public class Competitive {
    private boolean isCrawl;
    private double crawlTime;
    private boolean isBackCrawl;
    private double backCrawlTime;
    private boolean isButterfly;
    private double butterflyTime;
    private boolean isBreaststroke;
    private double breaststrokeTime;
    private String name;
    private String membershipNumber;
    private String getTime;
    private String teamName;

    public Competitive(){
    }

    public Competitive(String membershipNumber, String name, boolean isCrawl, double crawlTime, boolean isBackCrawl, double backCrawlTime, boolean isButterfly, double butterflyTime, boolean isBreaststroke, double breaststrokeTime, String teamName){
        this.membershipNumber = membershipNumber;
        this.name = name;
        this.isCrawl = isCrawl;
        this.crawlTime = crawlTime;
        this.isBackCrawl = isBackCrawl;
        this.backCrawlTime = backCrawlTime;
        this.isButterfly = isButterfly;
        this.butterflyTime = butterflyTime;
        this.isBreaststroke = isBreaststroke;
        this.breaststrokeTime = breaststrokeTime;
        this.teamName = teamName;
    }

    public Competitive(boolean isCrawl, boolean isBackCrawl, boolean isButterfly, boolean isBreaststroke){
        this.isCrawl = isCrawl;
        this.isBackCrawl = isBackCrawl;
        this.isButterfly = isButterfly;
        this.isBreaststroke = isBreaststroke;
    }

    public boolean isButterfly() {
        return isButterfly;
    }

    public void setButterfly(boolean butterfly) {
        isButterfly = butterfly;
    }

    public String getGetTime() {
        return getTime;
    }

    public void setGetTime(String getTime) {
        this.getTime = getTime;
    }


    public boolean isBackCrawl() {
        return isBackCrawl;
    }

    public void setBackCrawl(boolean backCrawl) {
        isBackCrawl = backCrawl;
    }

    public void setCrawl(boolean crawl) {
        isCrawl = crawl;
    }

    public void setBreaststroke(boolean breaststroke) {
        isBreaststroke = breaststroke;
    }

    public boolean isCrawl() {
        return isCrawl;
    }

    public boolean isBreaststroke() {
        return isBreaststroke;
    }

    public double getCrawlTime() {
        return crawlTime;
    }

    public void setCrawlTime(String crawlTime) {
        this.crawlTime = Double.parseDouble(crawlTime);
    }

    public double getBackCrawlTime() {
        return backCrawlTime;
    }

    public void setBackCrawlTime(String backCrawlTime) {
        this.backCrawlTime = Double.parseDouble(backCrawlTime);
    }

    public double getButterflyTime() {
        return butterflyTime;
    }

    public void setButterflyTime(String butterflyTime) {
        this.butterflyTime = Double.parseDouble(butterflyTime);
    }

    public double getBreaststrokeTime() {
        return breaststrokeTime;
    }

    public void setBreaststrokeTime(String breaststrokeTime) {
        this.breaststrokeTime = Double.parseDouble(breaststrokeTime);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(String membershipNumber) {
        this.membershipNumber = membershipNumber;
    }
}
