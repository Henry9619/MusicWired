package com.icia.musicwired.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("BoComment")
public class BoCommentDTO {

	private int bcCode;
	private String bcMid;
	private int bcBoCode;
	private String bcContent;
	
	private MultipartFile mProfile;
	private String mProfileName;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd HH:mm", timezone = "Asia/Seoul")
	private Date bcDate;

	public int getBcCode() {
		return bcCode;
	}

	public void setBcCode(int bcCode) {
		this.bcCode = bcCode;
	}

	public String getBcMid() {
		return bcMid;
	}

	public void setBcMid(String bcMid) {
		this.bcMid = bcMid;
	}

	public int getBcBoCode() {
		return bcBoCode;
	}

	public void setBcBoCode(int bcBoCode) {
		this.bcBoCode = bcBoCode;
	}

	public String getBcContent() {
		return bcContent;
	}

	public void setBcContent(String bcContent) {
		this.bcContent = bcContent;
	}

	public Date getBcDate() {
		return bcDate;
	}

	public void setBcDate(Date bcDate) {
		this.bcDate = bcDate;
	}

	public MultipartFile getmProfile() {
		return mProfile;
	}

	public void setmProfile(MultipartFile mProfile) {
		this.mProfile = mProfile;
	}

	public String getmProfileName() {
		return mProfileName;
	}

	public void setmProfileName(String mProfileName) {
		this.mProfileName = mProfileName;
	}
	
	
}
