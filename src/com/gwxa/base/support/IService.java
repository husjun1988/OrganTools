package com.gwxa.base.support;

import java.util.List;

public interface IService<T extends AbstractModel> {
	 /**
	  * 根据ID获取一条记录
	  * */
	public T find(String bh);

	/**
	 * 根据关键字查询一条记录
	 * */
	public T findByKeys(String... keys);

	/**
	 * 查询集合
	 * */
	public List<T> list(String... keys);

	/**
	 * 修改一条记录
	 * */
	public Boolean update(T entity);

	/**
	 * 插入一条路基
	 * */
	public Boolean insert(T entity);
}
