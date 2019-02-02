package jp.co.systena.tigerscave.ShoppingApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TopController {


  @RequestMapping("/top")
  public ModelAndView showTop(ModelAndView modelAndView) {
    modelAndView.setViewName("TopView");
    return modelAndView;
  }
}
