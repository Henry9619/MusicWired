package com.icia.musicwired.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.musicwired.dao.ChartDAO;
import com.icia.musicwired.dto.pagingDto;
import com.icia.musicwired.dto.uploadDto;

@Service
public class ChartServiceImpl implements ChartService{

	private ModelAndView mav=new ModelAndView();
	
	@Autowired
	private ChartDAO dao; 
	

	List<uploadDto> hitChart  = new ArrayList<uploadDto>();
	List<uploadDto> GenreChart  = new ArrayList<uploadDto>();
	

	@Override
	public List<uploadDto> hitChart() {
		
		hitChart=dao.hitChart();
		
		
		return hitChart;
	}

	@Override
	public List<uploadDto> likeChart() {
		
		hitChart = dao.likeChart();
		
		
		return hitChart;
	}
	//발라드 장르
	@Override
	public Map<String, Object>balgenre(int page, int limit) {
	
		 Map<String, Object> result = new HashMap<String, Object>();


		int block = 5;

		// 전체 회원수
		//int mCount = bdao.mCount();
		
		// 전체 음원목록 갯수
		int muListCount = dao.baladCount();

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
		
		
		GenreChart=dao.balgenre(paging);
		result.put("GenreChart",GenreChart);
		result.put("paging",paging);
		
		
		
		return result;
	}
	//댄스 장르
	@Override
	public Map<String, Object> danceGenre(int page, int limit) {

		 Map<String, Object> result = new HashMap<String, Object>();


		int block = 5;

		// 전체 회원수
		//int mCount = bdao.mCount();
		
		// 전체 음원목록 갯수
		int muListCount = dao.danceCount();

		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;

		int maxPage = (int) (Math.ceil((double) muListCount / limit)); // Math.ceil 올림 
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
		
		
		GenreChart=dao.danceGenre(paging);
		result.put("GenreChart",GenreChart);
		result.put("paging",paging);
		
		
		
		return result;
	}
	//락장르
	@Override
	public Map<String, Object> rockGenre(int page, int limit) {

		 Map<String, Object> result = new HashMap<String, Object>();


		int block = 5;

		// 전체 회원수
		//int mCount = bdao.mCount();
		
		// 전체 음원목록 갯수
		int muListCount = dao.rockCount();

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
		
		
		GenreChart=dao.rockGenre(paging);
		result.put("GenreChart",GenreChart);
		result.put("paging",paging);
		
		
		
		return result;
	}
	//힙합장르
	@Override
	public Map<String, Object> hiphopGenre(int page, int limit) {

		 Map<String, Object> result = new HashMap<String, Object>();


		int block = 5;

		// 전체 회원수
		//int mCount = bdao.mCount();
		
		// 전체 음원목록 갯수
		int muListCount = dao.hiphopCount();

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
		
		
		GenreChart=dao.hiphopGenre(paging);
		result.put("GenreChart",GenreChart);
		result.put("paging",paging);
		
		
		
		return result;
	}
	//인디장르
	@Override
	public Map<String, Object> indiGenre(int page, int limit) {

		 Map<String, Object> result = new HashMap<String, Object>();


		int block = 5;

		// 전체 회원수
		//int mCount = bdao.mCount();
		
		// 전체 음원목록 갯수
		int muListCount = dao.indiCount();

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
		
		
		GenreChart=dao.indiGenre(paging);
		result.put("GenreChart",GenreChart);
		result.put("paging",paging);
		
		
		
		return result;
	}
	
	@Override
	public Map<String, Object> gitaGenre(int page, int limit) {

		 Map<String, Object> result = new HashMap<String, Object>();


		int block = 5;

		// 전체 회원수
		//int mCount = bdao.mCount();
		
		// 전체 음원목록 갯수
		int muListCount = dao.gitaCount();

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
		
		
		GenreChart=dao.gitaGenre(paging);
		result.put("GenreChart",GenreChart);
		result.put("paging",paging);
		
		
		
		return result;
	}
	
	




	
	
	
}
