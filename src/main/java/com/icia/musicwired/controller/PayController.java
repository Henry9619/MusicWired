package com.icia.musicwired.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.musicwired.dto.PayDTO;
import com.icia.musicwired.service.PayService;

@Controller
public class PayController {

	List<PayDTO> payList = new ArrayList<PayDTO>();
	
	@Autowired
	private PayService paysvc;
	
//	payInsert : 장바구니에서 결제할때 결제정보 저장하는 메소드
	@PostMapping("payInsert")
	public @ResponseBody List<PayDTO> payInsert(@ModelAttribute PayDTO pay){
//		System.out.println("[1] 결제정보 저장 C : " + pay);
		payList = paysvc.payInsert(pay);
//		System.out.println("[4] 결제정보 저장 C : " + payList);
		return payList;
	}
	
//	PayInCheck : 해당 음악을 결제했는지 확인하는 메소드
	@PostMapping("PayInCheck")
	public @ResponseBody List<PayDTO> PayInCheck(@ModelAttribute PayDTO pay){
		payList = paysvc.PayInCheck(pay);
		return payList;
	}
	
//	payListPage : 구매목록 페이지 이동
	@GetMapping("buyListPage")
	public String buyList() {
		return "Buy_List";
	}
	
//	buyList : 구매목록 리스트 출력 메소드
	@PostMapping("buyList")
	public @ResponseBody List<PayDTO> buyList(@RequestParam("psMid") String psMid){
//		System.out.println("[1] 구매목록 리스트 C : " + psMid);
		payList = paysvc.buyList(psMid);
//		System.out.println("[4] 구매목록 리스트 C : " + payList);
		return payList;
	}
	
}
