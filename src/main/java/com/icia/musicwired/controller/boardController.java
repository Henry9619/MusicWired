package com.icia.musicwired.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.musicwired.dto.BoardDTO;
import com.icia.musicwired.dto.BoardLikeDTO;
import com.icia.musicwired.service.BoardService;

@Controller
public class boardController {
	// asd
	private ModelAndView mav = new ModelAndView();
	@Autowired
	private HttpSession session;
	@Autowired
	private BoardService bosvc;

	List<BoardDTO> boardList = new ArrayList<BoardDTO>();
	List<BoardLikeDTO> boardLike = new ArrayList<BoardLikeDTO>();

//	boardUploadPage : 게시글 업로드 페이지 이동 메소드
	@GetMapping("/boardUploadPage")
	public String boardUploadPage() {
		return "board_UploadPage";
	}
	

//	boardUpload : 게시글 업로드 메소드
	@PostMapping("/boardUpload")
	public ModelAndView boardUpload(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
//		System.out.println("[1] 업로드 C : " + board);

		mav = bosvc.boardUpload(board);

//		System.out.println("[4] 업로드 C : " + mav);

		return mav;
	}

//	boardList : 게시글 목록 메소드
	@GetMapping("/boardList")
	public ModelAndView boardList() {

		mav = bosvc.boardList();

		return mav;
	}

//	boardModiForm : 게시글 수정페이지 이동 메소드
	@GetMapping("/boardModiForm") 
	public ModelAndView boardModiForm(@RequestParam("boCode") int boCode) {
//		System.out.println("[1] 수정페이지 C : " + boCode);
		mav = bosvc.boardModiForm(boCode);
//		System.out.println("[4] 수정페이지 C : " + mav);
		return mav;
	}

//	boardModify : 게시글 수정 메소드
	@PostMapping("/boardModify")
	public ModelAndView boardModify(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
//		System.out.println("[1] 수정 C : " + board);
		mav = bosvc.boardModify(board);
//		System.out.println("[4] 수정 C : " + mav);
		return mav;
	}

//	boardDelete : 게시글 삭제 메소드
	@GetMapping("/boardDelete")
	public ModelAndView boardDelete(@RequestParam("boCode") int boCode) {
//		System.out.println("[1] 삭제 C : " + boCode);
		mav = bosvc.boardDelete(boCode);
//		System.out.println("[4] 삭제 C : " + mav);
		return mav;
	}

//	ajaxBoardList : 게시글 리스트 메소드(ajax)
	@PostMapping("/ajaxBoardList")
	public @ResponseBody List<BoardDTO> ajaxBoardList() {

		boardList = bosvc.ajaxBoardList();

		return boardList;
	}

//	boLikeUp : 게시글 좋아요 증가(ajax)
	@PostMapping("/boLikeUp")
	public @ResponseBody List<BoardDTO> boLikeUp(@RequestParam("boCode") int boCode) {
//		System.out.println("[1] 좋아요증가 C : " + boCode);

		boardList = bosvc.boLikeUp(boCode);

//		System.out.println("[4] 좋아요증가 C : " + boardList);

		return boardList;
	}

//	boLikeDown : 게시글 좋아요 감소(ajax)
	@PostMapping("/boLikeDown")
	public @ResponseBody List<BoardDTO> boLikeDown(@RequestParam("boCode") int boCode) {
//		System.out.println("[1] 좋아요감소 C : " + boCode);
		boardList = bosvc.boLikeDown(boCode);
//		System.out.println("[4] 좋아요감소 C : " + boardList);
		return boardList;
	}

//	boLikeInsert : 게시글 좋아요 테이블에 좋아요한 게시글 등록(ajax)
	@PostMapping("boLikeInsert")
	public @ResponseBody List<BoardLikeDTO> boLikeInsert(@ModelAttribute BoardLikeDTO boLike) {
//		System.out.println("[1] 좋아요 테이블 등록 C : " + boLike);
		boardLike = bosvc.boLikeInsert(boLike);
//		System.out.println("[4] 좋아요 테이블 등록 C : " + boardLike);
		return boardLike;
	}

//	boLikeCheck : 좋아요한 게시글 목록 불러오기 메소드(ajax)
	@PostMapping("boLikeCheck")
	public @ResponseBody List<BoardLikeDTO> boLikeCheck(@ModelAttribute BoardLikeDTO boLike) {
//		System.out.println("[1] 좋아요 게시글 목록 불러오기 C : " + boLike);
		boardLike = bosvc.boLikeCheck(boLike);
//		System.out.println("[4] 좋아요 게시글 목록 불러오기 C : " + boardLike);
		return boardLike;
	}

//	boLikeDelete : 게시글 좋아요 테이블에 등록된 게시글 삭제[좋아요취소](ajax)
	@PostMapping("boLikeDelete")
	public @ResponseBody List<BoardLikeDTO> boLikeDelete(@ModelAttribute BoardLikeDTO boLike) {
//		System.out.println("[1] 좋아요 테이블 삭제 C : " + boLike);
		boardLike = bosvc.boLikeDelete(boLike);
//		System.out.println("[4] 좋아요 테이블 삭제 C : " + boardLike);

		return boardLike;
	}

//	ajaxBoardSelect : 게시글 제목으로 검색 메소드(ajax)
	@PostMapping("ajaxBoardSelect")
	public @ResponseBody List<BoardDTO> ajaxBoardSelect(@RequestParam("boTitle") String boTitle) {
//		System.out.println("[1] 게시글 제목검색 C : " + boTitle);
		boardList = bosvc.ajaxBoardSelect(boTitle);
//		System.out.println("[4] 게시글 제목검색 C : " + boardLike);
		return boardList;
	}

	@GetMapping("boardWriterView")
	   public ModelAndView boardWriterView(@RequestParam("boWriter") String boWriter,   
	         @RequestParam(value = "mId", required = false, defaultValue = "user") String mId){//로그인 안한 유저들도 볼수 있게 
	   
//	      System.out.println("[1] 게시글 작성자 피드 이동 C : " + boWriter);
	      mav = bosvc.boardWriterView(boWriter,mId);
	      
	      String value = (String)session.getAttribute("login.mId");
//	      System.out.println("세션아이디"+value);
	      
//	      System.out.println("[4] 게시글 작성자 피드 이동 C : " + mav);
	      return mav;
	   }
//	LikeBoardList : 좋아요한 게시글만 출력하는 메소드
	@PostMapping("LikeBoardList")
	public @ResponseBody List<BoardDTO> LikeBoardList(@RequestParam("boWriter") String bolMid) {
//		System.out.println("[1] 좋아요한 게시글 출력 C : " + bolMid);
		boardList = bosvc.LikeBoardList(bolMid);
//		System.out.println("[4] 좋아요한 게시글 출력 C : " + bolMid);
		return boardList;
	}
	
//	followedBoardList : 팔로우한 게시글만 출력하는 메소드
	@PostMapping("followedBoardList")
	public @ResponseBody List<BoardDTO> followedBoardList(@RequestParam("boWriter") String bolMid) {
//		System.out.println("[1] 좋아요한 게시글 출력 C : " + bolMid);
		boardList = bosvc.followedBoardList(bolMid);
//		System.out.println("[4] 좋아요한 게시글 출력 C : " + bolMid);
		return boardList;
	}	

//	myBoardList2 : 내 게시글만 출력하는 메소드
	@PostMapping("myBoardList2")
	public @ResponseBody List<BoardDTO> myBoardList2(@RequestParam("boWriter") String bolMid) {
//		System.out.println("[1] 좋아요한 게시글 출력 C : " + bolMid);
		boardList = bosvc.myBoardList2(bolMid);
//		System.out.println("[4] 좋아요한 게시글 출력 C : " + bolMid);
		return boardList;
	}	
	
	
//	boardListUserList : 게시글을 좋아요한 사람들을 출력하는 메소드
	@PostMapping("boardListUserList")
	public @ResponseBody List<BoardDTO> boardListUserList(@RequestParam("bolBoCode") int bolBoCode){
//		System.out.println("[1] 게시글을 좋아요한 사람들 C : " + bolBoCode);
		boardList = bosvc.boardListUserList(bolBoCode);
//		System.out.println("[4] 게시글을 좋아요한 사람들 C : " + boardList);
		return boardList;
	}
	

	
//	myBoardList : 내가 올린 게시글 출력 메소드(ajax)
	@PostMapping("myBoardList")
	public @ResponseBody List<BoardDTO> myBoardList(@RequestParam("boWriter") String boWriter){
//		System.out.println("[1] 내가 올린 게시글 리스트 C : " + boWriter);
		boardList = bosvc.myBoardList(boWriter);
//		System.out.println("[4] 내가 올린 게시글 리스트 C : " + boardList);
		return boardList;
	}
	
//	ajaxBoardDelete : 게시글 삭제(ajax)
	@PostMapping("ajaxBoardDelete")
	public @ResponseBody List<BoardDTO> ajaxBoardDelete(@RequestParam("boCode") int boCode){
//		System.out.println("[1] 게시글 삭제(ajax) C : " + boCode);
		boardList = bosvc.ajaxBoardDelete(boCode);
//		System.out.println("[4] 게시글 삭제(ajax) C : " + boardList);
		return boardList;
	}

}
