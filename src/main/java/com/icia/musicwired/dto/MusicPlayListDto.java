package com.icia.musicwired.dto;

import lombok.Data;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Data
@Alias("MusicPlayList")
public class MusicPlayListDto {
//    PLCODE NUMBER,
//    PLMUCODE NUMBER NOT NULL,
//    PLMID NVARCHAR2(20) NOT NULL

    private int plCode;
    private int plmuCode;
    private String plMid;
    private String mId; //리스트를 출력하기 위해 로그인 아이디 값을 가져오기 위한 필드
    

    private List<trackShareDTO> track;
}
