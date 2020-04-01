package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.GoodsDao;
import com.example.demo.vo.GoodsVo;
import com.google.gson.Gson;

@RestController
public class GoodsController {
	@Autowired
	private GoodsDao dao;

	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "/listGoods.do",produces = "application/json;charset=UTF-8")
	public String listAll() {
		String str = "";
		List<GoodsVo>list = dao.listAll();
		Gson gson = new Gson();
		str = gson.toJson(list);
		return str;
	}
	@RequestMapping(value = "/detailGoods.do",produces = "application/json;charset=UTF-8")
	public String detail(int goodsno) {
		String str = "";
		GoodsVo g = dao.detail(goodsno);
		Gson gson = new Gson();
		str = gson.toJson(g);
		return str;
	}
	@RequestMapping(value = "/insertGoods.do",produces = "application/json;charset=UTF-8")
	public int insert(GoodsVo g) {
		int re= -1;
		System.out.println();
		String str = "";
		re = dao.insert(g);
		Gson gson = new Gson();
		str = gson.toJson(re);
		return re;
	}
	@RequestMapping(value = "/deleteGoods.do",produces = "application/json;charset=UTF-8")
	public int delete(int goodsno) {
		int re= -1;
		String str = "";
		re = dao.delete(goodsno);
		Gson gson = new Gson();
		str = gson.toJson(re);
		return re;
	}
}
