package com.icia.musicwired.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("sub")
public class subDTO {


	/*
	 * CREATE TABLE SUBSCRIPTION( SSCODE NUMBER, SSMID NVARCHAR2(20) NOT NULL,
	 * SSERMID NVARCHAR2(20) NOT NULL );
	 */


	private int ssCode;
	private String ssMid;
	private String sserMid;
}
