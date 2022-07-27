package com.icia.musicwired.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.icia.musicwired.dto.MemberDTO;

public interface MemberService {

	ModelAndView memberJoin(MemberDTO member) throws IllegalStateException, IOException;

	ModelAndView memLogin(MemberDTO member);

	String checkId(String mId);

	ModelAndView memberView(String mId);

	ModelAndView memberModiForm(String mId);

	ModelAndView memberModify(MemberDTO member) throws IllegalStateException, IOException;

	ModelAndView memberDelete(String mId);

	ModelAndView memberList();

	List<MemberDTO> memIdfind(String mEmail);

	Map<String, Object> memPwfind(MemberDTO member);

	String checkEmail(String mEmail);

	List<MemberDTO> ajaxIdSearch(String mId);

}
