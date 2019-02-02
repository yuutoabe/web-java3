package jp.co.systena.tigerscave.ShoppingApp.BlackJack;

import java.util.ArrayList;
import java.util.List;
import jp.co.systena.tigerscave.ShoppingApp.Actor;
import jp.co.systena.tigerscave.ShoppingApp.Card;
import jp.co.systena.tigerscave.ShoppingApp.Deck;
import lombok.Getter;
import lombok.val;

public class BlackJackActor extends Actor {
  @Getter
  protected List<Card> myHand = new ArrayList<Card>();
  protected boolean isSoftHand;

  public BlackJackActor() {
    deal(Deck.getIncetance().getCard());
    deal(Deck.getIncetance().getCard());
  }


  public List<Integer> getCount() {
    val result = new ArrayList<Integer>();
    int temp = 0;
    for (val card : myHand) {
      val num = card.getNumber();
      if (num > 9) {
        temp += 10;
      } else {
        temp += num;
      }
    }
    result.add(temp);
    temp = 0;
    if (isSoftHand) {
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
      if (temp < 22) {
        result.add(temp);
      }
    }

    return result;
  }

  public void deal(Card card) {
    if (card.getNumber() == 1) {
      isSoftHand = true;
    }
    myHand.add(card);
  }


  @Override
  public boolean play() {
    return false;
  }

  public String getCountString() {
    val list = getCount();
    if (list.size() == 2) {
      return list.get(0) + "/" + list.get(1);
    } else {
      return list.get(0) + "";
    }
  }

}
