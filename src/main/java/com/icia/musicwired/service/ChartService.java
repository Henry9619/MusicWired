package com.icia.musicwired.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.icia.musicwired.dto.uploadDto;

public interface ChartService {

	

	List<uploadDto> hitChart();

	List<uploadDto> likeChart();

	Map<String, Object> balgenre(int page, int limit);

	Map<String, Object> danceGenre(int page, int limit);

	Map<String, Object> rockGenre(int page, int limit);

	Map<String, Object> hiphopGenre(int page, int limit);

	Map<String, Object> indiGenre(int page, int limit);

	Map<String, Object> gitaGenre(int page, int limit);

	

	

	



	

}
