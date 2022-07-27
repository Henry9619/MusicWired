package com.icia.musicwired.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;






@Alias("search")
public class serchDTO {

	private String keyword;
	private Date keyworddate;
	
	
	public serchDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public serchDTO(String keyword, Date keyworddate) {
		super();
		this.keyword = keyword;
		this.keyworddate = keyworddate;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Date getKeyworddate() {
		return keyworddate;
	}
	public void setKeyworddate(Date keyworddate) {
		this.keyworddate = keyworddate;
	}
	@Override
	public String toString() {
		return "serchDTO [keyword=" + keyword + ", keyworddate=" + keyworddate + "]";
	}
	
	
}
