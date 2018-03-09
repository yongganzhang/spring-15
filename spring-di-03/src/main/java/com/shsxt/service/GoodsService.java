package com.shsxt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shsxt.dao.GoodsDao;

@Service
public class GoodsService {
	
	@Autowired
	private GoodsDao goodsdao;
	
	public void  print () {
		System.out.println(goodsdao);
	}
	
	

}
