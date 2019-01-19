package jp.co.systena.tigerscave.ShoppingApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CartController {

  @Autowired
  Cart session;
  private List<String> listCalam = new ArrayList<>(Arrays.asList("商品名", "価格", "数量"));

  @RequestMapping("/cart")
  public ModelAndView showCart(ModelAndView modelAndView) {
    modelAndView.addObject("calam", listCalam);
    modelAndView.addObject("orderList", session.getOrderList());
    modelAndView.setViewName("Cart");
    return modelAndView;

  }

}
