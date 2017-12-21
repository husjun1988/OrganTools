package com.gwxa.base.support;

import java.util.List;

import com.gwxa.base.utils.ClassUtil;
import com.gwxa.base.utils.Paramater;

@SuppressWarnings("unchecked")
public class AbstractService<T extends AbstractModel> implements IService<T> {

	/**
	 * mapper接口
	 * */
	private IMybatis<T> dao;

	/** 默认pojo都会带的字段*/
	private static final String TABLENAME="tablename";
	/** model对象的主键*/
	private static final String BH = "bh";
	/** model对象的主键集*/
	private static final String BHS = "bhs";

	protected Class<?> entityType;

	public Class<?> getEntityType() {
		if(null == this.entityType) {
			this.entityType = (Class<T>) ClassUtil.actualTypes(getClass())[0];
		}
		return entityType;
	}

	public void setEntityType(Class<?> entityType) {
		this.entityType = entityType;
	}

	protected IMybatis<T> getDao() {
		return this.dao;
	}

	public String getTableName() {
		return ClassUtil.GetFieldValue(ClassUtil.born(this.getEntityType()), TABLENAME).toString();
	}

	@Override
	public T find(String bh) {
		return getDao().find(Paramater.buildByKeys(TABLENAME, getTableName(), BH, bh));
	}

	@Override
	public T findByKeys(String... keys) {
		return getDao().findByKeys(Paramater.bulidByKeys(getTableName(), keys));
	}

	@Override
	public List<T> list(String... keys) {
		return (List<T>)getDao().selectByKeys(Paramater.bulidByKeys(getTableName(), keys));
	}

	@Override
	public Boolean update(T entity) {
		Paramater para =bu
		return null;
	}

	@Override
	public Boolean insert(T entity) {
		return null;
	}

}
