package com.practice.gogo.mapper;


import com.practice.gogo.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("select * from board")
    List<Board> selectAllBoard();

    @Insert("insert into board(title, content, writer) values(#{title}, #{content}, #{writer})")
    void insertBoard(Board board);


    @Update("update board set title =#{title}, content=#{content}, writer=#{writer} where id = #{id}")
    void updateBoard(Board board);

    @Delete("delete from board where id = #{id}")
    void deleteBoard(int id);

    @Select("select * from board where writer=#{name}")
    List<Board> findBoard(String name);
}
