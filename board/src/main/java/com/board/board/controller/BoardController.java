package com.board.board.controller;

import com.board.board.dto.BoardDTO;
import com.board.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    //게시판 글 작성
    @PostMapping("/register")
    @ResponseBody
    public boolean postRegister(@RequestBody BoardDTO boardDTO){
        return boardService.createPost(boardDTO);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<BoardDTO> getAllBoard(){
        return boardService.findAllBoard();
    }

    //수정
    @PatchMapping("/update")
    @ResponseBody
    public boolean patchUpdate(@RequestBody BoardDTO boardDTO){
        return boardService.updateBoard(boardDTO);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public boolean boardDelete(@RequestBody BoardDTO boardDTO){
        return boardService.deleteBoard(boardDTO);
    }
}
