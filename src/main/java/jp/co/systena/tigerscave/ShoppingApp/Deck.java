package jp.co.systena.tigerscave.ShoppingApp;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import jp.co.systena.tigerscave.ShoppingApp.Card.Suit;
import lombok.val;

public class Deck {

  private Map<Card, Boolean> cardMap = new LinkedHashMap<>();

  public Deck() {
    for (int i = 1; i < 14; i++) {
      cardMap.put(new Card(i, Suit.SPADE), true);
    }
    for (int i = 1; i < 14; i++) {
      cardMap.put(new Card(i, Suit.HEART), true);
    }
    for (int i = 1; i < 14; i++) {
      cardMap.put(new Card(i, Suit.DIAMOND), true);
    }
    for (int i = 1; i < 14; i++) {
      cardMap.put(new Card(i, Suit.CLUB), true);
    }
  }

  public Card getCard() {
    val rnd = new Random();
    Card[] keys = cardMap.keySet().toArray(new Card[cardMap.size()]);
    for (;;) {
      val value = keys[rnd.nextInt(52)];
      if (cardMap.get(value)) {
        cardMap.put(value, false);
        return value;
      }
    }
  }
}
