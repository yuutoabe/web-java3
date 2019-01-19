package jp.co.systena.tigerscave.ShoppingApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ListController {

  @Autowired
  Cart session;

  private Cart cart;

  @RequestMapping("/item-list")
  public ModelAndView show(ModelAndView modelAndView) {
    val list = ListService.getItemList();

    modelAndView.addObject("itemList", list);
    modelAndView.addObject("listForm", new ListForm());
    modelAndView.setViewName("ListView");
    return modelAndView;
  }

  @RequestMapping(value = "/order", method = RequestMethod.POST)
  public ModelAndView order(@ModelAttribute ListForm form, ModelAndView modelAndView) {
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
