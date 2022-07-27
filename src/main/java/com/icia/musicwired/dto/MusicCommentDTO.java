package com.icia.musicwired.dto;


import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Date;


@Data
@Alias("mucomment")
public class MusicCommentDTO {


	/*
	 * MCCODE NUMBER , MCMID NVARCHAR2(20) NOT NULL, MCMUNUM NUMBER NOT NULL,
	 * MCCONTENT NVARCHAR2(200) NOT NULL, MCDATE DATE NOT NULL
	 */


	private int mcCode;
	private String mcMid;
	private int mcMuNum;
	private String mcContent;
	private Date mcDate;
	private String mProfileName;
}
