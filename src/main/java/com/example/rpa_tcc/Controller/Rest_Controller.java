package com.example.rpa_tcc.Controller;

import com.example.rpa_tcc.Entity.Form;
import com.example.rpa_tcc.Service.Calculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;

@Controller
@RequestMapping()
public class Rest_Controller {

    @Autowired
    Calculate calculate;

    @GetMapping("/")
    public String home(Model model) {
        Form form = new Form();
        model.addAttribute("form", form);
        return "index.html";
    }

    @PostMapping("/receive")
    public String submitForm(@ModelAttribute("form") Form form, Model model) {
        model.addAttribute("greeting", calculate.calculate(form));
        return "result";
    }
}
