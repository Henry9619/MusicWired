package com.icia.musicwired.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.icia.musicwired.dto.MemberDTO;
import com.icia.musicwired.dto.subDTO;

@Mapper
public interface subDAO {

	int subreg(subDTO sub);


	int addCount(subDTO sub);


	int subcancel(subDTO sub);


	int minusCount(subDTO sub);


	List<subDTO> submodalList(String sserMid);


	List<subDTO> subermodalList(String ssMid);





}
