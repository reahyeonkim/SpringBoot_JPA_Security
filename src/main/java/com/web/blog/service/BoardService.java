package com.web.blog.service;

import com.web.blog.domain.Board;

import com.web.blog.domain.User;
import com.web.blog.dto.ReplySaveRequestDto;
import com.web.blog.repository.BoardRepository;

import com.web.blog.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;

    @Transactional
    public void 글쓰기(Board board,User user) {
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }
    @Transactional(readOnly = true)
    public Page<Board> 글목록(Pageable pageable){
       return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Board 글상세보기(int id){
        return boardRepository.findById(id).orElseThrow(()->{
                return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을수없습니다.");
        });
    }
    @Transactional
    public void 글삭제하기(int id){
        System.out.println("글삭제하기"+ id);
        boardRepository.findById(id);
    }

    public void 글수정하기(int id, Board requestBoard){
        Board board = boardRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을수없습니다.");
        });//영속화
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
        //더티체킹 - 자동 업데이트 DB commit
    }

    @Transactional
    public void 댓글쓰기(ReplySaveRequestDto replySaveRequestDto) {
        int result = replyRepository.mSave(replySaveRequestDto.getUserId(), replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent());
        System.out.println("BoardService : "+result);
    }

    @Transactional
    public void 댓글삭제(int replyId) {
        replyRepository.deleteById(replyId);
    }
}