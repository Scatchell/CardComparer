package cardcomparer.service;

import java.util.List;

import cardcomparer.domain.Card;

public interface CardManager {
	
	public void addCard(Card card);
	
	public List<Card> getCards();

}
