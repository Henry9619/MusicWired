package com.icia.musicwired.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.musicwired.dto.MemberDTO;
import com.icia.musicwired.dto.subDTO;
import com.icia.musicwired.service.subService;

@Controller
public class subController {


	@Autowired
	private subService svc;
	List<subDTO> subList = new ArrayList<subDTO>();
	List<MemberDTO> memList = new ArrayList<MemberDTO>();
	
	
	//팔로우 하기
	@PostMapping("subreg")
	public @ResponseBody int subreg(@ModelAttribute subDTO sub){
//		System.out.println(sub);
		
		int subList = svc.subreg(sub);
		
		return subList;
		
	}
	//팔로우 취소
	@PostMapping("subcancel")
	public @ResponseBody int subcancel(@ModelAttribute subDTO sub){
//		System.out.println(sub);
		
		int subList = svc.subcancel(sub);
		
		return subList;
		
	}
	//submodalList 구독자 목록 불러오기
	@PostMapping("submodalList")
	public @ResponseBody List<subDTO> submodalList(@RequestParam("sserMid")String sserMid){
//		System.out.println(sserMid);
		
		subList = svc.submodalList(sserMid);
		
		return subList;
		
	}
	//subermodalList 내가 구독한 구독자 목록 불러오기
		@PostMapping("subermodalList")
		public @ResponseBody List<subDTO> subermodalList(@RequestParam("ssMid")String ssMid){
//			System.out.println("[1] 내가 구독 C : "+ssMid);
			
			subList = svc.subermodalList(ssMid);
//			System.out.println("[4] 내가 구독 S : " + subList);
			return subList;
			
		}
		
	
}
