package cardcomparer.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import cardcomparer.domain.Card;

public class JdbcCardDao extends SimpleJdbcDaoSupport implements CardDao {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());


    public List<Card> getCardList() {
        logger.info("Getting cards!");
        List<Card> cards = getSimpleJdbcTemplate().query("select * from cards", new CardMapper());
        return cards;
    }

    public void addCard(Card card) {
        logger.info("Saving product: " + card.getTitle());
        
        int count = getSimpleJdbcTemplate().update(
            "INSERT INTO cards (title, description) VALUES (:title, :description)",
            new MapSqlParameterSource().addValue("title", card.getTitle()).addValue("description", card.getDescription()));
                
        logger.info("Rows affected: " + count);
    }
    
    private static class CardMapper implements ParameterizedRowMapper<Card> {

        public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
            Card card = new Card();
            card.setId(rs.getInt("id"));
            card.setTitle(rs.getString("title"));
            card.setDescription(rs.getString("description"));
            return card;
        }

    }

}