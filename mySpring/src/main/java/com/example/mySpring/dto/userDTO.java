package com.example.mySpring.dto;

//@Getter
//@Setter
public class userDTO {
    //Data Transfer Object
    private String name;

    private String age;

    // getter와 setter을 만들거다. Generate > Getter and Setter
    // lombok (코드 다이어터)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
