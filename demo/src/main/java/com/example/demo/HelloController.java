package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {

    class Hello{
        public int age;
        public Hello(int age){
            this.age = age;
        }

        public int getAge(){
            return age;
        }
    }
    class Person {
        public String name;
        public int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

    }
    @GetMapping("/hi")
    public String getHi(Model model){ //Model model : 컨트롤러 클래스안의 메서드가 파라미터로 받을 수 있는 객체
        Hello hello = new Hello(25);
        List<String> names = Arrays.asList("kim", "lee", "hong", "park");
        model.addAttribute("msg", "hi");
        model.addAttribute("hello", "Spring World");
        model.addAttribute("uText", "<strong>Hello</strong>");
        model.addAttribute("value", "이름을 입력하세요:");
        model.addAttribute("with",10000);
        model.addAttribute("link","hi");
        model.addAttribute("img", "경로");
        model.addAttribute("userRole", "admin");
        model.addAttribute("isAdmin", false);
        model.addAttribute("names", names);
        model.addAttribute("classHello", hello);

        //${...} : 변수 표현식 ${msg}
        //@{...} : URL 링크 표현식 @{/hi}
        //*{...} : 선택변수 표현식 *{msg} 단, th : object
        //컨트롤러 클래스에서 private String msg = "hi";
        //model.addAtrribute("Msg", new HelloController());
        //템플릿에서 <div th:object${Msg}><h1> th: text=*{msg}</h1></div>

        return "hi";
    }
    @GetMapping("/practice")
    public void prac(Model model){
        model.addAttribute("age", 21);
    }

    @GetMapping("/people")
    public String pp(Model model){
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("kim", 22));
        list.add(new Person("Park", 25));
        list.add(new Person("Lee", 28));
        model.addAttribute( "people", list);
         return "people";
    }

}
