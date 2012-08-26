package cardcomparer.repository;

import java.util.ArrayList;
import java.util.List;

import cardcomparer.domain.Card;

public class InMemoryCardDao implements CardDao {

	List<Card> cards = new ArrayList<Card>();
	
	public List<Card> getCardList() {
		return cards;
	}

	public void addCard(Card card) {
		cards.add(card);
	}
	
}
