package com.icia.musicwired.dao;


import com.icia.musicwired.dto.MusicCommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MusicCommentDAO {


	List<MusicCommentDTO> mcList(int mcCode);

	int mcWrite(MusicCommentDTO mcomm);

	int mcModify(MusicCommentDTO mcomm);

	int mcDelete(MusicCommentDTO mcomm);

	List<MusicCommentDTO> boardWriterView(String boWriter);


}
