package com.icia.musicwired.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.musicwired.dao.BoCommentDAO;
import com.icia.musicwired.dto.BoCommentDTO;

@Service
public class BoCommentServiceImpl implements BoCommentService{

	@Autowired
	private BoCommentDAO bcdao;
	
	List<BoCommentDTO> commentList = new ArrayList<BoCommentDTO>();

	@Override
	public List<BoCommentDTO> bcList(int bcBoCode) {
		
//		System.out.println("[2] 댓글 목록 S : " + bcBoCode);
		commentList = bcdao.bcList(bcBoCode);
//		System.out.println("[3] 댓글 목록 S : " + commentList);
		return commentList;
	}

	@Override
	public List<BoCommentDTO> bcWrite(BoCommentDTO boComment) {
//		System.out.println("[2] 댓글 등록 S : " + boComment);
		List<BoCommentDTO> commentList = new ArrayList<BoCommentDTO>();
		int result = bcdao.bcWrite(boComment);
//		System.out.println("[3] 댓글 등록 S : " + result);
		if(result>0) {
			commentList = bcdao.bcList(boComment.getBcBoCode());
		} else {
			commentList = null;
		}
		return commentList;
	}

	@Override
	public List<BoCommentDTO> bcDelete(BoCommentDTO boComment) {
//		System.out.println("[2] 댓글 삭제 S : " + boComment);
		List<BoCommentDTO> commentList = new ArrayList<BoCommentDTO>();
		
		int result = bcdao.bcDelete(boComment);
//		System.out.println("[3] 댓글 삭제 S : " + result);
		if(result>0) {
			commentList = bcdao.bcList(boComment.getBcCode());
		} else {
			commentList = null;
		}
		
		return commentList;
	}
}