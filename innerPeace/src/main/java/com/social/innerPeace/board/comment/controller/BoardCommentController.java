package com.social.innerPeace.board.comment.controller;

import com.social.innerPeace.board.comment.service.BoardCommentService;
import com.social.innerPeace.dto.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/comment")
public class BoardCommentController {
    private final BoardCommentService boardCommentService;

    @PostMapping("/write")
    public ResponseEntity save(@RequestBody CommentDTO commentDTO, @SessionAttribute(name = "loginedHealer") String healer) {
        System.out.println("commentDTO = " + commentDTO);
        if (healer == null) {
            return null;
        }
        commentDTO.setHealerEmail(healer);
        Long saveResult = boardCommentService.save(commentDTO);
        if (saveResult != null) {
            return ResponseEntity.ok(saveResult);
        } else {
            return new ResponseEntity<>("해당 게시글이 존재하지 않습니다", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/modify")
    public ResponseEntity modify(@RequestBody CommentDTO commentDTO, @SessionAttribute(name = "loginedHealer") String healer) {
        System.out.println("commentDTO = " + commentDTO);
        if (healer == null) {
            return null;
        }
        commentDTO.setComment_content(healer);
//        Long modifyResult = boardCommentService.modify(commentDTO);
//        if (modifyResult != null){
//            return ResponseEntity.ok(modifyResult);
//        }else {
//            return new ResponseEntity<>("해당 글은 수정 하지 못 했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        return new ResponseEntity<>("해당 글은 수정 하지 못 했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
    }


//    @DeleteMapping("/remove")
//    public ResponseEntity remove(@RequestBody CommentDTO commentDTO, @SessionAttribute(name = "loginedHealer") String healer) {
//        System.out.println("commentDTO = " + commentDTO);
//
//
//        return BoardCommentService.remove(commentDTO) ==1
//                ?new ResponseEntity<>("success",HttpStatus.OK)
//                :new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);


}
