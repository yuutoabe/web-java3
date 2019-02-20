package jp.co.systena.tigerscave.ShoppingApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopController {

    @RequestMapping("/top")
    public String  showTop() {
        return "TopView";
    }
}
