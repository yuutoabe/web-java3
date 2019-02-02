package jp.co.systena.tigerscave.ShoppingApp.HighAndLow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.systena.tigerscave.ShoppingApp.Card;
import jp.co.systena.tigerscave.ShoppingApp.Deck;
import jp.co.systena.tigerscave.ShoppingApp.Game;
import lombok.Getter;
import lombok.val;

public class HighAndLow extends Game {

  @Getter
  private HighAndLowActor player;
  private List<Card> cardList = new ArrayList<>();

  @Override
  public void initGame() {
    player = new HighAndLowActor();
    cardList.add(Deck.getIncetance().getCard());
  }

  @Override
  public String endGame() {
    return cardList.size() + "";
  }

  public boolean play(boolean isHigh) {
    val pre = cardList.get(0);
    val next = Deck.getIncetance().getCard();
    cardList.add(0, next);
    if (isHigh) {
      if (pre.getNumber() < next.getNumber()) {
        return true;
      }
    } else {
      if (pre.getNumber() > next.getNumber()) {
        return true;
      }
    }
    return false;
  }

  public List<Card> getCardList() {
    val list = new ArrayList<>(cardList);
    Collections.reverse(list);
    return list;
  }
}
