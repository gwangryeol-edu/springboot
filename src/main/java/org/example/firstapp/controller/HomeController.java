package org.example.firstapp.controller;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";  // home.html 로 자동인식, 이동
    }

    @GetMapping("/hello")
    // model: 데이터, 데이터를 담아서 view로 전달
    public String hello(Model model) {
        String name = "gwangryeol";

        model.addAttribute("name", name);

        return "hello";
    }

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("username", "KIM");
        model.addAttribute("age", 18);
        model.addAttribute("city", "seoul");

        return "user";
    }

    @GetMapping("/fruits")
    public String fruits(Model model) {
        List<String> fruitsList = new ArrayList<>();
        fruitsList.add("apple");
        fruitsList.add("banana");
        fruitsList.add("cherry");
        fruitsList.add("lemon");
        fruitsList.add("kiwi");


        model.addAttribute("fruits", fruitsList);
        return "fruits";
    }

    @GetMapping("/grade")
    public String grade(Model model) {
        int score = 90;
        model.addAttribute("score", score);
        return "grade";
    }
}
