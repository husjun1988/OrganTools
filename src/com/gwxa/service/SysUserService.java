package com.gwxa.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.gwxa.base.constant.SystemConstant;
import com.gwxa.base.support.AbstractService;
import com.gwxa.base.utils.ClassUtil;
import com.gwxa.base.utils.Cryptos;
import com.gwxa.base.utils.DBUtil;
import com.gwxa.base.utils.Hex;
import com.gwxa.base.utils.Paramater;
import com.gwxa.mapper.SysUserMapper;
import com.gwxa.model.SysUser;

public class SysUserService extends AbstractService<SysUser>{

	private SysUserMapper sysUserMapper = DBUtil.getSession().getMapper(SysUserMapper.class);

	public boolean login(String zhangh, String mim) {
		try {
			SysUser sysuser = sysUserMapper.findByKeys(Paramater.bulidByKeys("T_SYS_USER", "zhangh", zhangh, "mim", Hex.encode(Cryptos.aesEncrypt(mim.getBytes("UTF-8"), SystemConstant.KEY_CODE.getBytes("UTF-8")))));
			if(sysuser != null && sysuser.getBianh() != null) {
				return true;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return false;

	}

	public List<SysUser> list(Paramater para) {
		Paramater paras = Paramater.bulidByMaps(getTableName(), para.getPara());
		return sysUserMapper.selectByKeys(paras);
	}
}
