package com.mybatis.kdt9.mapper;

import com.mybatis.kdt9.domain.Board;
import com.mybatis.kdt9.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> getBoardAll(); //전체 조회

    void insertBoard(Board board); //삽입(insert)

    void patchBoard(BoardDTO boardDTO); // 수정(update)

    void deleteBoard(int id);

    List<Board> searchBoard(String word);
}
// mapper에는 있지만, xml에는 없는 경우 -> 실행했을 때만 오류가 남
// xml에는 있지만, mapper에는 없는 경우 -> 실행 자체가 안된다.
