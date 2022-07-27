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

import com.icia.musicwired.dto.DownDTO;
import com.icia.musicwired.service.DownService;

@Controller
public class DownController {
	
	@Autowired
	private DownService downsvc;
	
	List<DownDTO> downList = new ArrayList<DownDTO>();
	
//	downloadTableInsert : 다운로드 테이블에 등록하는 메소드
	@PostMapping("downloadTableInsert")
	public @ResponseBody List<DownDTO> downloadTableInsert(@ModelAttribute DownDTO down){
//		System.out.println("[1] 다운로드 테이블 등록 C : " + down);
		downList = downsvc.downloadTableInsert(down);
//		System.out.println("[4] 다운로드 테이블 등록 C : " + downList);
		return downList;
	}
	
//	downListPage : 다운로드 페이지 이동
	@GetMapping("downListPage")
	public String downListPage() {
		return "down_List";
	}
	
//	downList : 다운로드 리스트 출력 메소드
	@PostMapping("ajaxDownList")
	public @ResponseBody List<DownDTO> ajaxDownList(@RequestParam("mudMid") String mudMid){
//		System.out.println("[1] 다운로드 목록 출력 C : " + mudMid);
		downList = downsvc.ajaxDownList(mudMid);
//		System.out.println("[4] 다운로드 목록 출력 C : " + downList);
		return downList;
	}
	

}
