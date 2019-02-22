package jp.co.systena.tigerscave.ShoppingApp.BlackJack;

import jp.co.systena.tigerscave.ShoppingApp.Card;
import jp.co.systena.tigerscave.ShoppingApp.Deck;
import lombok.val;

public class Dealer extends BlackJackActor {
    /**
     * constructor
     *
     * @param deck deck
     */
    Dealer(Deck deck) {
        super(deck);
    }

    @Override
    public boolean play(Card card) {
        //Dealerは17以上になるまで引く
        for (; ; ) {
            for (val num : getCount()) {
                if (num > 16) {
                    return false;
                }
            }
            deal(card);
        }
    }
}
