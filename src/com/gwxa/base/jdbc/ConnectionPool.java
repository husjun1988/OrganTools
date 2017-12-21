package com.gwxa.base.jdbc;

/**
*@description
*
* @author husjun
* @date 2017年9月20日上午9:52:25
* @version
*/
public class ConnectionPool {
	public static ConnectionDB getInstance() {
		ConnectionDB db = null;
		try {
			if (db == null) {
				synchronized (ConnectionDB.class) {
					if (db == null) {
						db = new ConnectionDB();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return db;
	}
}
