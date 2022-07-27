package com.icia.musicwired.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("BoardLike")
public class BoardLikeDTO {

	private int bolCode;
	private int bolBoCode;
	private String bolMid;

}
