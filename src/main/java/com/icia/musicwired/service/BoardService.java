package com.icia.musicwired.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.icia.musicwired.dto.BoardDTO;
import com.icia.musicwired.dto.BoardLikeDTO;

public interface BoardService {

	ModelAndView boardUpload(BoardDTO board) throws IllegalStateException, IOException;

	ModelAndView boardList();

	ModelAndView boardModiForm(int boCode);

	List<BoardDTO> ajaxBoardList();

	List<BoardDTO> boLikeUp(int boCode);

	List<BoardDTO> boLikeDown(int boCode);

	ModelAndView boardModify(BoardDTO board) throws IllegalStateException, IOException;

	ModelAndView boardDelete(int boCode);

	List<BoardLikeDTO> boLikeInsert(BoardLikeDTO boLike);

	List<BoardLikeDTO> boLikeCheck(BoardLikeDTO boLike);

	List<BoardLikeDTO> boLikeDelete(BoardLikeDTO boLike);

	List<BoardDTO> ajaxBoardSelect(String boTitle);

	ModelAndView boardWriterView(String boWriter, String mId);

	List<BoardDTO> LikeBoardList(String bolMid);

	List<BoardDTO> boardListUserList(int bolBoCode);

	List<BoardDTO> myBoardList(String boWriter);

	List<BoardDTO> ajaxBoardDelete(int boCode);

	List<BoardDTO> followedBoardList(String bolMid);

	List<BoardDTO> myBoardList2(String bolMid);

}
