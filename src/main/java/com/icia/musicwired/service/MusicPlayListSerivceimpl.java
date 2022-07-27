package com.icia.musicwired.service;

import com.icia.musicwired.dao.MusicPlayListDao;
import com.icia.musicwired.dto.MusicPlayListDto;
import com.icia.musicwired.dto.pagingDto;
import com.icia.musicwired.dto.uploadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class MusicPlayListSerivceimpl implements MusicPlayListService{

    @Autowired
    private MusicPlayListDao mpDao;
    List<MusicPlayListDto> playList = new ArrayList<MusicPlayListDto>();
    @Autowired
    private HttpSession session;

    private ModelAndView mav = new ModelAndView();

    //playList : playList 테이블에 insert
    @Override
    public List<MusicPlayListDto> playList(MusicPlayListDto mpDto) {

        int result = mpDao.playList(mpDto);

        if(result>0) {

        }
        return playList;
    }

    // playList : 리스트 출력
    @Override
    public List<MusicPlayListDto> playListPrint(String mId) {

        List<MusicPlayListDto>playListPrint = mpDao.playListPrint(mId);
        
        return playListPrint;
    }

    // playListSearch : 리스트 검색
    @Override
    public List<uploadDto> playListSearch(String muName) {
        List<uploadDto> playListSearch = mpDao.playListSearch(muName);

        return playListSearch;
    }

    //playListDto를 불러오기 위한 ajax
    @Override
    public List<MusicPlayListDto> playListDeleteAjax(String muSinger) {

        List<MusicPlayListDto> playListDeleteAjax = mpDao.playListDeleteAjax(muSinger);

        return playListDeleteAjax;
    }

    //플레이리스트 목록 삭제
    @Override
    public List<MusicPlayListDto> PlayListDelete(MusicPlayListDto mpDto) {

        int result = mpDao.PlayListDelete(mpDto);
        if(result>0){

        }

        return playList;
    }

    //헤더 플레이리스트 ajax 실행
    @Override
    public List<MusicPlayListDto> ajaxPlayList(String mId) {

        List<MusicPlayListDto>ajaxplayList = mpDao.ajaxplayList(mId);

        return ajaxplayList;
    }


}
