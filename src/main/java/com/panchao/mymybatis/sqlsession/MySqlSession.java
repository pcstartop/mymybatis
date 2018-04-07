package com.panchao.mymybatis.sqlsession;

import java.lang.reflect.Proxy;

import com.panchao.mymybatis.entity.MapperBean;
import com.panchao.mymybatis.util.ConfigureFileUtil;
/**
 * 自定义session会话
 * @author PANCHAO
 *
 */
public class MySqlSession {
	private Excutor excutor = new MyExcutor();
	private MapperBean MapperBean = ConfigureFileUtil.getMapperBean("mapper/UserMapper.xml");
	@SuppressWarnings("unchecked")
	public <T> T getMapper(Class<T> target) {
		return (T) Proxy.newProxyInstance(target.getClassLoader(), new Class[]{target}, new MyMapperProxy(excutor,MapperBean));
	}
}
