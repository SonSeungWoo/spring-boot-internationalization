package me.seungwoo;

import lombok.extern.slf4j.Slf4j;
import me.seungwoo.locale.MessageByLocale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ServerWebExchange;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-01-28
 * Time: 16:48
 */
@Slf4j
@Controller
public class MainController {

    @Autowired
    private MessageByLocale message;

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello(ServerWebExchange exchange, Model model) {
        String msg = message.getMessage("label.msg", exchange);
        model.addAttribute("msg", msg);
        return "main";
    }
}
