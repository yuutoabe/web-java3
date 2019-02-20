package jp.co.systena.tigerscave.ShoppingApp;

import lombok.Value;

/**
 * Cardクラス
 */
@Value
public class Card {
    /**
     * マーク列挙型
     */
    public enum Suit {
        SPADE, HEART, CLUB, DIAMOND
    }

    /**
     * 数字
     */
    private int number;
    /**
     * マーク
     */
    private Suit suit;
}
