package com.panchao.mymybatis.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.panchao.mymybatis.util.ConfigureFileUtil;
/**
 * 数据库连接管理类
 * @author PANCHAO
 *
 */
public class ConnectionManager {
	private Connection connection = null;

	public ConnectionManager() {
	}

	static{
		try {
			//加载驱动
			Class.forName(ConfigureFileUtil.getDataBase().getDriverClassName());
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动类!");
			e.printStackTrace();
		}
	}
	/**
	 * 获得数据库连接
	 * @return
	 */
	public Connection getConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(ConfigureFileUtil.getDataBase().getUrl(),
						ConfigureFileUtil.getDataBase().getUsername(), ConfigureFileUtil.getDataBase().getPassword());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	/**
	 * 释放资源
	 * @param connection
	 * @param ps
	 * @param rs
	 */
	public static void close(Connection connection,PreparedStatement ps,ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
