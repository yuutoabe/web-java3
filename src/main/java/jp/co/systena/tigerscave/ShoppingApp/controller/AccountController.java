package jp.co.systena.tigerscave.ShoppingApp.controller;

import jp.co.systena.tigerscave.ShoppingApp.entity.User;
import jp.co.systena.tigerscave.ShoppingApp.from.AccountForm;
import jp.co.systena.tigerscave.ShoppingApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController {

    @Autowired
    UserService userService;

    @ModelAttribute
    public AccountForm setupForm() {
        return new AccountForm();
    }

    @RequestMapping(value="account")
    String accountForm() {
        return "Account";
    }

    @RequestMapping(value = "account", method = RequestMethod.POST)
    String create(@Validated AccountForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Account";
        }
        User user = new User();
        user.setUserName(form.getUserName());
        userService.create(user, form.getPassword());
        return "Login";
    }

    @RequestMapping(value = "account/complete", method = RequestMethod.GET)
    String createFinish() {
        return "Login";
    }
}
