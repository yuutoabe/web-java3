package jp.co.systena.tigerscave.ShoppingApp.BlackJack;

import java.util.ArrayList;
import java.util.List;

import jp.co.systena.tigerscave.ShoppingApp.Actor;
import jp.co.systena.tigerscave.ShoppingApp.Card;
import jp.co.systena.tigerscave.ShoppingApp.Deck;
import lombok.Getter;
import lombok.val;

/**
 * BlackJackのプレイヤー親クラス
 */
public class BlackJackActor extends Actor {

    /**
     * 手札
     */
    @Getter
    protected List<Card> myHand = new ArrayList<Card>();
    /**
     * Aがある手札かどうか
     */
    private boolean isSoftHand;

    /**
     * Deck
     */
    private Deck deck = new Deck();

    /**
     * constructor
     */
    BlackJackActor() {
        deal();
        deal();
    }


    /**
     * 手札の合計点数を取得します。
     *
     * @return List Aがある場合は2通りあるのでListで返す。
     */
    public List<Integer> getCount() {
        val result = new ArrayList<Integer>();
        int temp = 0;
        //Aを1として扱った場合の点数
        for (val card : myHand) {
            val num = card.getNumber();
            if (num > 9) {
                temp += 10;
            } else {
                temp += num;
            }
        }
        result.add(temp);
        //Aがない場合はreturn
        if (!isSoftHand) {
            return result;
        }
        //Aを11として扱った場合の点数
        temp = 0;
        for (val card : myHand) {
            val num = card.getNumber();
            if (num > 9) {
                temp += 10;
            } else if (num == 1) {
                temp += 11;
            } else {
                temp += num;
            }
        }
        //22を超える場合はバーストなので追加しない。
        if (temp < 22) {
            result.add(temp);
        }
        return result;
    }

    /**
     * Cardを一枚配る。
     */
    void deal() {
        val card = deck.getCard();
        isSoftHand = card.getNumber() == 1;
        myHand.add(card);
    }


    @Override
    public boolean play() {
        return false;
    }

    /**
     * 表示用に点数を文字列に変換する。
     * @return 表示用文字列
     */
    public String getCountString() {
        val list = getCount();
        //Aがある場合は/で2通り表示
        if (list.size() == 2) {
            return list.get(0) + "/" + list.get(1);
        } else {
            return list.get(0) + "";
        }
    }
}
