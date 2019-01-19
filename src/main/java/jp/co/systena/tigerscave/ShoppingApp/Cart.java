package jp.co.systena.tigerscave.ShoppingApp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart implements Serializable {
  private List<Order> orderList = new ArrayList<>();

  public void addOrder(Order order) {
    orderList.add(order);
  }
}
