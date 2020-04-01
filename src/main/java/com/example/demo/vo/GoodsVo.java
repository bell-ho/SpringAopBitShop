package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GoodsVo {
	private int goodsno;
	private String goodsname;
	private String fname;
	private int qty;
	private int price;
}
