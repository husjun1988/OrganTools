package com.gwxa.base.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings({"rawtypes"})
public class BuildSQL {

	public static<T>String buildInsertSql(Object obj){
		StringBuffer insertSqlkey = new StringBuffer();
		StringBuffer insertSqlvalue = new StringBuffer();
		Class cls = obj.getClass();
		try {
			BeanInfo bean_a = Introspector.getBeanInfo(cls);// 获取类属性
			PropertyDescriptor[] propertyDescriptors_a = bean_a.getPropertyDescriptors();//获取所有字段对象
			List<PropertyDescriptor> list= Arrays.asList(propertyDescriptors_a);//把字段对象转换成为一个集合
			list.forEach(n -> buildInsertSql(insertSqlkey, insertSqlvalue, n, obj ));
		} catch (Exception e){
			e.printStackTrace();
		}
		return " ( "+StringUtil.subStrByRight(insertSqlkey.toString(),1) + " ) value ( " +StringUtil.subStrByRight(insertSqlvalue.toString(),1) +" )";
	}

	public static void buildInsertSql(StringBuffer updateSqlkey,StringBuffer updateSqlvalue,PropertyDescriptor descriptor,Object obj){
		try {
			if (descriptor.hashCode() ==0 || descriptor.getName().equals("class")) {
				return;
			}
			Object value = descriptor.getReadMethod().invoke(obj);
			if (value != null && !"".equals(value)) {
				updateSqlkey.append(descriptor.getName()+",");
				updateSqlvalue.append("'"+escape(value)+"',");
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static<T>String buildUpdateSql(Object obj){
		StringBuffer updateSql = new StringBuffer();
		Class cls = obj.getClass();
		try {
			BeanInfo bean_a = Introspector.getBeanInfo(cls);// 获取类属性
			PropertyDescriptor[] propertyDescriptors_a = bean_a.getPropertyDescriptors();//获取所有字段对象
			List<PropertyDescriptor> list= Arrays.asList(propertyDescriptors_a);//把字段对象转换成为一个集合
			list.forEach(n -> buildUpdateSql(updateSql, n, obj ));
		} catch (Exception e){
			e.printStackTrace();
		}
		return ""+StringUtil.subStrByRight(updateSql.toString(),1);
	}

	public static void buildUpdateSql(StringBuffer updateSql,PropertyDescriptor descriptor,Object obj){
		try {
			if (descriptor.hashCode() ==0 || descriptor.getName().equals("class")) {
				return;
			}
			Object value = descriptor.getReadMethod().invoke(obj);
			if (value != null && !"".equals(value)) {
				updateSql.append(descriptor.getName()+" = '"+escape(value)+"',");
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static String escape(Object value) {
		return (""+value).replaceAll("'", "\'") ;
	}
}
