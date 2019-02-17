package jp.co.systena.tigerscave.ShoppingApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping(value="/login")
    String loginForm() {
        return "Login";
    }
}
