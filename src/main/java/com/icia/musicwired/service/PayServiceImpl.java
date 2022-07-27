package com.icia.musicwired.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.musicwired.dao.CartDAO;
import com.icia.musicwired.dao.PayDAO;
import com.icia.musicwired.dto.CartDTO;
import com.icia.musicwired.dto.PayDTO;

@Service
public class PayServiceImpl implements PayService{

	List<PayDTO> payList = new ArrayList<PayDTO>();
	
	@Autowired
	private PayDAO paydao;
	
	@Autowired
	private CartDAO cartdao;
	
	List<CartDTO> cartList = new ArrayList<CartDTO>();
	
//	payInsert : 장바구니에서 결제할때 결제정보 저장하는 메소드
	@Override
	public List<PayDTO> payInsert(PayDTO pay) {
//		System.out.println("[2] 결제정보 저장 S : " + pay);
		
		int result = paydao.payInsert(pay);
		paydao.payMoneyAdd(pay);
		
//		System.out.println("[3] 결제정보 저장 S : " + result);
		
		if(result > 0) {
			
			int delete = paydao.payCartAllDelete(pay);
			
			List<PayDTO> Cart = paydao.PayInsertAfterCartList(pay.getPsMid());
			payList = Cart;
		} else {
			payList = null;
		}
		
		return payList;
	}

//	PayInCheck : 해당 음악을 결제했는지 확인하는 메소드
	@Override
	public List<PayDTO> PayInCheck(PayDTO pay) {
		
		List<PayDTO> payCheck = paydao.PayInCheck(pay);
		
		
		if(payCheck != null) {
			payList = payCheck;
		} else {
			payList = null;
		}
		
		return payList;
	}

//	buyList : 구매 목록 리스트 출력 메소드
	@Override
	public List<PayDTO> buyList(String psMid) {
//		System.out.println("[2] 구매목록 리스트 S : " + psMid);
		
		List<PayDTO> buyList = paydao.buyList(psMid);
		
//		System.out.println("[3] 구매목록 리스트 S : " + buyList);
		
		if(buyList != null) {
			payList = buyList;
		} else {
			payList = null;
		}
		
		return payList;
	}


}
