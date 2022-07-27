package com.icia.musicwired.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.icia.musicwired.dto.trackShareDTO;

public interface trackShareService {

	List<trackShareDTO> trackShare(String tsMid);

	List<trackShareDTO> trackShareSearch(String tsMid);

	ModelAndView track();


}
