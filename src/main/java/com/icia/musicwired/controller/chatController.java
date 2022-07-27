package com.icia.musicwired.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.musicwired.dto.CSDTO;
import com.icia.musicwired.dto.MusicLikeDto;
import com.icia.musicwired.service.chatService;

@Controller
public class chatController {

	private ModelAndView mav = new ModelAndView();
	@Autowired
	private chatService msvc;
	@Autowired
	private HttpSession session;

	// moveChating 채팅방 만들기
	@RequestMapping(value = "/moveChating", method = RequestMethod.GET)
	public ModelAndView chating(@RequestParam("mId") String mId) {
//		System.out.println("아이디" + mId);
		mav = msvc.createRoom(mId);
		return mav;

	}

	// chat 채팅방 열기
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public ModelAndView chat() {
		mav.setViewName("Chat");
		return mav;
	}

	// chatlist 채팅방 목록
	@RequestMapping(value = "/chatlist", method = RequestMethod.GET)
	public ModelAndView chatlist() {
		mav = msvc.chatlist();
		return mav;

	}

	List<CSDTO> chatsave = new ArrayList<CSDTO>();

	// chatSave 채팅방 저장
	@RequestMapping(value = "/chatSave", method = RequestMethod.POST)
	public @ResponseBody List<CSDTO> chatSave(@ModelAttribute CSDTO csdto) {
//		System.out.println("채팅저장" + csdto);
		chatsave = msvc.chatSave(csdto);
		return chatsave;

	}

	// readupdate 관리자채팅 읽음 유무
	@RequestMapping(value = "/readupdate", method = RequestMethod.POST)
	public @ResponseBody int readupdate(@RequestParam("crNum") int crNum) {

		int readupdate = msvc.readupdate(crNum);

		return readupdate;

	}
	
	// newMessage 유저 새메시지 수
	 @RequestMapping(value = "/newMessage", method = RequestMethod.POST)
	    public @ResponseBody int newMessage(@RequestParam("crId") String crId) {

	        int newMessage = msvc.newMessage(crId);

	        return newMessage;
	    }
	 
	 // sidebar 사이드바
	 @RequestMapping(value = "/sidebar", method = RequestMethod.GET)
		public String index() {

			return "sidebar";
		}
	 
	 // newMessageUp 채팅알림수 증가
	 @RequestMapping(value = "/newMessageUp", method = RequestMethod.POST)
	    public @ResponseBody int newMessageUp(@RequestParam("csNum") int csNum) {
	  
	        int newMessageUp = msvc.newMessageUp(csNum);
	    
	        return newMessageUp;
	    }
	 
	 // delMessage 채팅알림 삭제
	 @RequestMapping(value = "/delMessage", method = RequestMethod.POST)
	    public @ResponseBody int delMessage(@RequestParam("crId") String crId) {
	  
	        int delMessage = msvc.delMessage(crId);
	    
	        return delMessage;
	    }
	 
	 
}
