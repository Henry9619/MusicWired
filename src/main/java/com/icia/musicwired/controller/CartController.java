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
import org.springframework.web.servlet.ModelAndView;

import com.icia.musicwired.dto.CartDTO;
import com.icia.musicwired.service.CartService;

@Controller
public class CartController {
	
	private ModelAndView mav = new ModelAndView();
	
	@Autowired
	private CartService cartsvc;
	
	List<CartDTO> cartList = new ArrayList<CartDTO>();
	
//	cartListAdd : 장바구니에 상품 추가하는 메소드
	@PostMapping("cartListAdd")
	public @ResponseBody List<CartDTO> cartListAdd(@ModelAttribute CartDTO cart) {
	
		cartList = cartsvc.cartListAdd(cart);
		
		return cartList;
	}
	
//	cartListDelete : 장바구니에 있는 상품 삭제하는 메소드
	@PostMapping("cartListDelete")
	public @ResponseBody List<CartDTO> cartListDelete(@ModelAttribute CartDTO cart){
		cartList = cartsvc.cartListDelete(cart);
		return cartList;
	}
	
//	CartInCheck : 장바구니에 이미 담았는지 확인하는 메소드
	@PostMapping("CartInCheck")
	public @ResponseBody List<CartDTO> CartInCheck(@ModelAttribute CartDTO cart){
		cartList = cartsvc.CartInCheck(cart);
		return cartList;
	}
//	cartList : 장바구니 페이지
	@GetMapping("cartList") 
	public String cartList() {
		return "Cart_List";
	}
	
//	ajaxCartList : 장바구니 목록 출력
	@PostMapping("ajaxCartList") 
	public @ResponseBody List<CartDTO> ajaxCartList(@RequestParam("caMid") String mId){
		cartList = cartsvc.ajaxCartList(mId);
		return cartList;
	}

	//CartAddPlayList : 플레이리스트에서 장바구니 인설트
	@PostMapping("CartAddPlayList")
	public @ResponseBody List<CartDTO> CartAddPlayList(@ModelAttribute CartDTO cart) {

		cartList = cartsvc.CartAddPlayList(cart);

		return cartList;
	}

	//	CartAddCheck : 장바구니에 이미 담았는지 확인하는 메소드
	@PostMapping("CartAddCheck")
	public @ResponseBody List<CartDTO> CartAddCheck(@ModelAttribute CartDTO cart){

		cartList = cartsvc.CartAddCheck(cart);

		return cartList;
	}

	//CartAddPlayListDelete
	@PostMapping("CartAddPlayListDelete")
	public @ResponseBody List<CartDTO> CartAddPlayListDelete(@ModelAttribute CartDTO cart){
		cartList = cartsvc.CartAddPlayListDelete(cart);
		return cartList;
	}

}
