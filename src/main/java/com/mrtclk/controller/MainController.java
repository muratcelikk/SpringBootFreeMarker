package com.mrtclk.controller;

import com.mrtclk.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private static List<Person> personList = new ArrayList<>();

    static {
        personList.add(new Person("Bill", "Gates"));
        personList.add(new Person("Steve", "Jobs"));
    }

    @Value("${welcome.message}")
    private String message;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    private String index(Model model) {
        model.addAttribute("message", message);
        return "index";
    }
}
