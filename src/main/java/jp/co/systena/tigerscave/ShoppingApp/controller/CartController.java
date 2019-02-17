package jp.co.systena.tigerscave.ShoppingApp.controller;

import jp.co.systena.tigerscave.ShoppingApp.data.Cart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
public class CartController {

  @Autowired
  Cart session;
  private List<String> listColumn = new ArrayList<>(Arrays.asList("商品名", "価格", "数量"));

  @RequestMapping("/cart")
  public ModelAndView showCart(@Valid @ModelAttribute ModelAndView modelAndView, BindingResult result) {
    modelAndView.addObject("column", listColumn);
    modelAndView.addObject("orderList", session.getOrderList());
    modelAndView.setViewName("Cart");
    return modelAndView;

  }

}
