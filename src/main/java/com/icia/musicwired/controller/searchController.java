package com.icia.musicwired.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.musicwired.dto.BoardDTO;
import com.icia.musicwired.dto.serchDTO;
import com.icia.musicwired.dto.uploadDto;
import com.icia.musicwired.service.searchService;



@Controller
public class searchController {
	
	@Autowired
	private searchService ssvc;
	
	//검색 페이지로 이동
	@GetMapping("/search")
	public ModelAndView search(@RequestParam("keyword") String keyword) {
		
		ModelAndView mav=new ModelAndView();
		
//		System.out.println("확인");
		
		mav=ssvc.search(keyword);
		
//		System.out.println("검색 c : "+mav);
		
		return mav;
	}
	List<uploadDto> search1  = new ArrayList<uploadDto>();
	
	@PostMapping("/search1") 
	public @ResponseBody Map<String,Object>search1(@RequestParam("keyword") String keyword,@RequestParam(value="page", required = false, defaultValue = "1")int page,
			@RequestParam(value="limit", required = false, defaultValue = "10")int limit){
//		System.out.println("search1");
		
		Map<String, Object> result = new HashMap<String, Object>();
		result = ssvc.search1(page,limit,keyword);
		
		
//		System.out.println("결과1: "+result );
		return result;
	}
	List<uploadDto> search2  = new ArrayList<uploadDto>();
	@PostMapping("/search2") 
	public @ResponseBody Map<String,Object> search2(@RequestParam("keyword") String keyword,@RequestParam(value="page", required = false, defaultValue = "1")int page,
			@RequestParam(value="limit", required = false, defaultValue = "10")int limit){
//		System.out.println("search1");
		Map<String, Object> result2 = new HashMap<String, Object>();
		result2 = ssvc.search2(page,limit,keyword);
		
//		System.out.println("검색2 : "+page+","+limit+","+keyword);
		
		//System.out.println("hit!! : "+hitChart);
//		System.out.println("결과2"+result2);
		return result2;
	}
	
	
	List<serchDTO>searchRank=new ArrayList<serchDTO>();
	//테스트 
	@PostMapping("/test")
	public @ResponseBody List<serchDTO> test() {
		
		
		
		searchRank=ssvc.test();
		
		return searchRank;
	}

	
	
	//음악 제목 검색 더보기
	/*
	 * @GetMapping("/songSearch") public ModelAndView
	 * songSearch(@RequestParam(value="page",required=false,defaultValue="1")int
	 * page,
	 * 
	 * @RequestParam(value="limit",required=false,defaultValue="10")int limit,
	 * 
	 * @RequestParam("keyword")String keyword) { ModelAndView mav= new
	 * ModelAndView();
	 * 
	 * System.out.println("음악 제목 검색 c : "+keyword);
	 * 
	 * System.out.println("page c"+page); System.out.println("limit c"+limit);
	 * 
	 * mav=ssvc.songSearch(keyword,page,limit);
	 * 
	 * System.out.println("제목검색 mav c : "+mav);
	 * 
	 * return mav; }
	 * 
	 * //음악 가수 검색 더보기
	 * 
	 * @GetMapping("/singerSearch") public ModelAndView
	 * singerSearch(@RequestParam(value="page",required=false,defaultValue="1")int
	 * page,
	 * 
	 * @RequestParam(value="limit",required=false,defaultValue="10")int limit,
	 * 
	 * @RequestParam("keyword")String keyword) { ModelAndView mav= new
	 * ModelAndView();
	 * 
	 * System.out.println("음악 제목 검색 c : "+keyword);
	 * 
	 * mav=ssvc.singerSearch(keyword,page,limit);
	 * 
	 * return mav; }
	 */
		
	
	
	
	
}
