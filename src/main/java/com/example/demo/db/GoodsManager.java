package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.catalina.Session;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.GoodsVo;

public class GoodsManager {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlMapconfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static List<GoodsVo>listAll(){
		SqlSession session = factory.openSession();
		List<GoodsVo>list = session.selectList("goods.list");
		session.close();
		return list;
	}
	public static GoodsVo detail(int goodsno) {
		SqlSession session =factory.openSession();
		GoodsVo g = session.selectOne("goods.detail",goodsno);
		session.close();
		return g;
	}
	public static int insert(GoodsVo g) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("goods.insert",g);
		session.close();
		return re;
	}
	public static int delete(int goodsno) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("goods.delete",goodsno);
		session.close();
		return re;
	}
}
