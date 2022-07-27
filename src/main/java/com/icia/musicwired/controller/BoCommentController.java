package com.icia.musicwired.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.musicwired.dto.BoCommentDTO;
import com.icia.musicwired.service.BoCommentService;

@Controller
public class BoCommentController {

	@Autowired
	private BoCommentService bcsvc;
	List<BoCommentDTO> commentList = new ArrayList<BoCommentDTO>();
	
	@RequestMapping(value="bcList", method=RequestMethod.POST)
	public @ResponseBody List<BoCommentDTO> bcList(@RequestParam(value="bcBoCode", required = true)int bcBoCode){
//		System.out.println("[1] 댓글 목록 C : " + bcBoCode);
		
		commentList = bcsvc.bcList(bcBoCode);
//		System.out.println("[4] 댓글 목록 C : " + commentList);
		return commentList;
	}
	
	// bcWrite
	@RequestMapping(value="/bcWrite", method=RequestMethod.POST)
	public @ResponseBody List<BoCommentDTO> bcWrite(@ModelAttribute BoCommentDTO BoComment){
//		System.out.println("[1] 댓글 등록 C : " + BoComment);
		List<BoCommentDTO> commentList = new ArrayList<BoCommentDTO>();
		commentList = bcsvc.bcWrite(BoComment);
//		System.out.println("[4] 댓글 등록 C : " + commentList);
		return commentList;
	}
	
	// bcDelete
	@RequestMapping(value="/bcDelete", method=RequestMethod.POST)
	public @ResponseBody List<BoCommentDTO> bcDelete(@ModelAttribute BoCommentDTO BoComment){
//		System.out.println("[1] 댓글 삭제 C : " + BoComment);
		List<BoCommentDTO> commentList = new ArrayList<BoCommentDTO>();
		commentList = bcsvc.bcDelete(BoComment);
//		System.out.println("[4] 댓글 삭제 C : " + commentList);
		return commentList;
	}
	
}
