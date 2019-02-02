package jp.co.systena.tigerscave.ShoppingApp;

import lombok.Value;

@Value
public class Card {
  public enum Suit {
    SPADE, HEART, CLUB, DIAMOND
  }

  public int number;
  public Suit suit;
}
