package jp.co.systena.tigerscave.ShoppingApp.controller;

import jp.co.systena.tigerscave.ShoppingApp.data.Cart;
import jp.co.systena.tigerscave.ShoppingApp.data.Order;
import jp.co.systena.tigerscave.ShoppingApp.from.ListForm;
import jp.co.systena.tigerscave.ShoppingApp.service.ListService;
import jp.co.systena.tigerscave.ShoppingApp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Slf4j
@Controller
public class ListController {

  @Autowired
  Cart session;

  @Autowired
  UserService service;

  private Cart cart;

  @RequestMapping("/item-list")
  public ModelAndView show(ModelAndView modelAndView) {
    val list = ListService.getItemList();

    modelAndView.addObject("itemList", list);
    modelAndView.addObject("listForm", new ListForm());
    modelAndView.setViewName("ListView");
    return modelAndView;
  }

  @RequestMapping(value = "/order")
  public ModelAndView order(@Valid @ModelAttribute ListForm form, BindingResult result, ModelAndView modelAndView) {
    val list = ListService.getItemList();
    session.addOrder(new Order(form.getItemNum(), ListService.getItem(form.getItemName())));
    modelAndView.addObject("orderList", session.getOrderList());
    modelAndView.addObject("itemList", list);
    modelAndView.setViewName("redirect:item-list");

    // TODO 値チェック
    log.info(form.toString());
    return modelAndView;
  }
}
