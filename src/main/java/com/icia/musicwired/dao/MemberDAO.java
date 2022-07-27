package com.icia.musicwired.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.icia.musicwired.dto.MemberDTO;

@Mapper
public interface MemberDAO {

	int memberJoin(MemberDTO member);

	MemberDTO memLogin(MemberDTO member);

	String checkId(String mId);

	String mEpw(String getmId);

	MemberDTO memberView(String mId);

	int memberModify(MemberDTO member);

	int memberDelete(String mId);

	List<MemberDTO> memberList();

	int loginCheck(MemberDTO member);

	List<MemberDTO> memIdfind(String mEmail);

	void memPwfindUpdate(MemberDTO member);

	List<MemberDTO> memPwfindSelect(MemberDTO member);

	List<MemberDTO> memPwfind(MemberDTO member);

	MemberDTO boardWriterView(String boWriter);

	String checkEmail(String mEmail);

	List<MemberDTO> ajaxIdSearch(String mId);




}
