package com.gwxa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gwxa.base.utils.Paramater;
import com.gwxa.model.SysUser;

public interface SysUserMapper {
	/**
	  * 根据ID获取一条记录
	  * */
	@Select("select * from ${tablename} where bianh = #{bh}")
	public SysUser find(Paramater para);

	/**
	 * 根据关键字查询一条记录
	 * */
	@Select("select * from ${tablename} ${keys}")
	public SysUser findByKeys(Paramater para);

	/**
	 * 查询集合
	 * */
	@Select("select * from ${tablename} ${keys}")
	public List<SysUser> selectByKeys(Paramater para);

	/**
	 * 修改一条记录
	 * */
	@Update("update ${tablename} set ${updatesql} where bianh = #{para.bianh}")
	public Integer updateByModel(Paramater para);

	/**
	 * 插入一条记录
	 * */
	@Insert("insert into ${tablename} ${insertsql}")
	@Options(useGeneratedKeys=true, keyProperty="bianh")
	public Integer insert(Paramater para);
}
