package com.mybatis.kdt9.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private int id;
    private String title, content, writer, registered;
    private String no;
}
