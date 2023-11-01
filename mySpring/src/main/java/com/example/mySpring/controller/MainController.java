package com.example.mySpring.controller;

import com.example.mySpring.dto.userDTO;
import com.example.mySpring.dto.userInfo;
import com.example.mySpring.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
// @RestController -> controller가 rest 역할을 하게 하는거 (일일히 적기 귀찮으니깐 통째로 만들어주는거임)
public class MainController {
    @GetMapping("/")
    public String getMain(){
        return "request";
    }

    @GetMapping("/get/response1")
    // ?key=value
    // /get/response1?name=abc
    // 기본값으로 required = true를 갖기 떄문에 ?name= 을 필수로 보내줘야 한다.
    public String getResponse1(@RequestParam(value = "name") String n, Model model){
        model.addAttribute("name", n);
        return "response";
    }

    @GetMapping("/get/response2")
    public String getResponse2(@RequestParam(value = "name", required = false) String n, Model model){
        model.addAttribute("name", n);
        return "response";
    }

    @GetMapping("/get/response3/{name}")
    public String getResponse3(@PathVariable String name, @PathVariable("age") String abc, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", abc);
        return "response";
    }

    @GetMapping("/practice/{name}")
    public String practice(@PathVariable String name, @PathVariable("age") int abc, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", abc);
        return "practice";
    }
    @GetMapping({"/get/response4/{name}", "/get/response4/{name}/{age}"})
    public String getResponse4(@PathVariable String name, @PathVariable String age, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age",age);
        return "response";
    }

    @PostMapping("/post/response1")
    public String postResponse1(@RequestParam String name, Model model){
        model.addAttribute("name", name);
        //@RequestBody : 전달받은 body 데이터를 json 형태의 객체로 만들어준다.
        return "response";
    }
    @PostMapping("/post/response2")
    public String postResponse2(@RequestParam(required = false) String name, Model model){
        model.addAttribute("name", name);
        //@RequestBody : 전달받은 body 데이터를 json 형태의 객체로 만들어준다.
        return "response";
    }

    @PostMapping("/post/response3")
    @ResponseBody //Response 데이터를 전달한다.(res.send)라고 생각하면 된다.
    public String postResponse3(@RequestParam(required = false) String name, Model model){
        model.addAttribute("name", name);
        //@RequestBody : 전달받은 body 데이터를 json 형태의 객체로 만들어준다.
        return "response";
        //responseBody를 붙이면 view를 render하는게 아니라 그 자체를 반환한다.
        // 위에 같은 경우에는 response를 전달하는게 아니라 response라는 문자열를 반환함
    }

    @GetMapping("/practice2")
    public String practice2(){
        return "practice2";
    }
    @PostMapping("/post/practiceResult")
    public String practiceResult(
            @RequestParam String name,
            @RequestParam int year,
            @RequestParam int month,
            @RequestParam int day,
            @RequestParam(value = "gender") String genders,
            @RequestParam(value = "favorite") String favorites,
            Model model
    ) {
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("name", name);
        model.addAttribute("gender", genders);
        model.addAttribute("favorite", favorites);
        System.out.println(model);
        return "practiceResult";
    }

    @GetMapping("/dto/response1")
    @ResponseBody
    public String dtoResponse1(@ModelAttribute userDTO users){
        // DTO 앞에 어노테이션을 붙이지 않았으면 -> @ModelAttribute가 자동으로 실행된다.
        // 아무것도 넣지 않던 = @ModelAttribute 통일
        //@ModelAttribute : html 폼 데이터를 컨트롤러로 전달할 때 객체에 매핑해주는 친구
        // 매핑 -> 같은 이름끼리 set 함수를 실행한다.
        // -> 프론트에서 {name, abc}
        // @RequestBody 사용가능?
        String msg = users.getName() + " " + users.getAge();
        return msg;
    }

    @GetMapping("/dto/response11")
    @ResponseBody
    public String dtoResponse11(@RequestBody userDTO users){
        // Get 방식으로 전달하고 @RequestBody로 받으면 오류
        // @RequestBody : 요청의 본문에 있는 데이터(body)
        String msg = users.getName() + " " + users.getAge();
        return msg;
    }
    // 일반 폼 전송 - DTO
    // 1) 아무것도 적지 않고 DTO로 바로 받으면 -> O
    // 2) @ModelAttribute DTO로 받으면 -> O
    // 3) @RequestBody DTO 로 받으면 -> 오류

    //RequestBody는 요청의 본문에 있는 데이터(body)를 받아서 객체에 매핑
    // json 또는 xml 일 때만 실행이 가능 단, 전달받은 요청의 데이터 형식이
    //일반 폼 전송 -> www-x-form-urlencoded
    //express.json() => @RequestBody, express.urlencoded{{extended : true}};
    // 요청을 보낼 때 일반폼으로 받을건지 json 형태로 받을건지 확실하게 결정하기

    @GetMapping("/vo/response1")
    @ResponseBody
    public String voResponse1(@ModelAttribute UserVO users){

        //@ModelAttribute를 이용하면 객체의 set 함수를 이용해 값을 넣어준다.
        String msg = users.getName() + " " + users.getAge();
        return msg;
    }

    @PostMapping("/vo/response2")
    @ResponseBody
    public String voResponse2(UserVO users){
        String msg = users.getName() + " " + users.getAge();
        return msg;
    }

    @GetMapping("/axios/response1")
    @ResponseBody
    // axios get 전송일 때, @RequestParam으로 값을 전달받을 수 있다.
    public String axiosResponse1(@RequestParam String name, @RequestParam String age){
        String msg = "이름 : " + name + " , 나이 : " + age;
        return msg;
    }

    @GetMapping("/axios/response2")
    @ResponseBody
    // axios get 전송일 때, @ModelAttribute로 값을 전달받을 수 있다.(= set 함수가 있는 객체)
    public String axiosResponse2(userDTO user){
        String msg = "이름 : " + user.getName() + "나이 : " + user.getAge();
        return msg;
    }

    // ModelAttribute 와 @RequestParam 의 특징
    // 일반폼 전송 -> 파라미터 형태로 들어온다.
    // json으로 값을 보내면 파라미터가 아니라 데이터에 들어온다. (요청 본문 데이터)
    @PostMapping("/axios/response3")
    @ResponseBody
    public String axiosResponse3(@RequestParam String name, @RequestParam String age){
        // axios post는 @RequestParam으로 못 받는다.
        String msg = "이름 : " + name + " 나이 : " + age;
        return msg;
    }

    @PostMapping("/axios/response4")
    @ResponseBody
    public String axiosResponse4(userDTO user){
        String msg = "이름 : " + user.getName() + "나이 : " + user.getAge();
        return msg;
    }

    @PostMapping("/axios/response5")
    @ResponseBody
    public String axiosResponse5(@RequestBody userDTO user){
        String msg = "이름 : " + user.getName() + "나이 : " + user.getAge();
        return msg;
    }

    @GetMapping("/axios/vo/response2")
    @ResponseBody
    public String axiosVoResponse2(UserVO user){
        String msg = "이름 : " + user.getName() + ", 나이 : " + user.getAge();
        return msg;
    }

    @PostMapping("/axios/vo/response4")
    @ResponseBody
    public String axiosVoResponse4(UserVO user){
        String msg = "이름 : " + user.getName() + ", 나이 : " + user.getAge();
        return msg;
    }

    @PostMapping("/axios/vo/response5")
    @ResponseBody
    public String axiosVoResponse5(@RequestBody UserVO user){
        // ModelAttribute는 setter함수를 실행해 값을 넣어주는 친구
        // RequestBody는 setter 함수가 아닌 각각의 필드에 직접적으로 값을 주입하면서 매핑
        String msg = "이름 : " + user.getName() + ", 나이 : " + user.getAge();
        return msg;
    }
}
