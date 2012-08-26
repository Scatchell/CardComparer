package cardcomparer.web;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import cardcomparer.domain.Card;
import cardcomparer.repository.InMemoryCardDao;
import cardcomparer.repository.JdbcCardDao;
import cardcomparer.service.SimpleCardManager;

public class CardControllerTests {
	
	@Test
	public void testHandleRequestView() throws ServletException, IOException {
		CardController cardController = new CardController();
		SimpleCardManager cardManager = new SimpleCardManager();
		InMemoryCardDao inMemoryCardDao = new InMemoryCardDao();
		cardManager.setCardDao(inMemoryCardDao);
		
		Card card = new Card("Test");
		cardManager.addCard(card);
		cardController.setCardManager(cardManager);
		
		ModelAndView modelAndView = cardController.handleRequest(null, null);
		
		Map modelMap = (Map) modelAndView.getModel().get("model");
		
		assertEquals(Arrays.asList(card), modelMap.get("cards"));
	}
}
