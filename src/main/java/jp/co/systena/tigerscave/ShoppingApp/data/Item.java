package jp.co.systena.tigerscave.ShoppingApp.data;

import lombok.Value;

/**
 * 商品情報クラス
 */
@Value
public class Item {
  /**
   * 商品名
   */
  private String name;
  /**
   * 価格
   */
  private int price;
}
