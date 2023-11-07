package com.practice.gogo.controller;

import com.practice.gogo.domain.Board;
import com.practice.gogo.dto.BoardDTO;
import com.practice.gogo.mapper.BoardMapper;
import com.practice.gogo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;


    @GetMapping("/")
    public String getBoard(Model model){
        List<Board> boards = boardService.getBoardList();
        model.addAttribute("list",boards);

        return "board";
    }

    @PostMapping("/write")
    @ResponseBody
    public boolean writeBoard(@RequestBody BoardDTO boardDTO){
        System.out.println("hi");
        return true;
    }
}
