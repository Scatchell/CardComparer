package cardcomparer.repository;

import java.util.List;

import cardcomparer.domain.Card;

public interface CardDao {
	public List<Card> getCardList();
	
	public void addCard(Card card);
}
