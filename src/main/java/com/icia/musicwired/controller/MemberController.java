package com.icia.musicwired.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.musicwired.dto.MemberDTO;
import com.icia.musicwired.service.MemberService;

@Controller
public class MemberController {

	private ModelAndView mav = new ModelAndView();

	@Autowired
	private MemberService msvc;

	@Autowired
	private HttpSession session;
	
	List<MemberDTO> memList = new ArrayList<MemberDTO>();
	List<MemberDTO> memberList = new ArrayList<MemberDTO>();
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {

		return "index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index1() {

		return "index";
	}

	// memberJoinForm
	@RequestMapping(value = "/memberJoinForm", method = RequestMethod.GET)
	public String memberJoinForm() {
		return "Mem_JoinForm";
	}

	// memberJoin
	@RequestMapping(value = "/memberJoin", method = RequestMethod.POST)
	public ModelAndView memberJoin(@ModelAttribute MemberDTO member) throws IllegalStateException, IOException {
		mav = msvc.memberJoin(member);
		return mav;
	}

	// memberLogin
	@RequestMapping(value = "/memberLogin", method = RequestMethod.GET)
	public String memberLogin() {
		return "Mem_Login";
	}

	// memLogin
	@RequestMapping(value = "/memLogin", method = RequestMethod.POST)
	public ModelAndView memLogin(@ModelAttribute MemberDTO member , HttpServletResponse response) {
		//쿠키에 시간 정보를 주지 않으면 세션 쿠키가 된다. (브라우저 종료시 모두 종료)
	    Cookie idCookie = new Cookie("memberId", String.valueOf(member.getmId()));
	    idCookie.setMaxAge(60*60*24);
	    response.addCookie(idCookie);
		mav = msvc.memLogin(member);
		
		return mav;
	}

	// checkId
	@RequestMapping(value = "/checkId", method = RequestMethod.POST)
	public @ResponseBody String checkId(@RequestParam("mId") String mId) {

		String msg = msvc.checkId(mId);

		return msg;
	}

	// checkEmail
	@RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
	public @ResponseBody String checkEmail(@RequestParam("mEmail") String mEmail) {
		
		String msg =msvc.checkEmail(mEmail);
		
		return msg;
	}
	
	// memberViewMe
	@RequestMapping(value = "/memberViewMe", method = RequestMethod.GET)
	public String memberViewMe() {

		return "Mem_ViewMe";
	}

	// memberLogout
	@RequestMapping(value = "/memberLogout", method = RequestMethod.GET)
	public String memberLogout(HttpServletResponse response) {
		 expiredCookie(response, "memberId");
		session.invalidate();
		return "index";
	}

	private void expiredCookie(HttpServletResponse response, String cookieName) {
		  Cookie cookie = new Cookie(cookieName, null);
		    cookie.setMaxAge(0);
		    response.addCookie(cookie);
		
	}

	// memberModiForm
	@RequestMapping(value = "/memberModiForm", method = RequestMethod.GET)
	public ModelAndView memberModiForm(@RequestParam("mId") String mId) {
		mav = msvc.memberModiForm(mId);
		return mav;
	}

	// memberModify
	@RequestMapping(value = "/memberModify", method = RequestMethod.POST)
	public ModelAndView memberModify(@ModelAttribute MemberDTO member) throws IllegalStateException, IOException {
		mav = msvc.memberModify(member);
		return mav;
	}

	// memberDelete
	@RequestMapping(value = "/memberDelete", method = RequestMethod.GET)
	public ModelAndView memberDelete(@RequestParam("mId") String mId) {
//		System.out.println(mId);
		mav = msvc.memberDelete(mId);
		return mav;
	}

	// memberList
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public ModelAndView memberList() {
		mav = msvc.memberList();
		return mav;
	}

	// memberView
	@RequestMapping(value = "/memberView", method = RequestMethod.GET)
	public ModelAndView memberView(@RequestParam("mId") String mId) {
		mav = msvc.memberView(mId);
		return mav;
	}

	// memberIdfind
	@RequestMapping(value = "/memberIdfind", method = RequestMethod.GET)
	public String memberIdfind() {

		return "Mem_Idfind";
	}

	
//	memIdfind : 아이디찾기
	@PostMapping("memIdfind")
	public @ResponseBody List<MemberDTO> memIdfind(@RequestParam("mEmail") String mEmail){
//		System.out.println("[1] 아이디 찾기 C : " + mEmail);
		memList = msvc.memIdfind(mEmail);
//		System.out.println("[4] 아이디 찾기 C : " + memList);
		
		return memList;
	}


	
//	memPwfind : 비번찾기
	@PostMapping("memPwfind")
	@ResponseBody
	public Map<String,Object> memPwfind(@ModelAttribute MemberDTO member){
//		System.out.println("[1] 비번찾기 C : " + member);
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		result = msvc.memPwfind(member);
		
//		System.out.println("[5] 비번찾기 C : " + result);
		
		return result;
	}
	//ajaxIdSearch
		@PostMapping("ajaxIdSearch")
		public @ResponseBody List<MemberDTO> ajaxIdSearch(@RequestParam("mId") String mId){
//			System.out.println("[1] : " + mId);
			memberList = msvc.ajaxIdSearch(mId);
//			System.out.println("[4] : " + mId);
			return memberList;
		}

}
