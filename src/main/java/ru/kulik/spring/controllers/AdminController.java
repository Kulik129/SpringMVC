package ru.kulik.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kulik.spring.DAO.PersonDAO;
import ru.kulik.spring.models.Person;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private PersonDAO personDAO;

    @GetMapping()
    public String adminPage(Model model, @ModelAttribute("person")Person person) {
        model.addAttribute("people", personDAO.index());
        return "adminPage";
    }

    @PatchMapping("/add")
    public String makeAdmin(@ModelAttribute("person") Person person) {
        System.out.println(person.getId());
        return "redirect:/people";
    }
}
