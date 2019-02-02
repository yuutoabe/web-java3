package jp.co.systena.tigerscave.ShoppingApp.BlackJack;

import jp.co.systena.tigerscave.ShoppingApp.Deck;
import lombok.val;

public class Dealer extends BlackJackActor {
  @Override
  public boolean play() {
    for (;;) {
      for (val num : getCount()) {
        if (num > 16) {
          return false;
        }
      }
      deal(Deck.getIncetance().getCard());
    }
  }
}
