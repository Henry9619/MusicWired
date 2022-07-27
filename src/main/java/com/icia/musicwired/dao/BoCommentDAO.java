package com.icia.musicwired.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.icia.musicwired.dto.BoCommentDTO;

@Mapper
public interface BoCommentDAO {

	List<BoCommentDTO> bcList(int bcBoCode);

	int bcWrite(BoCommentDTO boComment);
	
	
	int bcDelete(BoCommentDTO boComment);

	List<BoCommentDTO> boardWriterView(String boWriter);


	

}