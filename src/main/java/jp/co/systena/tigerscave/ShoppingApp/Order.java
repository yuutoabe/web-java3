package jp.co.systena.tigerscave.ShoppingApp;

import lombok.Value;

/**
 * 注文情報クラス
 */
@Value
public class Order {
  /**
   * 注文数量
   */
  private int num;
  /**
   * 商品情報
   */
  private Item item;
}
