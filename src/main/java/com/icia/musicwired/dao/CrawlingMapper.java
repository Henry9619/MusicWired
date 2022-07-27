package com.icia.musicwired.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.icia.musicwired.dto.MENUDTO;

@Mapper
public interface CrawlingMapper {
		
	public void insertName(List<MENUDTO>list);
}
