package org.example.firstapp.controller;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

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

    @GetMapping("/lunch")
    public String lunch(Model model) {
        List<String> menus = Arrays.asList("라면", "김밥", "돈까스");

        Random random = new Random();
        String pick = menus.get(random.nextInt(menus.size()));

        model.addAttribute("pick", pick);
        return "lunch";
    }


//    @GetMapping("/lotto")
//    public String lotto(Model model) {
//        List<Integer> numbers = IntStream.rangeClosed(1,45).
//    }

    @GetMapping("/profile/{username}")
    public String profile(@PathVariable String username, Model model) {
        model.addAttribute("username", username);
        return "profile";
    }

    @GetMapping("/cube/{number}")
    public String cube(@PathVariable int number, Model model) {
        int result = number * number * number;
        model.addAttribute("number", number);
        model.addAttribute("result", result);
        return "cube";
    }

    // 짝수 홀수 판뱔
    // number/{num} 짝수인지 홀수인지 판별해서 화면에 출력
    @GetMapping("/number/{num}")
    public String number(@PathVariable int num, Model model) {
        model.addAttribute("num", num);
        return "number";
    }

    // 나이 계산 (Year 클래스)
    // /age/{birthYear} 현재 나이를 계산해서 출력
    // /age/1990 36살입니다
    @GetMapping("/age/{birthYear}")
    public String age(@PathVariable int birthYear, Model model) {
        Calendar cal = Calendar.getInstance();

        int today = cal.get(Calendar.YEAR);
        model.addAttribute("birthYear", birthYear);
        model.addAttribute("today", today);
        return "age";
    }

    @GetMapping("/ping")
    public String ping(Model model) {
        return "ping";
    }

    @GetMapping("/pong")
    public String pong(
            @RequestParam String title,
            @RequestParam String content,
            Model model) {

        model.addAttribute("title", title);
        model.addAttribute("content", content);
        return "pong";
    }
}
