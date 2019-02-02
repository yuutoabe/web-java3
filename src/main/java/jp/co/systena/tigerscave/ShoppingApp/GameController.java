package jp.co.systena.tigerscave.ShoppingApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.ShoppingApp.BlackJack.BlackJack;
import jp.co.systena.tigerscave.ShoppingApp.BlackJack.BlackJackSession;
import lombok.val;

@Controller
public class GameController {

  @Autowired
  private BlackJackSession session;

  @RequestMapping("/blackjack")
  public ModelAndView startBlackJack(ModelAndView modelAndView) {
    val game = new BlackJack();
    game.initGame();
    session.setBlackJack(game);
    if (game.getPlayer().getCount().contains(21)) {
      modelAndView.addObject("dHand", game.getDealer().getMyHand());
      modelAndView.addObject("dCount", game.getDealer().getCountString());
      modelAndView.addObject("result", game.endGame());
      modelAndView.addObject("pHand", game.getPlayer().getMyHand());
      modelAndView.addObject("pCount", game.getPlayer().getCountString());
      modelAndView.setViewName("ResultView");
    } else {
      modelAndView.addObject("dSuit", game.getDealer().getMyHand().get(0).getSuit());
      modelAndView.addObject("dNumber", game.getDealer().getMyHand().get(0).getNumber());
      modelAndView.addObject("pHand", game.getPlayer().getMyHand());
      modelAndView.addObject("pCount", game.getPlayer().getCountString());
      modelAndView.setViewName("BlackJackView");
    }

    return modelAndView;
  }

  @RequestMapping("/hit")
  public ModelAndView playerHit(ModelAndView modelAndView) {
    val game = session.getBlackJack();
    if (!game.executePlayer()) {
      modelAndView.addObject("dSuit", game.getDealer().getMyHand().get(0).getSuit());
      modelAndView.addObject("dNumber", game.getDealer().getMyHand().get(0).getNumber());
      modelAndView.setViewName("BlackJackView");
    } else if (game.getPlayer().getCount().contains(21)) {
      game.executeDealer();
      modelAndView.addObject("dHand", game.getDealer().getMyHand());
      modelAndView.addObject("dCount", game.getDealer().getCountString());
      modelAndView.addObject("result", game.endGame());
      modelAndView.setViewName("ResultView");
    } else {
      modelAndView.addObject("dHand", game.getDealer().getMyHand());
      modelAndView.addObject("dCount", game.getDealer().getCountString());
      modelAndView.addObject("result", game.endGame());
      modelAndView.setViewName("ResultView");
    }
    modelAndView.addObject("pHand", game.getPlayer().getMyHand());
    modelAndView.addObject("pCount", game.getPlayer().getCountString());
    session.setBlackJack(game);

    return modelAndView;
  }

  @RequestMapping("/stand")
  public ModelAndView playerStand(ModelAndView modelAndView) {
    val game = session.getBlackJack();
    game.executeDealer();
    modelAndView.addObject("dHand", game.getDealer().getMyHand());
    modelAndView.addObject("pHand", game.getPlayer().getMyHand());
    modelAndView.addObject("dCount", game.getDealer().getCountString());
    modelAndView.addObject("pCount", game.getPlayer().getCountString());
    modelAndView.addObject("result", game.endGame());
    modelAndView.setViewName("ResultView");
    session.setBlackJack(game);
    return modelAndView;
  }
}
