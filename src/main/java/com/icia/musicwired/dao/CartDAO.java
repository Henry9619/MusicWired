package com.icia.musicwired.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.icia.musicwired.dto.CartDTO;

@Mapper
public interface CartDAO {

	int cartListAdd(CartDTO cart);

	int cartListDelete(CartDTO cart);

	List<CartDTO> CartInCheck(CartDTO cart);

	List<CartDTO> ajaxCartList(String mId);

	int payCartAllDelete(String psMid);

    int CartAddPlayList(CartDTO cart);

    List<CartDTO> CartAddCheck(CartDTO cart);

	int CartAddPlayListDelete(CartDTO cart);

}
