package com.panchao.mymybatis.sqlsession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.panchao.mymybatis.entity.MapperBean;
/**
 * 动态代理生成mapper接口实现类
 * @author PANCHAO
 *
 */
public class MyMapperProxy implements InvocationHandler {
	private Excutor excutor;
	private MapperBean MapperBean;
	
	public MyMapperProxy(Excutor excutor, MapperBean MapperBean) {
		super();
		this.excutor = excutor;
		this.MapperBean = MapperBean;
	}

	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		
		if (!MapperBean.getInterfaceName().equals(arg1.getDeclaringClass().getName())) {
			return null;
		}
		for (com.panchao.mymybatis.entity.Method method : MapperBean.getMethodList()) {
			if (arg1.getName().equals(method.getMethodName())) {
				return excutor.execute(method,arg2);
			}
		}
		return null;
	}

}
