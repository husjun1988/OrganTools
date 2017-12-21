package com.gwxa.base.utils;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

@SuppressWarnings("rawtypes")
public class VerifyUtil {
	/**
	 * 基本类型
	 */
	public static final Class<?>[] BASIC_TYPES = { String.class, Number.class, Date.class };

	/**
	 * isEmpty
	 */

	public static Boolean isEmpty(Object target) {
		if (null == target) {
			return true;
		} else if (target instanceof String) {
			return ((String) target).trim().isEmpty();
		} else if (target.getClass().isArray()) {
			return ((Object[]) target).length < 1;
		} else if (target instanceof Collection) {
			return ((Collection) target).size() < 1;
		} else if (target instanceof Map) {
			return ((Map) target).size() < 1;
		} else {// ###
			return target.toString().trim().isEmpty();
		}
	}

	public static Boolean isEmpty(String str) {
		return null == str || str.trim().isEmpty();
	}

	/**
	 * 是否中文
	 */
	public static Boolean isChinese(String str) {
		return null != str && str.length() < str.getBytes().length;
	}

	/**
	 * 判断类型是否基本类型
	 */
	public static Boolean basicType(Class<?> type) {
		for (Class<?> basicType : BASIC_TYPES) {
			if (basicType.isAssignableFrom(type)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 验证字符串是否符合正则表达式
	 */
	public static Boolean regex(String input, String regex) {
		return Pattern.compile(regex).matcher(input).find();
	}
}
