package com.icia.musicwired.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@Data
@Alias("likecount")
public class likecountDTO {

    private int lcount;

}


