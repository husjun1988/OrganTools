package com.gwxa.base.jdbc;

import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gwxa.base.utils.PropertiesUtil;

public class ConnectionDB {

	private static final String DRIVER = PropertiesUtil.getKeyByJdbcProperties("jdbc.driver");
	private static final String URL = PropertiesUtil.getKeyByJdbcProperties("jdbc.url");
	private static final String USERNAME = PropertiesUtil.getKeyByJdbcProperties("jdbc.username");
	private static final String PASSWORD = PropertiesUtil.getKeyByJdbcProperties("jdbc.password");
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private CallableStatement callableStatement = null;
	private ResultSet resultSet = null;

	static {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this.connection;
	}

	public String executePro(String sql, String[] params) {
		String result = "";
		try {
			this.connection = getConnection();
			CallableStatement callableStatement = this.connection.prepareCall(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					callableStatement.setString(i + 1, params[i]);
				}
			}
			callableStatement.execute();
			this.resultSet = callableStatement.getResultSet();
			while (resultSet.next()) {
				result += this.resultSet.getString("resultSet");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Map<String, Object>> executeProList(String sql, String[] params) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			this.connection = getConnection();
			CallableStatement callableStatement = this.connection.prepareCall(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					callableStatement.setString(i + 1, params[i]);
				}
			}
			callableStatement.execute();
			this.resultSet = callableStatement.getResultSet();
			while (resultSet.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("resultSet", this.resultSet.getString("resultSet"));
				//map.put("details", this.resultSet.getString("details"));
				list.add(map);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Object> executeQuery(String sql, Object[] params) {
		List<Object> list = new ArrayList<Object>();
		try {
			this.connection = getConnection();

			this.preparedStatement = this.connection.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					this.preparedStatement.setObject(i + 1, params[i]);
				}
			}
			this.resultSet = this.preparedStatement.executeQuery();
			while (this.resultSet.next()) {
				list.add(this.resultSet.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String executeQueryReStr(String sql, Object[] params) {
		String result = "";
		try {
			this.connection = getConnection();

			this.preparedStatement = this.connection.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					this.preparedStatement.setObject(i + 1, params[i]);
				}
			}
			this.resultSet = this.preparedStatement.executeQuery();
			while (this.resultSet.next()) {
				result = this.resultSet.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Integer executeQueryReInteger(String sql, Object[] params) {
		int result = 0;
		try {
			this.connection = getConnection();

			this.preparedStatement = this.connection.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					this.preparedStatement.setObject(i + 1, params[i]);
				}
			}
			this.resultSet = this.preparedStatement.executeQuery();
			while (this.resultSet.next()) {
				result = this.resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public <T> List<T> executeQueryList(String sql, Object[] params, Class<T> clazz) {
		List<T> list = new ArrayList<T>();
		try {
			this.connection = getConnection();

			this.preparedStatement = this.connection.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					this.preparedStatement.setObject(i + 1, params[i]);
				}
			}
			this.resultSet = this.preparedStatement.executeQuery();
			ResultSetMetaData rsm = this.resultSet.getMetaData();
			int colNumber = rsm.getColumnCount();
			Field[] fields = clazz.getDeclaredFields();

			while (this.resultSet.next()) {
				T obj = clazz.newInstance();
				for(int i = 1;i <= colNumber; i++) {
					Object value = this.resultSet.getObject(i);
					for(int j = 0; j < fields.length; j++) {
						Field f = fields[j];
						if(f.getName().toLowerCase().equals(rsm.getColumnName(i).toLowerCase())) {
							boolean flag = f.isAccessible();
							f.setAccessible(true);
							f.set(obj, value);
							f.setAccessible(flag);
							break;
						}
					}
				}
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public <T> T executeQueryRePojo(String sql, Object[] params, Class<T> clazz) {
		T obj = null;
		try {
			obj = clazz.newInstance();
			this.connection = getConnection();

			this.preparedStatement = this.connection.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					this.preparedStatement.setObject(i + 1, params[i]);
				}
			}
			this.resultSet = this.preparedStatement.executeQuery();
			ResultSetMetaData rsm = this.resultSet.getMetaData();
			int colNumber = rsm.getColumnCount();
			Field[] fields = clazz.getDeclaredFields();

			while (this.resultSet.next()) {
				for(int i = 1;i <= colNumber; i++) {
					Object value = this.resultSet.getObject(i);
					for(int j = 0; j < fields.length; j++) {
						Field f = fields[j];
						if(f.getName().toLowerCase().equals(rsm.getColumnName(i).toLowerCase())) {
							boolean flag = f.isAccessible();
							f.setAccessible(true);
							f.set(obj, value);
							f.setAccessible(flag);
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	public int executeUpdate(String sql, Object[] params) {
		int affectedLine = 0;
		try {
			this.connection = getConnection();

			this.preparedStatement = this.connection.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					this.preparedStatement.setObject(i + 1, params[i]);
				}
			}
			affectedLine = this.preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			closeAll();
		}
		return affectedLine;
	}

	private void closeAll() {
		if (this.resultSet != null) {
			try {
				this.resultSet.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		if (this.preparedStatement != null) {
			try{
				this.preparedStatement.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		if (this.callableStatement != null) {
			try{
				this.callableStatement.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		if (this.connection != null) {
			try {
				this.connection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

