package com.icia.musicwired.dto;

import org.apache.ibatis.type.Alias;

import lombok.Builder;
import lombok.Data;
@Builder 
@Data
@Alias("music1")
public class CrawlingDTO {
	 private String muSinger;
	 private String muName;
	 private String muLyric;
}
