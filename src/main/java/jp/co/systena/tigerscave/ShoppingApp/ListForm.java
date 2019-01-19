package jp.co.systena.tigerscave.ShoppingApp;

import java.io.Serializable;
import lombok.Data;

@Data
public class ListForm implements Serializable {
  private static final long serialVersionUID = 1L;

  private String itemName;
  private int itemNum;
}
