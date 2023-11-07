package com.mybatis.kdt9.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {
    private int id;
    private String name;
    private String nickname;
    private int no;
}
