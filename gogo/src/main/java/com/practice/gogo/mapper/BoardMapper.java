package com.practice.gogo.mapper;


import com.practice.gogo.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("select * from board")
    List<Board> selectAllBoard();
}
