package com.gwxa.base.utils;

import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 公共传递参数变量
 *
 * @author husjun
 *
 */
@SuppressWarnings("unused")
public class Paramater {

	/** 参数变量 */
	private Map<String, Object> para;

	/** 主键 */
	private String bh;

	/** 表名称 */
	private String tablename;

	/** 键 */
	private String key;

	/** 值 */
	private String value;

	/** 需要修改的对象 */
	private Object obj;

	/** 插入SQL语句 */
	private String insertsql;

	/** 修改SQL语句 */
	private String updatesql;

	/** 查询的条件语句 */
	private String wheresql;

	/**  排序以及排序语句 */
	private String orderbysql;

	/** 起始位置 */
	private Integer offset=0;

	/** 一页多少条 */
	private Integer limit=20;

	/** 排序方式 */
	private String order = " DESC ";

	/** 默认排序字段 */
	private String sort ="bianh";

	/** 主键集合 */
	private String bhs;

	/** 查询字段集合 */
	private String keys;

	/** 查询字段集合 */
	private String where;

	/** 插入后返回的编号 */
	private Integer BIANH;

	/** 当前页条数 */
	private Integer pageSize = 15;

	/** 当前页码 */
	private Integer pageNumber =1;


	/**
	 * 放值
	 *
	 * @param key
	 * @param value
	 */
	public Paramater put(String key, Object value) {
		if (para == null) {
			para = new HashMap<String, Object>();
		}
		para.put(key, value);
		return this;
	}

	/**
	 * 取值
	 *
	 * @param key
	 * @return
	 */
	public  Object get(String key) {
		if (para == null) {
			return null;
		}
		return para.get(key);
	}



	public Object getObj() {
		if (obj != null) {
			return obj;
		}
		return null;
	}

	/**
	 * 创建参数类
	 * @param tablename 表名
	 * @param obj 需要处理的对象
	 * */
	public static Paramater bulidByObj(String tablename,Object obj) {
		Paramater para = new Paramater();
		para.setTablename(tablename);
		if(obj != null) {
			para.insertsql = BuildSQL.buildInsertSql(obj);
			para.updatesql = BuildSQL.buildUpdateSql(obj);
			para.setObj(obj);
		}
		return para;
	}

	public static Paramater bulidByKeys(String tablename,String...paras){
		Paramater para = new Paramater();
		para.tablename = tablename;
		if (paras !=null) {
			para.keys =" where bianh > 0";
			for (int i = 0; i < paras.length; i=i+2) {
				para.keys += " and "+paras[i] +" = '"+paras[i+1]+"' ";
				para.put(paras[i], paras[i+1]);
			}

		}
		return para;
	}

	/**
	 * 创建参数类
	 * @param tablename 表名
	 * @param Map<String, Object> 需要处理的参数
	 * */
	public static Paramater bulidByMaps(String tablename, Map<String, Object> param) {
		Paramater para = new Paramater();
		para.tablename = tablename;
		if (param !=null) {
			para.keys =" where bianh > 0";
			Set<String> keys = param.keySet();
			Iterator<String> it = keys.iterator();
			String key;
			while (it.hasNext()) {
				key = it.next();
				para.keys += " and "+ key +" = '"+ param.get(key) +"' ";
				para.put(key, param.get(key));
			}
		}
		return para;
	}

	public static String bulidUrlByParams(Map<String, Object> param) {
		String paramString = "";
		if (param !=null) {
			//logger.debug("当前参数:"+param.toString());
			Set<String> keys = param.keySet();
			Iterator<String> it = keys.iterator();
			String key;
			while (it.hasNext()) {
				key = it.next();
				paramString += "&" + key + "=" + param.get(key);
			}
			paramString = paramString.substring(1);
		}
		return paramString;
	}

	public static Paramater bulidByParams(String key, Object value) {
		Paramater para = new Paramater();
		para.put(key, value);
		return para;
	}

	public  Paramater appendMap(Map<String,String> map){
		Set<String> keys = map.keySet();
		keys.forEach(n-> put(n, map.get(n)));
		return this;
	}

	public String getBh() {
		return bh;
	}

	public void setBh(String bh) {
		this.bh = bh;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getInsertsql() {
		return insertsql;
	}

	public void setInsertsql(String insertsql) {
		this.insertsql = insertsql;
	}

	public String getUpdatesql() {
		return updatesql;
	}

	public void setUpdatesql(String updatesql) {
		this.updatesql = updatesql;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}


	/**
	 * 确认obj值是否存在
	 *
	 * @param obj
	 * @return
	 */
	public  Boolean isEmpty(String key) {
		return get(key) != null && !"".equals(get(key));
	}

	/**
	 * 取值
	 *
	 * @param obj
	 * @return
	 */
	public  String getStr(String key) {
		return isEmpty(key) ? "" + get(key) : null;
	}

	/**
	 * 获取数字类型的值
	 *
	 * @param obj
	 * @return
	 */
	public  Integer getInteger(String key) {
		return isEmpty(key) ? Integer.parseInt(getStr(key)) : null;
	}

	/**
	 * 获取浮点类型的值
	 *
	 * @param obj
	 * @return
	 */
	public  Double getDouble(String key) {
		return isEmpty(key) ? Double.parseDouble(getStr(key)) : null;
	}

	/**
	 * 获取数字
	 *
	 * @param obj
	 * @return
	 */
	public  Integer getInt(String key) {
		return isEmpty(key) ? Integer.parseInt(getStr(key)):null;
	}

	public static Paramater buildByKeys(String...keys){
		Paramater para = new Paramater();
		for (int i = 0; i < keys.length; i=i+2) {
			if (null == keys[i+1]) {
				continue;
			}
			para.put(keys[i], keys[i+1]);
		}
		return para;
	}

	public Paramater addPara(String...keys){
		for (int i = 0; i < keys.length; i=i+2) {
			put(keys[i], keys[i+1]);
		}
		return this;
	}

	public void bulidPage() {
		this.offset = pageSize * (pageNumber - 1);
		this.limit = pageSize;
	}

	public Paramater addWhereSql(String sql){
		if (this.wheresql ==null) {
			wheresql = sql;
		}else{
			wheresql += sql;
		}
		return this;
	}

	public Paramater tranParaToArray(String key,String _split){
		String value = getStr(key);
		if (value ==null) {
			return null;
		}
		put(key, Arrays.asList(value.split(_split)));
		return this;
	}

	public String getWheresql() {
		return wheresql;
	}

	public void setWheresql(String wheresql) {
		this.wheresql = wheresql + " and neibzt = 1 ";
	}

	public String getOrderbysql() {
		return " order by "+sort +" "+order +" limit "+offset+","+limit;
	}

	public void setOrderbysql(String orderbysql) {
		this.orderbysql = orderbysql;
	}

	public String getBhs() {
		return bhs;
	}

	public void setBhs(String bhs) {
		this.bhs = bhs;
	}

	public String getKeys() {
		return keys;
	}

	public void setKeys(String keys) {
		this.keys = keys;
	}

	public Map<String, Object> getPara() {
		return para;
	}

	public void setPara(Map<String, Object> para) {
		this.para = para;
	}

	public Paramater setSort(String sort) {
		this.sort = sort;
		return this;
	}

	public Paramater setOrder(String order) {
		this.order = order;
		return this;
	}

	public Integer getOffset() {
		return offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public Integer getBIANH() {
		return BIANH;
	}

	public Paramater setBIANH(Integer BIANH) {
		this.BIANH = BIANH;
		return this;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Paramater setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public Paramater setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
		return this;
	}

	public String getWhere() {
		return where;
	}

	public Paramater setWhere(String where) {
		this.where = where;
		return this;
	}

	public String getOrder() {
		return order;
	}

	public String getSort() {
		return sort;
	}

	public Paramater setOffset(Integer offset) {
		this.offset = offset;
		return this;
	}

	public Paramater setLimit(Integer limit) {
		this.limit = limit;
		return this;
	}



}
