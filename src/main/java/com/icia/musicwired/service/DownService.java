package com.icia.musicwired.service;

import java.util.List;

import com.icia.musicwired.dto.DownDTO;

public interface DownService {

	List<DownDTO> downloadTableInsert(DownDTO down);

	List<DownDTO> ajaxDownList(String mudMid);

}
