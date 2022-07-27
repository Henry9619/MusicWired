package com.icia.musicwired.service;

import java.util.List;

import com.icia.musicwired.dto.PayDTO;

public interface PayService {

	List<PayDTO> payInsert(PayDTO pay);

	List<PayDTO> PayInCheck(PayDTO pay);

	List<PayDTO> buyList(String psMid);


}
