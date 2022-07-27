package com.icia.musicwired.service;


import java.util.List;

import com.icia.musicwired.dto.MemberDTO;
import com.icia.musicwired.dto.subDTO;

public interface subService {

	int subreg(subDTO sub);

	int subcancel(subDTO sub);

	List<subDTO> submodalList(String sserMid);

	List<subDTO> subermodalList(String ssMid);



}
