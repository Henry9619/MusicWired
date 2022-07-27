package com.icia.musicwired.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.musicwired.dao.subDAO;
import com.icia.musicwired.dto.MemberDTO;
import com.icia.musicwired.dto.subDTO;

@Service
public class subServiceImpl implements subService {

	@Autowired
	private subDAO dao;

	List<subDTO> subList = new ArrayList<subDTO>();
	List<MemberDTO> memList = new ArrayList<MemberDTO>();

	@Override
	public int subreg(subDTO sub) {

		int result = dao.subreg(sub);
		int addCount = dao.addCount(sub);

		return addCount;
	}

	@Override
	public int subcancel(subDTO sub) {
		int result = dao.subcancel(sub);
		int minusCount = dao.minusCount(sub);

		return minusCount;
	}

	@Override
	public List<subDTO> submodalList(String sserMid) {
		subList = dao.submodalList(sserMid);

		return subList;

	}

	@Override
	public List<subDTO> subermodalList(String ssMid) {
//		System.out.println("[2] 내가 구독 S : " + ssMid);
		subList = dao.subermodalList(ssMid);
//		System.out.println("[3] 내가 구독 S : " + subList);
		return subList;

	}



}
