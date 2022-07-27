package com.icia.musicwired.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.icia.musicwired.dto.CRDTO;
import com.icia.musicwired.dto.CSDTO;
import com.icia.musicwired.dto.MemberDTO;

@Mapper
public interface chatDAO {

	int createRoom(String mId);

	CRDTO getRoom(String mId);

	List<CRDTO> chatlist();

	int chatSave(CSDTO csdto);

	List<CSDTO> getSaveChat(int crNum);

	int readupdate(int crNum);

	int readupdate1(int csNum);

	int newMessage(String crId);

	int newMessageUp(int csNum);

	int delMessage(String crId);

}
