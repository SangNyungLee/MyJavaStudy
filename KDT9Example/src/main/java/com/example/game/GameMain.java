package com.example.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.game") //같은 위치에서는 생략이 가능하다.
public class GameMain {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(GameMain.class);

        context.getBean(GameConsole.class).up();
        context.getBean(GameEngine.class).run();
//        //결합도: 무엇인가를 변경하는데 얼마나 많은 작업이 관련되어 있는지에 대한 측정
//        StarCraft game = new StarCraft();
//        LOL game2 = new LOL();
//        GameEngine engine = new GameEngine(game2);
//
//        engine.run();
    }
}