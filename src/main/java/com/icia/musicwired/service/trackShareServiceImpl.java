package com.icia.musicwired.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.musicwired.dao.MusicPlayListDao;
import com.icia.musicwired.dao.trackShareDAO;
import com.icia.musicwired.dto.MusicPlayListDto;
import com.icia.musicwired.dto.trackShareDTO;
@Service
public class trackShareServiceImpl implements trackShareService {

	List<trackShareDTO> trackList = new ArrayList<trackShareDTO>();
	private ModelAndView mav = new ModelAndView();
	@Autowired
	private trackShareDAO dao;
	
	@Autowired
    private MusicPlayListDao mpDao; 
	
	@Override
	public List<trackShareDTO> trackShare(String tsMid) {
//		System.out.println("2. 트랙 주입 : " + tsMid);
		int result = dao.trackShare(tsMid);
//		System.out.println("3. 트랙 주입 : " + trackList);
		if(result > 0 ) {
			
		}else {
			trackList =null;
		}
		return trackList;
	}

	@Override
	public List<trackShareDTO> trackShareSearch(String tsMid) {
//		System.out.println("2. 트랙 주입 : " + tsMid);
		List<trackShareDTO> track = dao.trackShareSearch(tsMid);
		
			trackList = track;
//		System.out.println("3. 트랙 주입 : " + trackList);
		return trackList;
	}

	@Override
	public ModelAndView track() {
		List<trackShareDTO> track = dao.track();
		mav.setViewName("track_Share");
		mav.addObject("track",track);
		return mav;
	}


	

}
