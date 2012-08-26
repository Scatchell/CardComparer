package cardcomparer.domain;

import java.util.Comparator;

public class CardComparator implements Comparator {
    
	public int compare(Object aObject, Object bObject) {
        Card a = (Card) aObject;
        Card b = (Card) bObject;

        if(b.getRating() > a.getRating()) {
            return 1;
        } else if(b.getRating() == a.getRating()) {
            return 0;
        } else {
            return -1;
        }
    }
}
