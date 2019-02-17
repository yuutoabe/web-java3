package jp.co.systena.tigerscave.ShoppingApp.from;

import lombok.Data;

import java.io.Serializable;

@Data
public class ListForm implements Serializable {
  private static final long serialVersionUID = 1L;

  private String itemName;
  private int itemNum;
}
