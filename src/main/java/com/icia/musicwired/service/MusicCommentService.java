package com.icia.musicwired.service;

import java.util.List;

import com.icia.musicwired.dto.MusicCommentDTO;

public interface MusicCommentService {

	List<MusicCommentDTO> mcList(int mcCode);

	List<MusicCommentDTO> mcWrite(MusicCommentDTO mcomm);

	List<MusicCommentDTO> mcModify(MusicCommentDTO mcomm);

	List<MusicCommentDTO> mcDelete(MusicCommentDTO mcomm);

}
