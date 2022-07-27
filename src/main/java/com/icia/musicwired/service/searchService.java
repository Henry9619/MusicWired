package com.icia.musicwired.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.icia.musicwired.dto.serchDTO;
import com.icia.musicwired.dto.uploadDto;



public interface searchService {

	ModelAndView search(String keyword);

	/*
	 * ModelAndView songSearch(String keyword,int page,int limit);
	 * 
	 * ModelAndView singerSearch(String keyword,int page,int limit);
	 */

	List<serchDTO> test(); 

	

	Map<String, Object> search2( int page, int limit,String keyword);

	Map<String, Object> search1( int page, int limit,String keyword);

}
