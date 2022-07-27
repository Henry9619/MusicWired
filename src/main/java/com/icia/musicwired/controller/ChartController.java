package com.icia.musicwired.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.musicwired.dto.uploadDto;
import com.icia.musicwired.service.ChartService;

@Controller
public class ChartController {

	private ModelAndView mav= new ModelAndView();
	List<uploadDto> hitChart  = new ArrayList<uploadDto>();
	List<uploadDto> GenreChart  = new ArrayList<uploadDto>();
	
	
	@Autowired 
	private ChartService csv;
	
	// chart 차트 페이지로 이동
	@RequestMapping(value="/chart", method = RequestMethod.GET)
	public String chart() {
		return "Chart";
	}
	
	// hitChart 조회수차트 페이지로 이동
	@RequestMapping(value="/hitChart", method = RequestMethod.POST)
	public @ResponseBody List<uploadDto> hitChart(){
		hitChart = csv.hitChart();
		
		
		return hitChart;
	}
	
	// likeChart 좋아요차트 패이지로 이동
	@RequestMapping(value="/likeChart", method = RequestMethod.POST)
	public @ResponseBody List<uploadDto> likeChart(){
		hitChart = csv.likeChart();
		
		
		return hitChart;
	}
	
	// genre 장르 페이지 이동
	@RequestMapping(value="/genre", method = RequestMethod.GET)
	public String genre() {
		return "Genre";
	}
	
	// balGenre 발라드차트 페이지로 이동
	@RequestMapping(value="/balGenre", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> GenreChart(@RequestParam(value="page", required = false, defaultValue = "1")int page,
		@RequestParam(value="limit", required = false, defaultValue = "10")int limit) {
		 Map<String, Object> result = new HashMap<String, Object>();
		 result=csv.balgenre(page,limit);//페이지 ,장르
		
		return result;
	}
	
	// danceGenre 댄스차트 페이지로 이동
	@RequestMapping(value="/danceGenre", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>danceGenre(@RequestParam(value="page", required = false, defaultValue = "1")int page,
			@RequestParam(value="limit", required = false, defaultValue = "10")int limit) {
		 Map<String, Object> result = new HashMap<String, Object>();
			
			result=csv.danceGenre(page,limit);//페이지 ,장르
			
			return result;
}
	// rockGenre 록차트 페이지로 이동
	@RequestMapping(value="/rockGenre", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>rockGenre(@RequestParam(value="page", required = false, defaultValue = "1")int page,
			@RequestParam(value="limit", required = false, defaultValue = "10")int limit) {
		 Map<String, Object> result = new HashMap<String, Object>();
			
			result=csv.rockGenre(page,limit);//페이지 ,장르
			
			return result;
}
	// hiphopGenre 힙합차트 페이지로 이동
	@RequestMapping(value="/hiphopGenre", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>hiphopGenre(@RequestParam(value="page", required = false, defaultValue = "1")int page,
			@RequestParam(value="limit", required = false, defaultValue = "10")int limit) {
		 Map<String, Object> result = new HashMap<String, Object>();
			
			result=csv.hiphopGenre(page,limit);//페이지 ,장르
			
			return result;
}
	// indiGenre 인디차트 페이지로 이동
	@RequestMapping(value="/indiGenre", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>indiGenre(@RequestParam(value="page", required = false, defaultValue = "1")int page,
			@RequestParam(value="limit", required = false, defaultValue = "10")int limit) {
		 Map<String, Object> result = new HashMap<String, Object>();
			
			result=csv.indiGenre(page,limit);//페이지 ,장르
			
			return result;
}
	// gitaGenre 기타차트 페이지로 이동
	@RequestMapping(value="/gitaGenre", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>gitaGenre(@RequestParam(value="page", required = false, defaultValue = "1")int page,
			@RequestParam(value="limit", required = false, defaultValue = "10")int limit) {
		 Map<String, Object> result = new HashMap<String, Object>();
			
			result=csv.gitaGenre(page,limit);//페이지 ,장르
			
			return result;
}
	
}
	
	


