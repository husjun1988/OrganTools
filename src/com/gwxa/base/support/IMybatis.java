package com.gwxa.base.support;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gwxa.base.utils.Paramater;

public interface IMybatis<T extends AbstractModel> {

	/**
	  * 根据ID获取一条记录
	  * */
	@Select("select * from ${tablename} where bianh = #{bh}")
	public T find(Paramater para);

	/**
	 * 根据关键字查询一条记录
	 * */
	@Select("select * from ${tablename} ${keys}")
	public T findByKeys(Paramater para);

	/**
	 * 查询集合
	 * */
	@Select("select * from ${tablename} ${keys}")
	public List<T> selectByKeys(Paramater para);

	/**
	 * 修改一条记录
	 * */
	@Update("update ${tablename} set ${updatesql} where bianh = #{para.bianh}")
	public Boolean update(Paramater para);

	/**
	 * 插入一条记录
	 * */
	@Insert("insert into ${tablename} ${insertsql}")
	@Options(useGeneratedKeys=true, keyProperty="bianh")
	public Boolean insert(Paramater para);
}
