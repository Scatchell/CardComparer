package cardcomparer.service;

import java.util.List;

import cardcomparer.domain.Card;
import cardcomparer.repository.CardDao;
import cardcomparer.repository.JdbcCardDao;

public class SimpleCardManager implements CardManager {
	private CardDao cardDao;

	public void addCard(Card card) {
		getCardDao().addCard(card);
	}

	public List<Card> getCards() {
		return getCardDao().getCardList();
	}

	public CardDao getCardDao() {
		return cardDao;
	}

	public void setCardDao(CardDao cardDao) {
		this.cardDao = cardDao;
	}
	
	
}
