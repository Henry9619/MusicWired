package com.icia.musicwired.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.musicwired.dto.trackShareDTO;
import com.icia.musicwired.service.trackShareService;

@Controller
public class trackShareController {
	
	List<trackShareDTO> trackList = new ArrayList<trackShareDTO>();
	private ModelAndView mav = new ModelAndView();
	@Autowired
	private trackShareService svc;
	
	@PostMapping("/trackShare")
	public @ResponseBody List<trackShareDTO> trackShare(@RequestParam("tsMid") String tsMid) {
//		System.out.println("[1] 트랙 주입 c: " + tsMid);

		trackList = svc.trackShare(tsMid);

//		System.out.println("[4] 트랙 주입 c: " + trackList);

		return trackList;
	}
	//trackShareSearch : 굥유했는지 확인하는 메소드
	@PostMapping("/trackShareSearch")
	public @ResponseBody List<trackShareDTO> trackShareSearch(@RequestParam("tsMid") String tsMid) {
//		System.out.println("[1] 트랙 확인 c: " + tsMid);

		trackList = svc.trackShareSearch(tsMid);

//		System.out.println("[4] 트랙 확인 c: " + trackList);

		return trackList;
	}
	//공유한 트랙 리스트 띄우는 메소드
	@GetMapping("track")
	public ModelAndView track() {
		mav = svc.track();
		
		return mav;
	}
	
	
}
