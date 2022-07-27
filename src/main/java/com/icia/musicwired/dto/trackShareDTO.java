package com.icia.musicwired.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Alias("track")
@Data
public class trackShareDTO {

	private int tsCode;
	private String tsMid;
	private String mName;
	private MultipartFile mProfile;
	private String mProfileName;
	
}
