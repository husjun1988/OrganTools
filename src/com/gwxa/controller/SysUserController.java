package com.gwxa.controller;

import java.util.List;

import com.gwxa.base.utils.Paramater;
import com.gwxa.model.SysUser;
import com.gwxa.service.SysUserService;

public class SysUserController{

	public static boolean Login(String zhangh, String mim) {
		SysUserService service = new SysUserService();
		return service.login(zhangh, mim);
	}

	public static List<SysUser> list(Paramater para) {
		SysUserService service = new SysUserService();
		return service.list(para);
	}
}
