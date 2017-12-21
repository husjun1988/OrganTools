package com.gwxa.controller;

import com.gwxa.service.SysUserService;

public class SysUserController{

	public static boolean Login(String zhangh, String mim) {
		SysUserService service = new SysUserService();
		return service.login(zhangh, mim);
	}
}
