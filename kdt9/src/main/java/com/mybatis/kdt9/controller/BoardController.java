package com.mybatis.kdt9.controller;

import com.mybatis.kdt9.domain.Board;
import com.mybatis.kdt9.dto.BoardDTO;
import com.mybatis.kdt9.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/board")
    public String getBoards(Model model) {
        List<BoardDTO> list = boardService.getBoardAll();
        model.addAttribute("list", list);
        return "board";
    }

    @GetMapping("/board/search")
    public int searchBoard(@RequestParam("word") String word) {
        // select - 조건에 따라 다른 결과를 return
        return boardService.searchBoard(word);
//        List<BoardDTO> list = boardService.searchBoard(word);
//        model.addAttribute("list", list);
    }

    @PostMapping("/board")
    @ResponseBody
    public void insertBoard(@RequestBody Board board) {
        boardService.insertBoard(board);
    }

    @PatchMapping("/board")
    public void patchBoard(@RequestBody BoardDTO boardDTO) {
        boardService.patchBoard(boardDTO);
    }

    @DeleteMapping("/board")
    @ResponseBody
    public void deleteBoard(@RequestParam int id) {
        boardService.deleteBoard(id);
    }
}
