package blackjack.game;

import blackjack.game.enums.CardType;
import blackjack.game.enums.CardValues;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author erdmcagri
 */
public class Deck {

    public ArrayList<Card> card;

    public Deck() {
        this.card = new ArrayList<Card>();
    }

    public void createDeck() {
        for (CardType cardType : CardType.values()) {
            for (CardValues cardValue : CardValues.values()) {
                //System.out.println(cardType + " - " + cardValue);
                this.card.add(new Card(cardType, cardValue));
            }
        }
    }

    public void showCards() {
        //System.out.println(card.size());

        for (int i = 0; i < this.card.size(); i++) {
            System.out.print(this.card.get(i) + "\n");
        }
    }

    public void shuffle() {
        Collections.shuffle(this.card);
    }

    public void removaCard(int i) {
        this.card.remove(i);
    }

    public Card getCard(int i) {
        return this.card.get(i);
    }

    public void addCard(Card card) {
        this.card.add(card);
    }

    public void draw(Deck hitCard) {
        this.card.add(hitCard.getCard(0));
        hitCard.removaCard(0);
    }

    public int cardValues() {
        int totalValue = 0;
        int asCount = 0;

        for (Card card : this.card) {
            if (card.getCardValue().equals(CardValues.IKI)) {
                totalValue += 2;
            } else if (card.getCardValue().equals(CardValues.UC)) {
                totalValue += 3;
            } else if (card.getCardValue().equals(CardValues.DORT)) {
                totalValue += 4;
            } else if (card.getCardValue().equals(CardValues.BES)) {
                totalValue += 5;
            } else if (card.getCardValue().equals(CardValues.ALTI)) {
                totalValue += 6;
            } else if (card.getCardValue().equals(CardValues.YEDI)) {
                totalValue += 7;
            } else if (card.getCardValue().equals(CardValues.SEKIZ)) {
                totalValue += 8;
            } else if (card.getCardValue().equals(CardValues.DOKUZ)) {
                totalValue += 9;
            } else if (card.getCardValue().equals(CardValues.ON)) {
                totalValue += 10;
            } else if (card.getCardValue().equals(CardValues.VALE)) {
                totalValue += 10;
            } else if (card.getCardValue().equals(CardValues.KIZ)) {
                totalValue += 10;
            } else if (card.getCardValue().equals(CardValues.PAPAZ)) {
                totalValue += 10;
            } else if (card.getCardValue().equals(CardValues.AS)) {
                asCount += 1;
            }
        }

        for (int i = 0; i < asCount; i++) {
            if (totalValue > 10) {
                totalValue += 1;
            } else {
                totalValue += 11;
            }
        }

        return totalValue;

    }

    public int deckSize() {
        return this.card.size();
    }

}
