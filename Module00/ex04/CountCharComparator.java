package  ex04;

import java.util.Comparator;

public class CountCharComparator implements Comparator<ex04.Pair<Integer, Character> > {
    public int compare(ex04.Pair<Integer, Character> p1, ex04.Pair<Integer, Character> p2) {

        if (p1.getFirst().equals(p2.getFirst())) {
            return (p1.getSecond().compareTo(p2.getSecond()));
        }

        return (p2.getFirst().compareTo(p1.getFirst()));
    }
}
