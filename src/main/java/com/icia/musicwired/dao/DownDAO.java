package com.icia.musicwired.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.icia.musicwired.dto.DownDTO;

@Mapper
public interface DownDAO {

	int downloadTableInsert(DownDTO down);

	List<DownDTO> ajaxDownList(String mudMid);

}
