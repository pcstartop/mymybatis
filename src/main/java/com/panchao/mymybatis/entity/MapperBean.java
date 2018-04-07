package com.panchao.mymybatis.entity;

import java.util.List;
/**
 * mapper文件属性Bean
 * @author PANCHAO
 *
 */
public class MapperBean {
	private String interfaceName;
	private List<Method> methodList;
	public String getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public List<Method> getMethodList() {
		return methodList;
	}
	public void setMethodList(List<Method> methodList) {
		this.methodList = methodList;
	}
	@Override
	public String toString() {
		return "[interfaceName="+interfaceName+",methodList="+methodList.toString()+"]";
	}
}
