package jp.co.systena.tigerscave.ShoppingApp.BlackJack;

import java.util.List;

import jp.co.systena.tigerscave.ShoppingApp.Deck;
import jp.co.systena.tigerscave.ShoppingApp.Game;
import lombok.Getter;
import lombok.val;

/**
 * BlackJack実装クラス
 */
@Getter
public class BlackJack extends Game {

    /**
     * Dealer
     */
    private BlackJackActor dealer;
    /**
     * Player
     */
    private BlackJackActor player;


    /**
     * Deck
     */
    private Deck deck = new Deck();


    @Override
    public void initGame() {
        player = new Player(deck);
        dealer = new Dealer(deck);
    }

    @Override
    public String endGame() {
        return getWinner();
    }

    public boolean executeGame(boolean isPlayerTurn) {
        if (isPlayerTurn) {
            if (player.play(deck.getCard())) {
                if (player.isSoftHand()) {
                    if (player.getCount().get(0) > 21 && player.getCount().get(1) > 21) {
                        return true;
                    }
                } else {
                    if (player.getCount().get(0) > 21) {
                        return true;
                    }
                }
                dealer.play(deck.getCard());
                return true;
            }
            return false;
        } else {
            return dealer.play(deck.getCard());
        }
    }

    /**
     * 勝者の文字列を返却します。
     *
     * @return Dealer or Player
     */
    private String getWinner() {
        val pVal = getNum(player.getCount());
        val dVal = getNum(dealer.getCount());
        //同じ場合
        if (pVal == dVal) {
            return "Push";
        }
        //どちらかがバーストの場合
        if (pVal > 21) {
            return "Dealer Win";
        }
        if (dVal > 21) {
            return "Player Win";
        }
        //21以内の場合
        if (pVal > dVal) {
            return "Player Win";
        } else {
            return "Dealer Win";
        }
    }

    /**
     * 勝敗判定用の手札の点数を返します。
     *
     * @param list 手札
     * @return 点数
     */
    private int getNum(List<Integer> list) {
        //Aがない場合はそのまま返却
        if (list.size() == 1) {
            return list.get(0);
        }
        //Aがある場合は21以下で21に近いほうを返却
        val num1 = list.get(0);
        val num2 = list.get(1);
        if (num1 > 21) {
            return num2;
        } else if (num2 > 21) {
            return num1;
        } else {
            return num1 > num2 ? num1 : num2;
        }
    }
}
