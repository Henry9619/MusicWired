package com.icia.musicwired.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.icia.musicwired.dto.MusicCommentDTO;
import com.icia.musicwired.service.MusicCommentService;

@Controller
public class MusicCommentController {

	private ModelAndView mav = new ModelAndView();


	@Autowired
	private MusicCommentService svc;
	List<MusicCommentDTO> commentList = new ArrayList<MusicCommentDTO>();

	// mcList
	@PostMapping("mcList")
	public @ResponseBody List<MusicCommentDTO> mcList(@RequestParam(value = "mcCode", required = true) int mcCode) {
//		System.out.println("1.comm : " + mcCode);
		commentList = svc.mcList(mcCode);
//		System.out.println("4.comm : " + commentList);
		return commentList;

	}

	// mcWrite 댓글 등록
	@PostMapping("mcWrite")
	public @ResponseBody List<MusicCommentDTO> mcWrite(@ModelAttribute MusicCommentDTO mcomm) {
		commentList = svc.mcWrite(mcomm);

		return commentList;

	}

	// mcModify 댓글 수정
	@PostMapping("mcModify")
	public @ResponseBody List<MusicCommentDTO> mcModify(@ModelAttribute MusicCommentDTO mcomm) {

//		System.out.println("1 수정" + mcomm);
		commentList = svc.mcModify(mcomm);
//		System.out.println("4 수정 " + commentList);
		return commentList;

	}

	@PostMapping("mcDelete")
	public @ResponseBody List<MusicCommentDTO> mcDelete(@ModelAttribute MusicCommentDTO mcomm) {

//		System.out.println("1 수정" + mcomm);
		commentList = svc.mcDelete(mcomm);
//		System.out.println("4 수정 " + commentList);
		return commentList;

	}


}
