package com.icia.musicwired.service;

import java.util.List;

import com.icia.musicwired.dto.BoCommentDTO;

public interface BoCommentService {

	List<BoCommentDTO> bcList(int bcBoCode);

	List<BoCommentDTO> bcWrite(BoCommentDTO boComment);
	
	List<BoCommentDTO> bcDelete(BoCommentDTO boComment);

}
