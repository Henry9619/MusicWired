package com.icia.musicwired.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.musicwired.dao.chatDAO;
import com.icia.musicwired.dto.CRDTO;
import com.icia.musicwired.dto.CSDTO;
import com.icia.musicwired.dto.MemberDTO;

@Service
public class chatServiceImpl implements chatService {

	private ModelAndView mav = new ModelAndView();
	@Autowired
	private chatDAO mdao;

	@Autowired
	private HttpSession session;

	@Override
	public ModelAndView createRoom(String mId) {
		CRDTO crdto1 = mdao.getRoom(mId);

		if (crdto1 == null) {
			int result = mdao.createRoom(mId);
			CRDTO crdto = mdao.getRoom(mId);
//			System.out.println("채팅결과: " + result);
			if (result > 0) {
				mav.setViewName("Chat");
				mav.addObject("crdto", crdto);
			} else {

				mav.setViewName("index");
			}
		} else {
//			System.out.println("crdtio1" + crdto1.getCrNum());
			List<CSDTO> csdto = mdao.getSaveChat(crdto1.getCrNum());
//			System.out.println("채팅결과2: " + csdto);

			mav.setViewName("Chat");
			mav.addObject("crdto", crdto1);
			mav.addObject("csdto", csdto);
		}

		return mav;
	}

	List<CSDTO> chatsave = new ArrayList<CSDTO>();

	@Override
	public ModelAndView chatlist() {

		List<CRDTO> crlist = mdao.chatlist();

		mav.setViewName("CRList");
		mav.addObject("crlist", crlist);

		return mav;
	}

	@Override
	public List<CSDTO> chatSave(CSDTO csdto) {
//		System.out.println("123"+csdto);
		int result = mdao.chatSave(csdto);
		
		if(!csdto.getCsId().equals("admin")) {
		int result1 = mdao.readupdate1(csdto.getCsNum()); 
		}
		
		return chatsave;
		
	}

	@Override
	public int readupdate(int crNum) {
		int result = mdao.readupdate(crNum);
		return result;
	}

	@Override
	public int newMessage(String crId) {
		int result = mdao.newMessage(crId);
		
		return result;
	}

	@Override
	public int newMessageUp(int csNum) {
		int result = mdao.newMessageUp(csNum);
		return result;
	}

	@Override
	public int delMessage(String crId) {
		
		int result = mdao.delMessage(crId);
		return result;
	}



}
