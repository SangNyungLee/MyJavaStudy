package com.practice.gogo.controller;

import com.practice.gogo.domain.Board;
import com.practice.gogo.dto.BoardDTO;
import com.practice.gogo.mapper.BoardMapper;
import com.practice.gogo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findWriter")
    public String findBoard(@RequestParam("name") String name, Model model){
        List<Board> findBoardList = boardService.findBoardList(name);
        model.addAttribute("list",findBoardList);
        return "board2";
    }

    @PostMapping("/mysubmit")
    @ResponseBody
    public boolean writeBoard(@RequestBody BoardDTO boardDTO){
        boardService.insertBoard(boardDTO);
        return true;
    }

    @PostMapping("/updateContent")
    @ResponseBody
    public boolean updateBoard(@RequestBody BoardDTO boardDTO){
        boardService.updateBoard(boardDTO);
        return true;
    }
    @GetMapping("/deleteContent")
    @ResponseBody
    public boolean deleteBoard(@RequestParam("id") String id){
        System.out.println("??????????????" + id);
        boardService.deleteBoard(id);
        return true;
    }


}
