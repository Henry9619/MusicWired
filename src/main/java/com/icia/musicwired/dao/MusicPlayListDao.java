package com.icia.musicwired.dao;

import com.icia.musicwired.dto.MusicPlayListDto;
import com.icia.musicwired.dto.uploadDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MusicPlayListDao {
    //playList : playList 테이블에 insert
    int playList(MusicPlayListDto mpDto);

    //리스트 출력
    List<MusicPlayListDto> playListPrint(String mId);

    //리스트 검색
    List<uploadDto> playListSearch(String muName);

    List<MusicPlayListDto> playListDeleteAjax(String muSinger);


    int PlayListDelete(MusicPlayListDto mpDto);

    List<MusicPlayListDto> ajaxplayList(String mId);
}
