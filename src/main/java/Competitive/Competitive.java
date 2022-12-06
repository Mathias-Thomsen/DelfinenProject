package Competitive;

public class Competitive {
    private boolean isCrawl;
    private boolean isBackCrawl;
    private boolean isButterfly;
    private boolean isBreaststroke;
     private String getTime;

    public Competitive(){
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


}
