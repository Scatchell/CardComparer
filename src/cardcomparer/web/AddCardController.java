package cardcomparer.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import cardcomparer.domain.Card;
import cardcomparer.service.CardManager;
import cardcomparer.service.SimpleCardManager;

public class AddCardController extends SimpleFormController{
	private CardManager cardManager;
	
	public ModelAndView onSubmit(Object command) throws ServletException {
        Card card = (Card) command;
        
        logger.info("Adding card " + card.getTitle());

        getCardManager().addCard(card);

        logger.info("returning from addCard view to " + getSuccessView());

        return new ModelAndView(new RedirectView(getSuccessView()));
    }

    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
        Card card = new Card();
        card.setTitle("Title here");
        card.setDescription("Description here");
        return card;
    }

	public CardManager getCardManager() {
		return cardManager;
	}

	public void setCardManager(CardManager cardManager) {
		this.cardManager = cardManager;
	}
}
