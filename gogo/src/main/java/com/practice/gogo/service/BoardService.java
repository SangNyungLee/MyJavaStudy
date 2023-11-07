package com.practice.gogo.service;

import com.practice.gogo.domain.Board;
import com.practice.gogo.dto.BoardDTO;
import com.practice.gogo.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService   {

    @Autowired
    BoardMapper boardMapper;

    public List<Board> getBoardList(){
        List<Board> result = boardMapper.selectAllBoard();
        List<BoardDTO> board = new ArrayList<BoardDTO>();

        for(int i=0; i<result.size() ; i++){
            Board res = result.get(i);
            BoardDTO val = BoardDTO.builder()
                    .id(res.getId())
                    .title(res.getTitle())
                    .content(res.getContent())
                    .writer(res.getWriter())
                    .registered(res.getRegistered())
                    .build();
            board.add(val);
        }
        return result;
    }
}
