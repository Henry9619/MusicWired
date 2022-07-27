package com.icia.musicwired.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.icia.musicwired.dto.PayDTO;

@Mapper
public interface PayDAO {

	int payInsert(PayDTO pay);

	List<PayDTO> PayInsertAfterCartList(String psMid);

	int payCartAllDelete(PayDTO pay);

	int payMoneyAdd(PayDTO pay);

	List<PayDTO> PayInCheck(PayDTO pay);

	List<PayDTO> buyList(String psMid);

}
