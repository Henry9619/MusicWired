package com.icia.musicwired.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.musicwired.dao.DownDAO;
import com.icia.musicwired.dto.DownDTO;

@Service
public class DownServiceImpl implements DownService{
	
	@Autowired
	private DownDAO downdao;
	
	List<DownDTO> downList = new ArrayList<DownDTO>();

//	downloadTableInsert : 다운로드 테이블 등록 메소드
	@Override
	public List<DownDTO> downloadTableInsert(DownDTO down) {
//		System.out.println("[2] 다운로드 테이블 등록 S : " + down);
		int result = downdao.downloadTableInsert(down);
//		System.out.println("[3] 다운로드 테이블 등록 S : " + result);
		if(result > 0) {
			
		}else {
			downList = null;
		}
		return downList;
	}

//	ajaxDownList : 다운로드 목록 출력 메소드
	@Override
	public List<DownDTO> ajaxDownList(String mudMid) {
//		System.out.println("[2] 다운로드 목록 출력 S : " + mudMid);
		List<DownDTO> Down = downdao.ajaxDownList(mudMid);
//		System.out.println("[3] 다운로드 목록 출력 S : " + Down);
		
		if(Down != null) {
			downList = Down;
		}else {
			downList = null;
		}
		return downList;
	}

}
