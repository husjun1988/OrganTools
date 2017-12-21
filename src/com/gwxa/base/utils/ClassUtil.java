package com.gwxa.base.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类辅助类
 *
 * @author rockw
 *
 */
public class ClassUtil {

	/**
	 * 获取某类中的某属性值
	 *
	 * @param c
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static Object GetFieldValue(Object o, String field) {
		try {
			Field _field = o.getClass().getDeclaredField(field);
			_field.setAccessible(true);
			return _field.get(o);
		} catch (Exception e) {
			throw Errors.wrap("获取obj中的值时出现了异常, 字段名为:" + field, e);
		}
	}

	/**
	 * 设置某类中某属性值
	 *
	 * @param c
	 * @param field
	 * @param object
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static void SetFieldValue(Object o, String field, Object value) {
		try {
			Field _field = o.getClass().getDeclaredField(field);
			_field.setAccessible(true);
			_field.set(o, value);
		} catch (Exception e) {
			throw Errors.wrap("给obj设置值时出现了异常, 字段名为:" + field + ",值为:" + value, e);
		}
	}

	/**
	 * 超类的泛型参数在子类中的实际类型
	 *
	 * @param subType
	 *            子类类型
	 */
	public static Type[] actualTypes(Class<?> subType) {
		try {
			return ((ParameterizedType) subType.getGenericSuperclass()).getActualTypeArguments();
		} catch (Exception e) {// 不能转换为ParameterizedType或者数组越界的异常,探测他的超类
			return Object.class == subType.getSuperclass() ? null : actualTypes(subType.getSuperclass());
		}
	}

	/**
	 * 根据传入的类型初始化一个对象
	 */
	public static <T> T born(Class<T> type) {
		try {
			return type.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 调用对象方法
	 */
	public static Object invoke(Object target, Method method, Object... args) {
		try {
			return method.invoke(target, args);
		} catch (Exception e) {
			throw new RuntimeException(target + "\n" + method, e);
		}
	}

	/**
	 * 调用对象方法
	 */
	public static Object invoke(Object target, String methodName, Object... args) {
		return invoke(target, getMethod(target.getClass(), methodName, typesOf(args)), args);
	}

	/**
	 * 返回一组对象的类型数组
	 */
	public static Class<?>[] typesOf(Object... objects) {
		Class<?>[] types = new Class[objects.length];
		for (int i = 0; i < objects.length; i++) {
			types[i] = objects[i].getClass();
		}
		return types;
	}

	/**
	 * 在类型上查找方法
	 */
	public static Method getMethod(Class<?> targetType, String methodName, Class<?>... argTypes) {
		try {
			Method method = targetType.getMethod(methodName, argTypes);// 在当前类型中查找方法
			return method;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 返回属性的Setter方法
	 */
	public static Method getSetter(Class<?> targetType, String field, Class<?> type) {
		return getMethod(targetType, "set" + StringUtil.upcaseFirst(field), type);
	}

	/**
	 * 返回属性的Getter方法
	 */
	public static Method getGetter(Class<?> targetType, String field) {
		return getMethod(targetType, "get" + StringUtil.upcaseFirst(field));
	}

	/**
	 * 返回属性值
	 */
	public static Object get(Object target, String field) {
		return invoke(target, getGetter(target.getClass(), field));
	}

	/**
	 * 设置属性值
	 */
	public static void set(Object target, String field, Object value) {
		invoke(target, getSetter(target.getClass(), field, value.getClass()), value);
	}

	/**
	 * 返回类型的一个属性
	 */
	public static Field getField(Class<?> type, String fieldName) {
		try {
			Field field = type.getDeclaredField(fieldName);
			field.setAccessible(true);
			return field;
		} catch (Exception e) {
			if (!type.getSuperclass().equals(Object.class)) {
				return getField(type.getSuperclass(), fieldName);
			} else {
				throw new RuntimeException("type=" + type + "\tfieldName=" + fieldName, e);
			}
		}
	}

	/**
	 * 返回指定类型的所有指定类型的属性
	 */
	public static List<Field> listFields(Class<?> targetType, Class<?> fieldType) {
		List<Field> fieldList = new ArrayList<Field>();
		List<Field> allFields = listFields(targetType);
		for (Field field : allFields) {
			if (fieldType.isAssignableFrom(field.getType())) {
				fieldList.add(field);
			}
		}
		return fieldList;
	}

	/**
	 * 返回指定类型的所有属性
	 */
	public static List<Field> listFields(Class<?> targetType) {
		List<Field> fieldList = new ArrayList<Field>();
		Field[] fields = targetType.getDeclaredFields();
		for (Field field : fields) {
			fieldList.add(field);
		}
		if (!Object.class.equals(targetType.getSuperclass())) {// 扫描超类的Field
			fieldList.addAll(listFields(targetType.getSuperclass()));
		}
		return fieldList;
	}

	/**
	 * 返回指定类型的所有方法
	 */
	public static List<Method> getMethods(Class<?> targetType) {
		List<Method> methodList = new ArrayList<Method>();
		Method[] methods = targetType.getDeclaredMethods();
		for (Method method : methods) {
			methodList.add(method);
		}
		if (!Object.class.equals(targetType.getSuperclass())) {// 扫描超类的Field
			methodList.addAll(getMethods(targetType.getSuperclass()));
		}
		return methodList;
	}

	/**
	 * 为对象的某个字段设值
	 */
	public static void set(Object target, Field field, Object value) {
		try {
			field.setAccessible(true);
			field.set(target, value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 返回类型的字段列表
	 */
	public static List<Field> getFields(Class<?> type) {
		List<Field> fields = new ArrayList<Field>();
		Collections.addAll(fields, type.getDeclaredFields());
		if (Object.class != type.getSuperclass()) {// 扫描超类的Field
			fields.addAll(getFields(type.getSuperclass()));
		}
		return fields;
	}

	/**
	 * 返回对象的字段值
	 */
	public static Object get(Object target, Field field) {
		try {
			field.setAccessible(true);
			return field.get(target);
		} catch (Exception e) {
			throw Errors.wrap(e);
		}
	}

	/**
	 * 检查一个类型是否存在
	 */
	public static Boolean exists(String type) {
		try {
			Class.forName(type);
			return true;
		} catch (Throwable e) {
			return false;
		}
	}

	/**
	 * 根据传入的类型名返回类型
	 */
	public static Class<?> getType(String type) {
		try {
			return Class.forName(type);
		} catch (ClassNotFoundException e) {
			throw Errors.wrap(e);
		}
	}

	public static Object born(String driverClassName) {
		return born(getType(driverClassName));
	}

	/**
	 * 将一个类值加入map（属性值为int型时，0时不加入，
	 * 属性值为String型或Long时为null和“”不加入）
	 *
	 */
	public static Map<String, Object> toMap(Object obj){
		Map<String, Object> map = new HashMap<String, Object>();
		if(obj==null){
			return null;
		}
		Field[] fields = obj.getClass().getDeclaredFields();
		for(Field field : fields){
			String fieldName =  field.getName();
			if(getValueByFieldName(fieldName,obj)!=null)
				map.put(fieldName,  getValueByFieldName(fieldName,obj));
		}

		return map;

	}

	/**
	 * 根据属性名获取该类此属性的值
	 * @param fieldName
	 * @param object
	 * @return
	 */
	private static Object getValueByFieldName(String fieldName,Object object){
		String firstLetter=fieldName.substring(0,1).toUpperCase();
		String getter = "get"+firstLetter+fieldName.substring(1);
		try {
			Method method = object.getClass().getMethod(getter, new Class[]{});
			Object value = method.invoke(object, new Object[] {});
			return value;
		} catch (Exception e) {
			return null;
		}

	}
}
