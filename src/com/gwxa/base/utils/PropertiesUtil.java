package com.gwxa.base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.gwxa.base.constant.SystemConstant;


/**
 * 对于配置文件的操作辅助类
 *
 * @author husjun
 *
 */
public class PropertiesUtil {

	public static String getUrl(){
		String path=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String os =System.getProperty("os.name");
		if (os.toLowerCase().startsWith("win")) {
			return path.substring(1,path.length());
		}
		return path;
	}

	/**
	 * 获取默认的Properties文件中的文件
	 *
	 * @param key
	 * @return
	 */
	public static String getKeyByDefaultProperties(String key) {
		return getDefaultProperties().getProperty(key);
	}

	/**
	 * 获取JDBC的Properties文件中的文件
	 *
	 * @param key
	 * @return
	 */
	public static String getKeyByJdbcProperties(String key) {
		return getJDBCProperties().getProperty(key);
	}


	/**
	 * 获取默认的Properties文件
	 *
	 * @return
	 */
	public static Properties getDefaultProperties() {
		return getProperties(getUrl()+SystemConstant.DEFAULTPROPERTIES);
	}

	/**
	 * 获取默认的Properties文件
	 *
	 * @return
	 */
	public static Properties getJDBCProperties() {
		return getProperties(getUrl()+SystemConstant.JDBCPROPERTIES);
	}

	/**
	 * 根据文件路径，获取Properties文件
	 *
	 * @param fileUrl
	 * @return
	 */
	public static Properties getProperties(String fileUrl) {
		File file = new File(fileUrl);
		Properties prop = new Properties();
		try {
			InputStream in = new FileInputStream(file);
			prop.load(in);
			return prop;
		} catch (IOException e) {
			throw Errors.wrap("获取IProperties 文件异常，路径为(\" + " + fileUrl + ")", e);
		}
	}

	/**
	 * 根据文件路径，获取Properties文件
	 *
	 * @param fileUrl
	 * @return
	 */
	public static Properties loadProperties(String fileUrl) {
		File file = new File(getUrl()+fileUrl);
		Properties prop = new Properties();
		try {
			InputStream in = new FileInputStream(file);
			prop.load(in);
			return prop;
		} catch (IOException e) {
			throw Errors.wrap("获取IProperties 文件异常，路径为(\" + " + fileUrl + ")", e);
		}
	}

}
