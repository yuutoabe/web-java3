package jp.co.systena.tigerscave.ShoppingApp.BlackJack;

import java.util.List;

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
    private Dealer dealer;
    /**
     * Player
     */
    private Player player;

    @Override
    public void initGame() {
        player = new Player();
        dealer = new Dealer();
    }

    @Override
    public String endGame() {
        return getWinner();
    }

    public boolean executeGame(boolean isPlayerTurn) {
        if (isPlayerTurn) {
            if (player.play()) {
                dealer.play();
                return true;
            }
            return false;
        } else {
            return dealer.play();
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
