package cardcomparer.repository;

import java.util.List;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import cardcomparer.domain.Card;
import cardcomparer.repository.CardDao;

public class JdbcCardDaoTests extends AbstractTransactionalDataSourceSpringContextTests {

    private CardDao cardDao;
    

    @Override
    protected String[] getConfigLocations() {
        return new String[] {"classpath:test-context.xml"};
    }

    @Override
    protected void onSetUpInTransaction() throws Exception {
        super.deleteFromTables(new String[] {"cards"});
        super.executeSqlScript("file:db/load_data.sql", true);
    }

    public void testGetCardList() {
        
        List<Card> cards = cardDao.getCardList();
        
        assertEquals("wrong number of products?", 2, cards.size());
        
    }
    
    public void testAddCard() {
        
        Card testCard = new Card();
        testCard.setId(1);
        testCard.setTitle("test1");
        testCard.setDescription("test description1");
        
		cardDao.addCard(testCard);
        List<Card> cards = cardDao.getCardList();
        
        assertEquals("Wrong number of cards", 3, cards.size());
		assertEquals("Card not found", "test1", cards.get(2).getTitle());


    }

	public CardDao getCardDao() {
		return cardDao;
	}

	public void setCardDao(CardDao cardDao) {
		this.cardDao = cardDao;
	}

}