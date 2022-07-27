package com.icia.musicwired.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.icia.musicwired.dto.pagingDto;
import com.icia.musicwired.dto.serchDTO;
import com.icia.musicwired.dto.uploadDto;

@Mapper
public interface searchDAO {

	


	int search2(String keyword);

	int search3(String keyword);

	/*
	 * List<uploadDto> songSearch(pagingDto paging);
	 * 
	 * List<uploadDto> singerSearch(pagingDto paging);
	 */

	int searchInsert(String keyword);

	List<serchDTO> searchRank();

	List<uploadDto> search10(pagingDto paging);

	List<uploadDto> search11(pagingDto paging);

	

}
