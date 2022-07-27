package com.icia.musicwired.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.musicwired.dao.uploadDao;
import com.icia.musicwired.dto.MusicLikeDto;
import com.icia.musicwired.dto.pagingDto;
import com.icia.musicwired.dto.uploadDto;

@Service
public class uploadServiceimpl implements uploadService {

	@Autowired
	private uploadDao dao;

	private ModelAndView mav = new ModelAndView();
	
	List<uploadDto> musicList = new ArrayList<uploadDto>();

	@Autowired
	private HttpSession session;

	//MUSICLike DTO
	List<MusicLikeDto> MusicLikeDto = new ArrayList<MusicLikeDto>();

	@Override
	public ModelAndView fileUpload(uploadDto dto) throws IOException {
//		System.out.println("2ser" + dto);
		MultipartFile aFile = dto.getMuFile();
		String originalFileName = aFile.getOriginalFilename();
		String uuid = UUID.randomUUID().toString().substring(0, 8);
		String aFileName = uuid + "_" + originalFileName;

		Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/audio/");
		String savePath = path + "/" + aFileName;

		if (!aFile.isEmpty()) {
			dto.setmFile(aFileName);
			aFile.transferTo(new File(savePath));
		} else {
			dto.setmFile("default.mp4");
		}
		MultipartFile aFile1 = dto.getmImage();
		String originalFileName1 = aFile1.getOriginalFilename();
		String uuid1 = UUID.randomUUID().toString().substring(0, 8);
		String aFileName1 = uuid1 + "_" + originalFileName1;

		Path path1 = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/muImage/");
		String savePath1 = path1 + "/" + aFileName1;

		if (!aFile1.isEmpty()) {
			dto.setMuImage(aFileName1);
			aFile1.transferTo(new File(savePath1));
		} else {
			dto.setMuImage("default_musicImage.jpg");
		}
//		System.out.println("4ser" + mav);
		int result = dao.fileUpload(dto);
		if (result > 0) {
			mav.setViewName("index");
		} else {
			mav.setViewName("index");
		}
		return mav;
	}

	@Override
	public ModelAndView fileList(int page, int limit ,String mId) {
//    	System.out.println("페이징 되라 서비스: "+page);
//    	System.out.println("페이징 되라 서비스: "+limit);
//    	System.out.println("페이징 되라 서비스: "+mId);

		// 한 화면에 보여줄 페이지 번호 갯수
		int block = 5;

		// 전체 음원목록 갯수
		int muListCount1 = dao.muListCount1(mId);

		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;

		int maxPage = (int) (Math.ceil((double) muListCount1/ limit)); // Math.ceil 올림
		int startPage = (((int) (Math.ceil((double) page / block))) - 1) * block + 1;
		int endPage = startPage + block - 1;
		// 오류 방지
		if (endPage > maxPage) {
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
		paging.setmId(mId);
		List<uploadDto> upList = dao.fileList(paging);
//		System.out.println("paging : " +paging);
		
		mav.setViewName("up_List");
		mav.addObject("upList", upList);
		mav.addObject("paging", paging);

		return mav;
		
	}

	@Override
	public ModelAndView muView(uploadDto dto) {
//		System.out.println("2서비스 : " + dto);
		uploadDto muView = dao.muView(dto);

		String LikeCheck = dao.LikeCheck(dto);
//		System.out.println("확인 : " + LikeCheck);
		if(LikeCheck != null){
			mav.addObject("LikeCheck",1);
		}else{
			mav.addObject("LikeCheck",0);
		}

		int LikeListCount = dao.LikeListCount(dto);
//		System.out.println("4서비스 : " + mav);
		mav.setViewName("mu_View");
		mav.addObject("muView", muView);
		mav.addObject("list", LikeListCount);

		return mav;
	}

	// 수정페이지 이동
	@Override
	public ModelAndView fileModiForm(uploadDto dto) {
//		System.out.println("2수정" + dto);
		uploadDto muView = dao.muView(dto);
//		System.out.println("4수정" + dto);
		mav.setViewName("up_ModiForm");
		mav.addObject("modi", muView);
		return mav;
	}

	// 수정메소드
	@Override
	public ModelAndView fileModify(uploadDto dto) throws IOException {
//		System.out.println("2modi" + dto);

		MultipartFile aFile = dto.getMuFile();
		String originalFileName = aFile.getOriginalFilename();
		String uuid = UUID.randomUUID().toString().substring(0, 8);
		String aFileName = uuid + "_" + originalFileName;

		Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/audio/");
		String savePath = path + "/" + aFileName;

		if (!aFile.isEmpty()) {
			dto.setmFile(aFileName);
			aFile.transferTo(new File(savePath));
		} else {
			dto.setmFile("default.mp4");
		}
		MultipartFile aFile1 = dto.getmImage();
		String originalFileName1 = aFile1.getOriginalFilename();
		String uuid1 = UUID.randomUUID().toString().substring(0, 8);
		String aFileName1 = uuid1 + "_" + originalFileName1;

		Path path1 = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/muImage/");
		String savePath1 = path1 + "/" + aFileName1;

		if (!aFile1.isEmpty()) {
			dto.setMuImage(aFileName1);
			aFile1.transferTo(new File(savePath1));
		} else {
			dto.setMuImage("default_musicImage.jpg");
		}
//		System.out.println("4moid" + mav);
		int result = dao.fileModify(dto);
		if (result > 0) {
			mav.setViewName("index");
		} else {
			mav.setViewName("index");
		}
		return mav;
	}

	@Override
	public ModelAndView fileDelete(int muCode) {

		int result = dao.fileDelete(muCode);
		if (result > 0) {
			mav.setViewName("redirect:/fileList");
		} else {
			mav.setViewName("index");
		}

		return mav;
	}

	@Override
	public void muCount(int muCode) {
		dao.muCount(muCode);
	}



	////////////////////////////////////////////////////////////////////////////////////////
	//좋아요 +1 / 좋아요 insert

	@Override
	public int LikeUp(MusicLikeDto musicLikeDto) {
//		System.out.println("[2] 좋아요:" + musicLikeDto);
		int result = dao.LikeUp(musicLikeDto);
		//추가
		int result1 =dao.LikeUp2(musicLikeDto);
//		System.out.println("좋아영 : "+result1);
		int LikeTableUpCheck = dao.LikeTableUpCheck(musicLikeDto);

		return LikeTableUpCheck;
	}



	////////////////////////////////////////////////////////////////////////////////////////
	//좋아요 +1



	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//좋아요 취소


	@Override

	public int LikeDown(MusicLikeDto musicLikeDto) {
//		System.out.println("[2] 좋아요:" + musicLikeDto);
		int result = dao.LikeDown(musicLikeDto);
		int result2= dao.LikeDown2(musicLikeDto);
		int LikeTableDownCheck = dao.LikeTableDownCheck(musicLikeDto);
//		System.out.println("[4] 좋아요:" + LikeTableDownCheck);

		return LikeTableDownCheck;
	}
	
//	ajaxFileList : 전체 음악 목록 메소드
	@Override
	public Map<String, Object> ajaxFileList(int page,int limit) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		// 한 화면에 보여줄 페이지 번호 갯수
		int block = 5;

		// 전체 음원목록 갯수
		int muListCount = dao.muListCount();

		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;

		int maxPage = (int) (Math.ceil((double) muListCount / limit));
		int startPage = (((int) (Math.ceil((double) page / block))) - 1) * block + 1;
		int endPage = startPage + block - 1;
		// 오류 방지
		if (endPage > maxPage) {
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
		
//		System.out.println("paging : " +paging);
		
		musicList = dao.ajaxFileList(paging);
		
//		System.out.println("musicList : " +musicList);
		
		if(musicList != null) {
			result.put("musicList", musicList);
			result.put("paging", paging);
		}else {
			result = null;
		}
		
		return result;
	}



	//MusicLikeList : 좋아요 한 사람들 목록
	@Override
	public List<MusicLikeDto> LikemodalList(int mulmuCode) {

		MusicLikeDto= dao.LikemodalList(mulmuCode);
		
		return MusicLikeDto;
	}

//	MyMusicList : 내가 올린 음악 리스트(ajax)
	@Override
	public List<uploadDto> MyMusicList(String muSinger) {
//		System.out.println("[2] 내가 올린 음악 리스트 S : " + muSinger);
		List<uploadDto> myMusicList = dao.MyMusicList(muSinger);
//		System.out.println("[3] 내가 올린 음악 리스트 S : " + myMusicList);
		
		if(myMusicList != null) {
			musicList = myMusicList;
		}else {
			musicList = null;
		}
		return musicList;
	}

//	musicDelete : 음악 삭제 메소드(ajax)
	@Override
	public List<uploadDto> ajaxMusicDelete(int muCode) {
//		System.out.println("[2] 음악 삭제 S : " + muCode);
		
		int result = dao.ajaxMusicDelete(muCode);
//		System.out.println("[3] 음악 삭제 S : " + result);
		
		if(result > 0) {
			
		} else {
			musicList = null;
		}
		
		return musicList;
	}





	
	
	

}
