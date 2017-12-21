package com.gwxa.base.support;

import java.io.Serializable;

public class AbstractModel implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 编号*/
	private String bianh;

	public String getBianh() {
		return bianh;
	}

	public void setBianh(String bianh) {
		this.bianh = bianh;
	}

}
