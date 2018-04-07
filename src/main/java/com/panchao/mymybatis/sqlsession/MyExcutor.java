package com.panchao.mymybatis.sqlsession;
/**
 * 自定义执行器
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.panchao.mymybatis.dbmanager.ConnectionManager;
import com.panchao.mymybatis.entity.Method;

public class MyExcutor implements Excutor {
	private Connection connection = new ConnectionManager().getConnection();

	@SuppressWarnings("unchecked")
	@Override
	public <T> T execute(Method method, Object[] parameters) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		T result = null;
		try {
			ps = connection.prepareStatement(method.getSql());
			for (int i = 1; i <= parameters.length; i++) {
				ps.setString(i, String.valueOf(parameters[i-1]));
			}
			switch (method.getSqltype()) {
			case SELECT:
				rs = ps.executeQuery();
				result = (T) Class.forName(method.getResultType()).getDeclaredConstructor().newInstance();
				while (rs.next()) {
					for (java.lang.reflect.Method m : result.getClass().getDeclaredMethods()) {
						if (!"set".equals(m.getName().substring(0, 3))) {
							continue;
						}
						m.invoke(result, rs.getString(m.getName().substring(3)));
					}
				}
				break;
			case INSERT:
				result = (T) Integer.valueOf(ps.executeUpdate());
				break;
			case DELETE:
				result = (T) Integer.valueOf(ps.executeUpdate());
				break;
			case UPDATE:
				result = (T) Integer.valueOf(ps.executeUpdate());
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			ConnectionManager.close(connection, ps, rs);
		}
		return result;
	}
}
