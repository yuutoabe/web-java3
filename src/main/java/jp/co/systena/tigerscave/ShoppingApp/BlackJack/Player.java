package jp.co.systena.tigerscave.ShoppingApp.BlackJack;

import lombok.val;

/**
 * BlackJackPlayerクラス
 */
public class Player extends BlackJackActor {
    @Override
    public boolean play() {
        deal();
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
