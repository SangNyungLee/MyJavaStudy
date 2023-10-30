package com.example.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//record : getter, setter, 생성자 등을 자동으로 생성
record Person(String name, int age){

}
record Address(String address, int postcode){

}
record Information(String name, int age, Address address){
    //Address address => 위에서 선언한 Address 재사용 한거임
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

    @Bean
    @Primary
    public Information info(String name, int age, @Qualifier("address3Qualifier") Address myAddress){
        return new Information(name, age, myAddress);
    }

    @Bean
    @Primary
    public Address address2(){
        return new Address("용산", 26);
    }

    @Bean
    @Qualifier("address3Qualifier")
    public Address address3(){
        return new Address("서울 서대문", 16515);
    }

    @Bean
    public Information info2(String name, int age, @Qualifier("address3Qualifier") Address address){
        return new Information(name, age, address);
    }
}
