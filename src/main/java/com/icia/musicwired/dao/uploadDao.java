package com.icia.musicwired.dao;

import java.util.List;

import com.icia.musicwired.dto.MusicLikeDto;

import org.apache.ibatis.annotations.Mapper;

import com.icia.musicwired.dto.pagingDto;
import com.icia.musicwired.dto.uploadDto;

@Mapper
public interface uploadDao {

	//음원 업로드
    int fileUpload(uploadDto dto);
    //음원 리스트
    List<uploadDto> fileList(pagingDto paging);
	//음원 수정
	int fileModify(uploadDto dto);
	//음원 삭제
	int fileDelete(int muCode);
	//조회수
	void muCount(int muCode);
	//음원 상세보기
	uploadDto muView(uploadDto dto);
	//전체 음원목록 갯수
	int muListCount();

	// 좋아요 눌렀는지 확인
	String LikeCheck(uploadDto dto);

	//해당 음원 좋아요 수
	int LikeListCount(uploadDto dto);


////////////////////////////////////////////////////////////
	//	좋아요 +1 메소드

	//좋아요 +1
	int LikeUp(MusicLikeDto musicLikeDto);
	//좋아요 +1 갯수(?)
	int LikeTableUpCheck(MusicLikeDto musicLikeDto);
////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////
	//좋아요 -1 메소드

	//좋아요 -1
	int LikeDown(MusicLikeDto musicLikeDto);


	List<uploadDto> ajaxFileList(pagingDto paging);

	//좋아요 테이블 데이터 삭제
	int LikeTableDownCheck(MusicLikeDto musicLikeDto);
	
	List<uploadDto> boardWriterView(String boWriter);

	int LikeUp2(MusicLikeDto musicLikeDto);
	int LikeDown2(MusicLikeDto musicLikeDto);

	int muListCount1(String mId);


	List<MusicLikeDto> LikemodalList(int mulmuCode);
	List<uploadDto> MyMusicList(String muSinger);
	int ajaxMusicDelete(int muCode);


////////////////////////////////////////////////////////////








}