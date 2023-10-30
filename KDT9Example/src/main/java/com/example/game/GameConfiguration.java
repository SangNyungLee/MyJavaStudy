//package com.example.game;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//@Configuration
//public class GameConfiguration {
//
//    @Bean
//    public GameConsole starcraft(){
//        return new StarCraft();
//    }
//    @Bean
//    @Primary
//    public GameConsole lol(){
//        return new LOL();
//    }
//
//    @Bean
//    public GameEngine gameEngine(GameConsole game){
//        return new GameEngine(game);
//    }
//
//}
