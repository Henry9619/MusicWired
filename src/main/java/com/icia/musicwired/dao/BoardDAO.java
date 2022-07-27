package com.icia.musicwired.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.icia.musicwired.dto.BoardDTO;
import com.icia.musicwired.dto.BoardLikeDTO;
import com.icia.musicwired.dto.subDTO;

@Mapper
public interface BoardDAO {

//	boardUpload : 게시글 업로드 메소드
	int boardUpload(BoardDTO board);

	List<BoardDTO> boardList();

	BoardDTO boardModiView(int boCode);

	List<BoardDTO> ajaxBoardList();

	int boLikeUp(int boCode);

	List<BoardDTO> ajaxBoardListSelect(int boCode);

	int boLikeDown(int boCode);

	int boardModify(BoardDTO board);

	int boardDelete(int boCode);

	int boLikeInsert(BoardLikeDTO boLike);

	List<BoardLikeDTO> boLikeCheck(BoardLikeDTO boLike);

	int boLikeDelete(BoardLikeDTO boLike);

	List<BoardDTO> ajaxBoardSelect(String boTitle);

	List<BoardDTO> boardWriterView(String boWriter);

	List<BoardDTO> LikeBoardList(String bolMid);

	List<BoardDTO> boardListUserList(int bolBoCode);

	int memCount(String boWriter);

	String subCheck(String boWriter, String mId);

	int memCount1(String boWriter);

	int muTrack(String boWriter);

	int boaCount(String boWriter);

	List<BoardDTO> myBoardList(String boWriter);

	int ajaxBoardDelete(int boCode);
	int boLikeUp(BoardLikeDTO boardLike);

	List<BoardDTO> followedBoardList(String bolMid);

	List<BoardDTO> myBoardList2(String bolMid);

	
}
