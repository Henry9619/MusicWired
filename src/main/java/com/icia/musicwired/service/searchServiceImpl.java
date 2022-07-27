package com.icia.musicwired.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.musicwired.dao.searchDAO;
import com.icia.musicwired.dto.pagingDto;
import com.icia.musicwired.dto.serchDTO;
import com.icia.musicwired.dto.uploadDto;


@Service
public class searchServiceImpl implements searchService {

	@Autowired
	private searchDAO dao;
	
	@Override
	public ModelAndView search(String keyword) {
		
	    ModelAndView mav= new ModelAndView();
		
		
		
		int result=dao.searchInsert(keyword);
		
		
		
		
		

		int nCount=dao.search2(keyword);

		int sCount=dao.search3(keyword);
		
		if(nCount==0 && sCount==0 ) {
			
		//	mav.addObject("searchRank",searchRank);
			mav.setViewName("noSearch");
			mav.addObject("keyword",keyword);
		}else {
	
	//	mav.addObject("searchRank",searchRank);
		mav.setViewName("Search");
		mav.addObject("nCount",nCount);
		mav.addObject("sCount",sCount);
		mav.addObject("keyword",keyword);
		}
		
		
	
			
			
		return mav;
	}

	/*
	 * @Override public ModelAndView songSearch(String keyword,int page, int limit)
	 * {
	 * 
	 * ModelAndView mav=new ModelAndView();
	 * 
	 * int block = 5;
	 * 
	 * int nCount=dao.search2(keyword);
	 * 
	 * int startRow = (page - 1) * limit + 1; int endRow = page * limit;
	 * 
	 * int maxPage = (int) (Math.ceil((double) nCount/ limit)); // Math.ceil 올림 int
	 * startPage = (((int) (Math.ceil((double) page / block))) - 1) * block + 1; int
	 * endPage = startPage + block - 1; // 오류 방지 if (endPage > maxPage) { endPage =
	 * maxPage;
	 * 
	 * } pagingDto paging = new pagingDto();
	 * 
	 * paging.setPage(page); paging.setStartRow(startRow); paging.setEndRow(endRow);
	 * paging.setMaxPage(maxPage); paging.setStartPage(startPage);
	 * paging.setEndPage(endPage); paging.setLimit(limit); paging.setmId(keyword);
	 * 
	 * System.out.println("페이지 디티오값 :"+paging);
	 * 
	 * List<uploadDto>searchList=dao.songSearch(paging);
	 * 
	 * System.out.println("서치리스트 : "+searchList);
	 * System.out.println("페이징 디티오2 : "+paging);
	 * 
	 * mav.addObject("nCount",nCount); mav.addObject("search",searchList);
	 * mav.addObject("paging",paging); mav.setViewName("songSearch");
	 * 
	 * return mav; }
	 */

	/*
	 * @Override public ModelAndView singerSearch(String keyword,int page, int
	 * limit) {
	 * 
	 * ModelAndView mav=new ModelAndView();
	 * 
	 * int block = 5;
	 * 
	 * int nCount=dao.search3(keyword);
	 * 
	 * int startRow = (page - 1) * limit + 1; int endRow = page * limit;
	 * 
	 * int maxPage = (int) (Math.ceil((double) nCount/ limit)); // Math.ceil 올림 int
	 * startPage = (((int) (Math.ceil((double) page / block))) - 1) * block + 1; int
	 * endPage = startPage + block - 1; // 오류 방지 if (endPage > maxPage) { endPage =
	 * maxPage;
	 * 
	 * } pagingDto paging = new pagingDto();
	 * 
	 * paging.setPage(page); paging.setStartRow(startRow); paging.setEndRow(endRow);
	 * paging.setMaxPage(maxPage); paging.setStartPage(startPage);
	 * paging.setEndPage(endPage); paging.setLimit(limit); paging.setmId(keyword);
	 * 
	 * List<uploadDto>singerList=dao.singerSearch(paging);
	 * 
	 * 
	 * mav.addObject("nCount",nCount); mav.addObject("singerList",singerList);
	 * mav.addObject("paging",paging); mav.setViewName("singerSearch");
	 * 
	 * return mav; }
	 */

		//테스트
	List<serchDTO>searchRank=new ArrayList<serchDTO>();
	List<uploadDto> search1  = new ArrayList<uploadDto>();
	@Override
	public List<serchDTO> test() {
		
			
		searchRank=dao.searchRank();
		
		
		return searchRank;
	}
	@Override
	public Map<String, Object>search1(int page, int limit,String keyword) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		int block = 5;

		// 전체 회원수
		//int mCount = bdao.mCount();
		
		// 전체 음원목록 갯수
		int muListCount = dao.search2(keyword);

		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;

		int maxPage = (int) (Math.ceil((double) muListCount / limit)); // Math.ceil 올림 //수정 해야하지 않나?
		int startPage = (((int) (Math.ceil((double) page / block))) - 1) * block + 1;
		int endPage = startPage + block - 1;
		//오류 방지
		if(endPage > maxPage) { 
			endPage = maxPage;
			
		}
		
		pagingDto paging = new pagingDto();

		paging.setPage(page);
		paging.setStartRow(startRow);
		paging.setEndRow(endRow);
		paging.setMaxPage(maxPage);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setLimit(limit);
		paging.setKeyword(keyword);		
		
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		search1=dao.search10(paging);

//		System.out.println("!~!!@!@!@!@!@!@!@!@!@"+search1);
		
		result.put("search1",search1);
		result.put("paging",paging);
		
		return result;

	}

	List<uploadDto> search2  = new ArrayList<uploadDto>();
	@Override
	public Map<String, Object>search2(int page, int limit,String keyword) {
		Map<String, Object> result2 = new HashMap<String, Object>();
	
		
		
		int block = 5;

		// 전체 회원수
		//int mCount = bdao.mCount();
		
		// 전체 음원목록 갯수
		int muListCount = dao.search3(keyword);

		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;

		int maxPage = (int) (Math.ceil((double) muListCount / limit)); // Math.ceil 올림 //수정 해야하지 않나?
		int startPage = (((int) (Math.ceil((double) page / block))) - 1) * block + 1;
		int endPage = startPage + block - 1;
		//오류 방지
		if(endPage > maxPage) { 
			endPage = maxPage;
			
		}
		
		pagingDto paging = new pagingDto();

		paging.setPage(page);
		paging.setStartRow(startRow);
		paging.setEndRow(endRow);
		paging.setMaxPage(maxPage);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setLimit(limit);
		paging.setKeyword(keyword);		
		
		search2=dao.search11(paging);

		
		result2.put("search2",search2);
		result2.put("paging",paging);
		
		return result2;
	}
}


	
	

