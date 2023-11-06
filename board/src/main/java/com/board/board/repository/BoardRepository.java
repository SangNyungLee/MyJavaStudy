package com.board.board.repository;

import com.board.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    BoardEntity findByAuthor(String author); //SELECT 문(?)
}
