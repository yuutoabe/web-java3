package jp.co.systena.tigerscave.ShoppingApp.HighAndLow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jp.co.systena.tigerscave.ShoppingApp.Card;
import jp.co.systena.tigerscave.ShoppingApp.Deck;
import jp.co.systena.tigerscave.ShoppingApp.Game;
import lombok.Getter;
import lombok.val;

/**
 * HighAndLow実装クラス
 */
public class HighAndLow extends Game {

    /**
     * Player
     */
    @Getter
    private HighAndLowActor player;
    /**
     * 場に出たカード
     */
    private List<Card> cardList = new ArrayList<>();
    /**
     * Deck
     */
    private Deck deck = new Deck();

    @Override
    public void initGame() {
        player = new HighAndLowActor();
        cardList.add(deck.getCard());
    }

    @Override
    public String endGame() {
        return cardList.size() + "";
    }

    @Override
    public boolean executeGame(boolean isHigh) {
        val pre = cardList.get(0);
        val next = deck.getCard();
        cardList.add(0, next);
        if (isHigh) {
            return pre.getNumber() < next.getNumber();
        } else {
            return pre.getNumber() > next.getNumber();
        }
    }

    /**
     * 現在場に出ているカードのリストを取得します。
     * @return List 追加順と表示順が逆のためここでReverseする。
     */
    public List<Card> getCardList() {
        val list = new ArrayList<>(cardList);
        Collections.reverse(list);
        return list;
    }
}
