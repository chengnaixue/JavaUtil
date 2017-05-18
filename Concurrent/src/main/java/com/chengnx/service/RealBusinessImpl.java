package com.chengnx.service;

public class RealBusinessImpl implements BusinessInterface {

	@Override
	public void dosomething(String username) {
		
		System.out.println("正在为用户：" + username + "，进行真实的业务处理。。。");
		
	}

}
