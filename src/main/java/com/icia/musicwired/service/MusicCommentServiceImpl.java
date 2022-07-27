package com.icia.musicwired.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


import com.icia.musicwired.dao.MusicCommentDAO;
import com.icia.musicwired.dto.MusicCommentDTO;

@Service

public class MusicCommentServiceImpl implements MusicCommentService {

	private ModelAndView mav = new ModelAndView();

	@Autowired
	private MusicCommentDAO dao;

	List<MusicCommentDTO> commentList = new ArrayList<MusicCommentDTO>();


	@Override
	public List<MusicCommentDTO> mcList(int mcCode) {
//		System.out.println("2.comm : " + mcCode);
		commentList = dao.mcList(mcCode);
//		System.out.println("3.comm : " + commentList);
		return commentList;
	}

	@Override
	public List<MusicCommentDTO> mcWrite(MusicCommentDTO mcomm) {


		int result = dao.mcWrite(mcomm);

		if (result > 0) {
			commentList = dao.mcList(mcomm.getMcMuNum());
		} else {

			commentList = null;
		}
//		System.out.println("commentList : " + commentList);
		return commentList;
	}

	@Override
	public List<MusicCommentDTO> mcModify(MusicCommentDTO mcomm) {
		int result = dao.mcModify(mcomm);


		if (result > 0) {
			commentList = dao.mcList(mcomm.getMcMuNum());
		} else {

			commentList = null;
		}
		return commentList;
	}

	@Override
	public List<MusicCommentDTO> mcDelete(MusicCommentDTO mcomm) {
		int result = dao.mcDelete(mcomm);


		if (result > 0) {
			commentList = dao.mcList(mcomm.getMcMuNum());
		} else {

			commentList = null;
		}
		return commentList;
	}


}
