package com.panchao.mymybatis.sqlsession;

import com.panchao.mymybatis.entity.Method;
/**、
 * 执行器
 * @author PANCHAO
 *
 */
public interface Excutor {
	public <T> T execute(Method method,Object[] parameter);
}
