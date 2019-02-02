package jp.co.systena.tigerscave.ShoppingApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.ShoppingApp.HighAndLow.HighAndLow;
import jp.co.systena.tigerscave.ShoppingApp.HighAndLow.HighAndLowSession;
import lombok.val;

@Controller
public class HighAndLowController {

  @Autowired
  private HighAndLowSession session;

  @RequestMapping("/highlow")
  public ModelAndView startGame(ModelAndView modelAndView) {
    val game = new HighAndLow();
    game.initGame();
    session.setHighAndLow(game);
    modelAndView.addObject("card", game.getCardList());
    modelAndView.setViewName("HighLowView");
    return modelAndView;
  }

  @RequestMapping("/high")
  public ModelAndView high(ModelAndView modelAndView) {
    val game = session.getHighAndLow();
    if (game.play(true)) {
      modelAndView.addObject("card", game.getCardList());
      modelAndView.setViewName("HighLowView");
    } else {
      modelAndView.addObject("result", game.endGame());
      modelAndView.addObject("card", game.getCardList());
      modelAndView.setViewName("HighLowResultView");
    }
    return modelAndView;

  }

  @RequestMapping("/low")
  public ModelAndView low(ModelAndView modelAndView) {
    val game = session.getHighAndLow();
    if (game.play(false)) {
      modelAndView.addObject("card", game.getCardList());
      modelAndView.setViewName("HighLowView");
    } else {
      modelAndView.addObject("result", game.endGame());
      modelAndView.addObject("card", game.getCardList());
      modelAndView.setViewName("HighLowResultView");
    }
    return modelAndView;
  }

}
