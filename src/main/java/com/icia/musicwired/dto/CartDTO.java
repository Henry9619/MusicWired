package com.icia.musicwired.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("Cart")
public class CartDTO {
	
	private int carCode;
	private String caMid;
	private int caMuCode;
	private int caAmount;

}
