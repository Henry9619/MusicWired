package com.icia.musicwired.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("mulike")
@Data
public class MusicLikeDto {
    private int mulCode;
    private int mulmuCode;  //음악코드
    private String mulMid;  //아이디코드
}
