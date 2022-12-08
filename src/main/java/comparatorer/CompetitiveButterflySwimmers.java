package comparatorer;

import competitive.Competitive;

import java.util.Comparator;

public class CompetitiveButterflySwimmers implements Comparator <Competitive> {
    public int compare(Competitive d1, Competitive d2) {
        return Double.toString(d1.getButterflyTime()).compareTo(Double.toString(d2.getButterflyTime()));
    }
}