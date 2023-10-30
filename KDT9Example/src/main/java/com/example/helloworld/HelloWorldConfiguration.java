package com.example.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//record : getter, setter, 생성자 등을 자동으로 생성
record Person(String name, int age){

}
record Address(String address, int postcode){

}
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "KDT9";
    }
    @Bean
    public int age(){
        return 28;
    }
    @Bean
    public Person person(){
        return new Person("최배달", 54);
    }

    @Bean
    public Person person2(){
        //Bean을 정의해놓으면 재사용이 가능하다.
        return new Person(name(), age());
    }

    @Bean(name = "myAddress")   //메소드 명을 지정해주는 거
    public Address address(){
        return new Address("Seoul", 12345);
    }
}
