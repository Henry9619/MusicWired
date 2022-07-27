package com.icia.musicwired.service;

import com.icia.musicwired.dto.MusicPlayListDto;
import com.icia.musicwired.dto.uploadDto;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface MusicPlayListService {
    //playList : playList 테이블에 insert
    List<MusicPlayListDto> playList(MusicPlayListDto mpDto);

    // 리스트 출력
    List<MusicPlayListDto> playListPrint(String mId);

    //플레이리스트 검색
    List<uploadDto> playListSearch(String muName);

    //playListDto를 불러오기 위한 ajax
    List<MusicPlayListDto> playListDeleteAjax(String muSinger);

    //플레이리스트 목록 삭제
    List<MusicPlayListDto> PlayListDelete(MusicPlayListDto mpDto);

    //헤더 플레이리스트 ajax 실행
    List<MusicPlayListDto> ajaxPlayList(String mId);



}
