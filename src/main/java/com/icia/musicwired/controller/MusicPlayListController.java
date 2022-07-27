package com.icia.musicwired.controller;

import com.icia.musicwired.dto.BoCommentDTO;
import com.icia.musicwired.dto.BoardDTO;
import com.icia.musicwired.dto.MusicPlayListDto;
import com.icia.musicwired.dto.uploadDto;
import com.icia.musicwired.service.MusicPlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MusicPlayListController {
    @Autowired
    private MusicPlayListService mpsvc;

    private ModelAndView mav = new ModelAndView();
    List<MusicPlayListDto> playList = new ArrayList<MusicPlayListDto>();
    List<uploadDto> uploadDto = new ArrayList<>();

    //playList : playList 테이블에 insert
    @RequestMapping(value="playList", method= RequestMethod.POST)
    public @ResponseBody List<MusicPlayListDto> bcList(@ModelAttribute MusicPlayListDto mpDto){

        playList = mpsvc.playList(mpDto);
        return playList;
    }

    //리스트 페이지 열기
    @RequestMapping(value = "/playListView", method = RequestMethod.GET)
    public ModelAndView playListView(@RequestParam ("mId") String mId) {

    	mav.setViewName("play_List");
    	mav.addObject("tsMid", mId);
    	
        return mav;
    }

    //playList : 리스트 출력
    @PostMapping("playListPrint")
    public @ResponseBody List<MusicPlayListDto> playListPrint(@RequestParam ("mId")String mId) {

        playList = mpsvc.playListPrint(mId);
//        System.out.println("[4] playList : " + playList);
        return playList;
    }


    //playListSearch : 플레이리스트 검색
    @PostMapping("playListSearch")
    public @ResponseBody List<uploadDto> playListSearch(@RequestParam("muName") String muName) {
//        System.out.println("[1] 게시글 muName C : " + muName);
        uploadDto = mpsvc.playListSearch(muName);
//        System.out.println("[4] 게시글 muName C : " + muName);
        return uploadDto;
    }


    //playListDeleteAjax : 플레이어리스트 목록 삭제를 하기 위해 playList 테이블 select 를 하기 위한 join 쿼리 사용 메소드
    @PostMapping("playListDeleteAjax")
    public @ResponseBody List<MusicPlayListDto> playListDeleteAjax(@RequestParam ("muSinger")String muSinger) {

        playList = mpsvc.playListDeleteAjax(muSinger);

        return playList;
    }

    //플레이리스트 목록 삭제
    @PostMapping("PlayListDelete")
    public @ResponseBody List<MusicPlayListDto> fileDelete(@ModelAttribute MusicPlayListDto mpDto) {

        playList = mpsvc.PlayListDelete(mpDto);

        return playList;
    }

    //헤더 플레이리스트 ajax 실행
    @PostMapping("ajaxPlayList")
    public @ResponseBody List<MusicPlayListDto> ajaxPlayList(@RequestParam ("mId")String mId) {

        playList = mpsvc.ajaxPlayList(mId);

        return playList;
    }





}
