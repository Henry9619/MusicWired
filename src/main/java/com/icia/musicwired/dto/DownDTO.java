package com.icia.musicwired.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Alias("Down")
public class DownDTO {
	private int mudCode;
	private String mudMid;
	private int mudMuCode;
	private Date mudDate;
	public int getMudCode() {
		return mudCode;
	}
	public void setMudCode(int mudCode) {
		this.mudCode = mudCode;
	}
	public String getMudMid() {
		return mudMid;
	}
	public void setMudMid(String mudMid) {
		this.mudMid = mudMid;
	}
	public int getMudMuCode() {
		return mudMuCode;
	}
	public void setMudMuCode(int mudMuCode) {
		this.mudMuCode = mudMuCode;
	}
	public Date getMudDate() {
		return mudDate;
	}
	public void setMudDate(Date mudDate) {
		this.mudDate = mudDate;
	}
	@Override
	public String toString() {
		return "DownDTO [mudCode=" + mudCode + ", mudMid=" + mudMid + ", mudMuCode=" + mudMuCode + ", mudDate="
				+ mudDate + "]";
	}
	
}
