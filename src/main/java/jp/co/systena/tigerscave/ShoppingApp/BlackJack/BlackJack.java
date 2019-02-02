package jp.co.systena.tigerscave.ShoppingApp.BlackJack;

import java.util.List;
import jp.co.systena.tigerscave.ShoppingApp.Game;
import lombok.Getter;
import lombok.val;

public class BlackJack extends Game {

  @Getter
  private Dealer dealer;
  @Getter
  private Player player;

  @Override
  public void initGame() {
    player = new Player();
    dealer = new Dealer();
  }

  @Override
  public String endGame() {
    // TODO 自動生成されたメソッド・スタブ
    return getWinner();
  }

  public boolean executePlayer() {
    return player.play();
  }

  public void executeDealer() {
    dealer.play();
  }

  private String getWinner() {
    val pVal = getNum(player.getCount());
    val dVal = getNum(dealer.getCount());
    if (pVal == dVal) {
      return "Push";
    }
    if (pVal > 21) {
      return "Dealer Win";
    }
    if (dVal > 21) {
      return "Player Win";
    }
    if (pVal > dVal) {
      return "Player Win";
    } else {
      return "Dealer Win";
    }
  }

  private int getNum(List<Integer> list) {
    if (list.size() == 1) {
      return list.get(0);
    }
    val num1 = list.get(0);
    val num2 = list.get(1);
    if (num1 > 21) {
      return num2;
    } else if (num2 > 21) {
      return num1;
    } else {
      return num1 > num2 ? num1 : num2;
    }
  }

}
