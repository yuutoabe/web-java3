package jp.co.systena.tigerscave.ShoppingApp.BlackJack;

import jp.co.systena.tigerscave.ShoppingApp.Card;
import jp.co.systena.tigerscave.ShoppingApp.Deck;
import lombok.val;

/**
 * BlackJackPlayerクラス
 */
public class Player extends BlackJackActor {
    /**
     * constructor
     *
     * @param deck Deck
     */
    Player(Deck deck) {
        super(deck);
    }

    @Override
    public boolean play(Card card) {
        deal(card);
        //手札の点数が21を超えた場合True
        if (getCount().size() == 2) {
            //Aがあり点数が2通りある場合
            val num1 = getCount().get(0);
            val num2 = getCount().get(1);
            //どちらかが21なら終了
            if (num1 == 21 || num2 == 21) {
                return true;
            }
            //両方21を超えた場合終了
            return num1 > 21 && num2 > 21;
        } else {
            //Aがない場合21を超えた場合終了
            return (getCount().get(0) > 20);
        }
    }
}
