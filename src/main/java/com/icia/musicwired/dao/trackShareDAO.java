package com.icia.musicwired.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.icia.musicwired.dto.trackShareDTO;

@Mapper
public interface trackShareDAO {

	int trackShare(String tsMid);

	List<trackShareDTO> trackShareSearch(String tsMid);

	List<trackShareDTO> track();

}
