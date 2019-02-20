package jp.co.systena.tigerscave.ShoppingApp.BlackJack;

import lombok.val;

public class Dealer extends BlackJackActor {
    @Override
    public boolean play() {
        //Dealerは17以上になるまで引く
        for (; ; ) {
            for (val num : getCount()) {
                if (num > 16) {
                    return false;
                }
            }
            deal();
        }
    }
}
