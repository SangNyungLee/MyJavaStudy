package com.example.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class LOL implements GameConsole{

    public void up(){
        System.out.println("CHAMPION UP");
    }
    public void down (){
        System.out.println("CHAMPION DOWN");
    }
    public void right (){
        System.out.println("CHAMPION RIGHT");
    }
    public void left (){
        System.out.println("CHAMPION LEFT");
    }

}
