package com.example.game;

import org.springframework.stereotype.Component;

@Component
public class StarCraft implements GameConsole{

    public void up(){
        System.out.println("SCV UP");
    }
    public void down (){
        System.out.println("SCV DOWN");
    }
    public void right (){
        System.out.println("SCV RIGHT");
    }
    public void left (){
        System.out.println("SCV LEFT");
    }

}
