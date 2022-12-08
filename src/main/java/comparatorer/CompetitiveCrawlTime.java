package comparatorer;

import competitive.Competitive;

import java.util.Comparator;

public class CompetitiveCrawlTime implements Comparator <Competitive> {
    public int compare (Competitive d1, Competitive d2){
        return Double.toString(d1.getCrawlTime()).compareTo(Double.toString(d2.getCrawlTime()));
    }
}
