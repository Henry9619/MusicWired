package com.icia.musicwired.service;

import java.io.IOException;

import java.util.List;
import java.util.Map;


import com.icia.musicwired.dto.MusicLikeDto;
import org.springframework.web.servlet.ModelAndView;

import com.icia.musicwired.dto.MusicLikeDto;
import com.icia.musicwired.dto.uploadDto;

public interface uploadService {
	ModelAndView fileUpload(uploadDto dto) throws IOException;

	ModelAndView fileList(int page, int limit, String mId);


	ModelAndView muView(uploadDto dto);

//	ModelAndView muView(int muCode, MemberDTO member);

	//수정페이지이동
	ModelAndView fileModiForm(uploadDto dto);

	//수정메소드
	ModelAndView fileModify(uploadDto dto) throws IOException;


	ModelAndView fileDelete(int muCode);

	void muCount(int muCode);

	///////////////////////////////////////////////////////
	//좋아요 +1
	int LikeUp(MusicLikeDto musicLikeDto);


	///////////////////////////////////////////////////////


	//좋아요 -1
	int LikeDown(MusicLikeDto musicLikeDto);



	Map<String, Object> ajaxFileList(int page,int limit);

	List<MusicLikeDto> LikemodalList(int mulmuCode);

	List<uploadDto> MyMusicList(String muSinger);

	List<uploadDto> ajaxMusicDelete(int muCode);
}
