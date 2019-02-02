package jp.co.systena.tigerscave.ShoppingApp.BlackJack;

import jp.co.systena.tigerscave.ShoppingApp.Deck;
import lombok.val;

public class Player extends BlackJackActor {
  @Override
  public boolean play() {
    deal(Deck.getIncetance().getCard());
    if (getCount().size() == 2) {
      val num1 = getCount().get(0);
      val num2 = getCount().get(1);
      if (num1 == 21 || num2 == 21) {
        return true;
      }
      if (num1 > 21 && num2 > 21) {
        return true;
      } else {
        return false;
      }
    } else {
      return (getCount().get(0) > 20);
    }

  }


}
