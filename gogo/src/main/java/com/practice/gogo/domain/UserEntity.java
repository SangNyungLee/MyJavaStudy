package com.practice.gogo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.usertype.UserType;

@Entity // DB 테이블에 대응되는 하나의 클래스
@Table(name="userz") //name을 안 적으면 밑에 있는 UserEntity로 테이블이 생성된다.
@Getter
@Setter
public class UserEntity {
    @Id // Entity가 만들어지기 위해서는 pk가 꼭 필요하다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment로 설정해라
    private int id;
    @Column(name="name", nullable = false, length = 20)
    private String name;

    @Column
    private String nickname;

    @Column
    @Enumerated(EnumType.STRING) //ORDINAL도 있는데 잘 안씀
    private UserType type;

    public enum UserType{
        STUDENT, TEACHER
    }
}
