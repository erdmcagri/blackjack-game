package blackjack.game;

import blackjack.game.enums.CardType;
import blackjack.game.enums.CardValues;

/**
 *
 * @author erdmcagri
 */
public class Card {

    public CardType cardType;
    public CardValues cardValue;

    public Card(CardType cardType, CardValues cardValue) {
        this.cardType = cardType;
        this.cardValue = cardValue;
    }

    public String toString() {
        return this.cardType.toString() + " " + this.cardValue.toString();
    }

    public CardValues getCardValue() {
        return this.cardValue;
    }

}
