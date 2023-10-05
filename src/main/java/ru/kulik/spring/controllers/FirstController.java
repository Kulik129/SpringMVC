package ru.kulik.spring.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        model.addAttribute("message", "Name " + name + " Surname " + surname);
        return "first/hello";
    }

    @GetMapping("/good-bye")
    public String goodByePage() {
        return "first/goodBye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("action") String action,
                             @RequestParam("a") int a,
                             @RequestParam("b")int b,
                             Model model){
        switch (action){
            case "*":
                model.addAttribute("ans", a*b);
                break;
            case "pl":
                model.addAttribute("ans", a+b);
                break;
        }

        return "first/ans";
    }
}
