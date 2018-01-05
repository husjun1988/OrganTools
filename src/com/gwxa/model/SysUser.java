/**
 * @filename SysUser.java
 * @directory /src/com/gwxa/model
 * @package com.gwxa.model
 * @description [TODO]
 * @author husjun
 * @date 2017-12-21 21:42:58
 * @version v1.0
 */
package com.gwxa.model;

import com.gwxa.base.support.AbstractModel;

/**
 * @author husjun
 */
public class SysUser extends AbstractModel{

	private static final long serialVersionUID = 1L;

	private static final String tablename = "T_SYS_USER";

	/** 登录账户 */
	private String zhangh;
	/** 登录密码 */
	private String mim;
	/** 姓名 */
	private String xingm;
	/** 分类：1保密局端2机关单位 */
	private String fenl;
	/** 角色 */
	private String jues;
	/** 性别 */
	private String xingb;
	/** 手机号码 */
	private String shouj;
	/** 固定电话 */
	private String dianh;
	/** 出生日期 */
	private String chusrq;
	/** 电子邮件 */
	private String youj;
	/** 组织机构 */
	private String quybh;
	/** 组织机构名称 */
	private String quymc;
	/** 部门 */
	private String jigbm;
	/** 部门名称 */
	private String jigmc;
	/** 描述 */
	private String miaos;
	/** IP地址 */
	private String ipdz;
	/** 第一次访问时间 */
	private String diycfwsj;
	/** 上一次访问时间 */
	private String shangycfwsj;
	/** 最后访问时间 */
	private String zuihfwsj;
	/** 有效：1-有效，2-无效 */
	private Integer youx;
	/** 排序 */
	private Integer pai;
	/** 删除标记:1-正常，2-删除 */
	private Integer shancbj;
	/** 创建用户名称 */
	private String chuangjyhmc;
	/** 修改用户名称 */
	private String xiugyhmc;
	/** 内部状态1：正常2：删除 */
	private Integer neibzt;

	public SysUser(String zhangh, String mim) {
		this.zhangh = zhangh;
		this.mim = mim;
	}

	/**
	 * 获取[登录账户]
	 */
	public String getZhangh() {
		return zhangh;
	}
	/**
	 * 设置[登录账户]
	 */
	public void setZhangh(String zhangh) {
		this.zhangh = zhangh;
	}

	/**
	 * 获取[登录密码]
	 */
	public String getMim() {
		return mim;
	}
	/**
	 * 设置[登录密码]
	 */
	public void setMim(String mim) {
		this.mim = mim;
	}

	/**
	 * 获取[姓名]
	 */
	public String getXingm() {
		return xingm;
	}
	/**
	 * 设置[姓名]
	 */
	public void setXingm(String xingm) {
		this.xingm = xingm;
	}

	/**
	 * 获取[分类：1保密局端2机关单位]
	 */
	public String getFenl() {
		return fenl;
	}
	/**
	 * 设置[分类：1保密局端2机关单位]
	 */
	public void setFenl(String fenl) {
		this.fenl = fenl;
	}

	/**
	 * 获取[角色]
	 */
	public String getJues() {
		return jues;
	}
	/**
	 * 设置[角色]
	 */
	public void setJues(String jues) {
		this.jues = jues;
	}

	/**
	 * 获取[性别]
	 */
	public String getXingb() {
		return xingb;
	}
	/**
	 * 设置[性别]
	 */
	public void setXingb(String xingb) {
		this.xingb = xingb;
	}

	/**
	 * 获取[手机号码]
	 */
	public String getShouj() {
		return shouj;
	}
	/**
	 * 设置[手机号码]
	 */
	public void setShouj(String shouj) {
		this.shouj = shouj;
	}

	/**
	 * 获取[固定电话]
	 */
	public String getDianh() {
		return dianh;
	}
	/**
	 * 设置[固定电话]
	 */
	public void setDianh(String dianh) {
		this.dianh = dianh;
	}

	/**
	 * 获取[出生日期]
	 */
	public String getChusrq() {
		return chusrq;
	}
	/**
	 * 设置[出生日期]
	 */
	public void setChusrq(String chusrq) {
		this.chusrq = chusrq;
	}

	/**
	 * 获取[电子邮件]
	 */
	public String getYouj() {
		return youj;
	}
	/**
	 * 设置[电子邮件]
	 */
	public void setYouj(String youj) {
		this.youj = youj;
	}

	/**
	 * 获取[组织机构]
	 */
	public String getQuybh() {
		return quybh;
	}
	/**
	 * 设置[组织机构]
	 */
	public void setQuybh(String quybh) {
		this.quybh = quybh;
	}

	/**
	 * 获取[组织机构名称]
	 */
	public String getQuymc() {
		return quymc;
	}
	/**
	 * 设置[组织机构名称]
	 */
	public void setQuymc(String quymc) {
		this.quymc = quymc;
	}

	/**
	 * 获取[部门]
	 */
	public String getJigbm() {
		return jigbm;
	}
	/**
	 * 设置[部门]
	 */
	public void setJigbm(String jigbm) {
		this.jigbm = jigbm;
	}

	/**
	 * 获取[部门名称]
	 */
	public String getJigmc() {
		return jigmc;
	}
	/**
	 * 设置[部门名称]
	 */
	public void setJigmc(String jigmc) {
		this.jigmc = jigmc;
	}

	/**
	 * 获取[描述]
	 */
	public String getMiaos() {
		return miaos;
	}
	/**
	 * 设置[描述]
	 */
	public void setMiaos(String miaos) {
		this.miaos = miaos;
	}

	/**
	 * 获取[IP地址]
	 */
	public String getIpdz() {
		return ipdz;
	}
	/**
	 * 设置[IP地址]
	 */
	public void setIpdz(String ipdz) {
		this.ipdz = ipdz;
	}

	/**
	 * 获取[第一次访问时间]
	 */
	public String getDiycfwsj() {
		return diycfwsj;
	}
	/**
	 * 设置[第一次访问时间]
	 */
	public void setDiycfwsj(String diycfwsj) {
		this.diycfwsj = diycfwsj;
	}

	/**
	 * 获取[上一次访问时间]
	 */
	public String getShangycfwsj() {
		return shangycfwsj;
	}
	/**
	 * 设置[上一次访问时间]
	 */
	public void setShangycfwsj(String shangycfwsj) {
		this.shangycfwsj = shangycfwsj;
	}

	/**
	 * 获取[最后访问时间]
	 */
	public String getZuihfwsj() {
		return zuihfwsj;
	}
	/**
	 * 设置[最后访问时间]
	 */
	public void setZuihfwsj(String zuihfwsj) {
		this.zuihfwsj = zuihfwsj;
	}

	/**
	 * 获取[有效：1-有效，2-无效]
	 */
	public Integer getYoux() {
		return youx;
	}
	/**
	 * 设置[有效：1-有效，2-无效]
	 */
	public void setYoux(Integer youx) {
		this.youx = youx;
	}

	/**
	 * 获取[排序]
	 */
	public Integer getPai() {
		return pai;
	}
	/**
	 * 设置[排序]
	 */
	public void setPai(Integer pai) {
		this.pai = pai;
	}

	/**
	 * 获取[删除标记:1-正常，2-删除]
	 */
	public Integer getShancbj() {
		return shancbj;
	}
	/**
	 * 设置[删除标记:1-正常，2-删除]
	 */
	public void setShancbj(Integer shancbj) {
		this.shancbj = shancbj;
	}



	/**
	 * 获取[创建用户名称]
	 */
	public String getChuangjyhmc() {
		return chuangjyhmc;
	}
	/**
	 * 设置[创建用户名称]
	 */
	public void setChuangjyhmc(String chuangjyhmc) {
		this.chuangjyhmc = chuangjyhmc;
	}



	/**
	 * 获取[修改用户名称]
	 */
	public String getXiugyhmc() {
		return xiugyhmc;
	}
	/**
	 * 设置[修改用户名称]
	 */
	public void setXiugyhmc(String xiugyhmc) {
		this.xiugyhmc = xiugyhmc;
	}

	/**
	 * 获取[内部状态1：正常2：删除]
	 */
	public Integer getNeibzt() {
		return neibzt;
	}
	/**
	 * 设置[内部状态1：正常2：删除]
	 */
	public void setNeibzt(Integer neibzt) {
		this.neibzt = neibzt;
	}


}
