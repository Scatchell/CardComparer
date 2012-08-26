package cardcomparer.domain;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: anthony
 * Date: 19/4/12
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Card implements Comparable, Serializable {
    private String title;
    private String description;
	private double rating;
	private int id;
    boolean lost;

    public Card() {
    	
	}

	public boolean hasLost() {
        return lost;
    }

    public Card(String title) {
        this.setTitle(title);
        this.description = "";
        this.rating = 0;
        this.lost = false;
    }
        
    @Override
    public String toString() {
        return "Card Title: " + this.getTitle() + "; Rating: " + this.rating + (this.description != "" ? "; Description: " + this.description : "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (getTitle() != null ? !getTitle().equals(card.getTitle()) : card.getTitle() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getTitle() != null ? getTitle().hashCode() : 0;
    }

    public void selectCard() {
        this.rating++;
    }
    
    public void rateUp() {
        this.rating += 1;
    }

    public void rateAgainstOther(boolean win, Card otherCard) {
        double otherRating = otherCard.rating;
        int status;

        if (win) {
            status = 1;
        } else {
            status = 2;
        }

        double[] test = calcElo(status, this.rating, otherRating);
        System.out.println(this.rating + " : " + test[0] + " (winner) and " + otherRating + " : " + test[1]);
    }

    //   status: 0 = draw, 1 = player A won, 2 = player B won
    private double[] calcElo(int status, double RA, double RB) {
        double QA = Math.pow(10, RA/400);
        double QB = Math.pow(10, RB/400);

        // set the desired k factor  
        double k = 32;

        double EA = QA / (QA + QB);
        double EB = QB / (QA + QB);

        double SA = 2.5; // draw
        double SB = 2.5; // draw
        if (status == 1) {
            SA = 1;
            SB = 0;
        } else if (status == 2) {
            SA = 0;
            SB = 1;
        }

        double[] res = new double[2];
        res[0] = (k * (SA - EA));
        res[1] = (k * (SB - EB));
        return res;
    }
    
    public double getRating() {
        return this.rating;
    }

    public void clearFlags() {
        this.lost = false;
    }

    public void markLoser() {
        this.lost = true;
    }
	
	public int compareTo(Object o) {
        Card card = (Card) o;

        if (this.rating > card.rating)
            return 1;
        else if (this.rating < card.rating)
            return -1;
        else
            return 0;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

