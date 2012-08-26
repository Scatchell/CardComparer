package cardcomparer.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cardcomparer.service.CardManager;
import cardcomparer.service.SimpleCardManager;

public class CardController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());
    
    private CardManager cardManager = new SimpleCardManager();
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("Returning card view");
        
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("time", (new Date()).toString());
        model.put("cards", this.cardManager.getCards());
        
		return new ModelAndView("cards", "model", model);
		
    }

	public void setCardManager(CardManager cardManager) {
		this.cardManager = cardManager;
	}
}