package org.example.firstapp.controller;

import org.springframework.context.annotation.ScopeMetadataResolver;
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

    //    ---- Do myself Level 2: PathVariable로 동적 페이지 만들기 ----
    @GetMapping("/square/{number}")
    public String square(@PathVariable int number, Model model) {
        int result = number * number;
        model.addAttribute("number", number);
        model.addAttribute("result", result);
        return "square";
    }

    //    ---- Do myself Level 3: RequestParam 활용 연습 ----
    @GetMapping("/calc")
    public String calc(
            @RequestParam(required = false) Integer number1,
            @RequestParam(required = false) Integer number2,
            Model model) {
        if (number1 != null && number2 != null) {
            model.addAttribute("result1", number1 + number2);
            model.addAttribute("result2", number1 - number2);
            model.addAttribute("result3", number1 * number2);
            model.addAttribute("result4", number2 != 0 ? number1 / number2 : "0으로 나눌 수 없음");
        }

        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);

        return "calc";
    }

    //---Level 4: List, 반복문 연습---
    @GetMapping("/avg")
    public String avg(Model model) {
        List<Integer> scores = Arrays.asList(53, 79, 89, 48, 90, 100);

        int sum = 0;
        for (int s : scores) {
            sum += s;
        }
        int scoreAVG = sum / scores.size();

        model.addAttribute("scores", scores);
        model.addAttribute("sum", sum);
        model.addAttribute("scoreAVG", scoreAVG);

        return "avg";
    }

    // Level 6: 실전 미니 프로젝트: 계산기
    @GetMapping("/inputcalculator")
    public String inputcalculator(Model model) {
        return "inputcalculator";
    }

    @GetMapping("/calculator")
    public String calculator(
            @RequestParam int num1,
            @RequestParam String calcu,
            @RequestParam int num2,
            Model model
    ) {
        int result1 = num1 + num2;
        int result2 = num1 - num2;
        int result3 = num1 * num2;
        int result4 = num1 / num2;

        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("calcu", calcu);
        model.addAttribute("result1", result1);
        model.addAttribute("result2", result2);
        model.addAttribute("result3", result3);
        model.addAttribute("result4", result4);


        return "calculator";

    }
}
