package jp.co.systena.tigerscave.ShoppingApp;

import java.util.ArrayList;
import java.util.List;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListService {
  public static List<Item> getItemList() {
    val list = new ArrayList<Item>();
    list.add(new Item("Item10", 100));
    list.add(new Item("Item11", 108));
    list.add(new Item("Item12", 100));
    list.add(new Item("Item13", 101));
    list.add(new Item("Item14", 102));
    list.add(new Item("Item15", 103));
    list.add(new Item("Item16", 104));
    list.add(new Item("Item17", 105));
    list.add(new Item("Item18", 106));
    list.add(new Item("Item19", 107));
    list.add(new Item("Item1", 109));
    list.add(new Item("Item1", 110));
    list.add(new Item("Item1", 111));
    list.add(new Item("Item1", 112));
    list.add(new Item("Item1", 113));
    list.add(new Item("Item1", 114));
    list.add(new Item("Item1", 115));
    list.add(new Item("Item1", 116));
    list.add(new Item("Item1", 117));
    list.add(new Item("Item1", 118));
    list.add(new Item("Item1", 119));
    list.add(new Item("Item1", 120));
    list.add(new Item("Item1", 121));
    list.add(new Item("Item1", 122));
    list.add(new Item("Item1", 123));
    log.debug("getList size = " + list.size());
    return list;
  }

  // TODO アイテム名重複はなくす
  public static Item getItem(String itemName) {
    for (val item : getItemList()) {
      if (item.getName().equals(itemName)) {
        return item;
      }
    }
    return null;
  }
}
