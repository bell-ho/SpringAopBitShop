package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.GoodsManager;
import com.example.demo.vo.GoodsVo;
@Repository
public class GoodsDao {
	public List<GoodsVo>listAll(){
		return GoodsManager.listAll();
	}
	public GoodsVo detail(int goodsno) {
		return GoodsManager.detail(goodsno);
	}
	public int insert(GoodsVo g) {
		return GoodsManager.insert(g);
	}
	public int delete(int goodsno) {
		return GoodsManager.delete(goodsno);
	}
}
