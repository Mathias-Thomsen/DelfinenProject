package comparatorer;



import profiles.ClubMember;

import java.util.Comparator;

public class CompetitiveBreaststrokeSwimmers implements Comparator <ClubMember> {
    public int compare(ClubMember d1, ClubMember d2) {
        return Double.toString(d1.getBreaststrokeTime()).compareTo(Double.toString(d2.getBreaststrokeTime()));
    }
}
