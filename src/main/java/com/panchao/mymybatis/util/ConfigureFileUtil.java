package com.panchao.mymybatis.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.panchao.mymybatis.entity.DataBase;
import com.panchao.mymybatis.entity.MapperBean;
import com.panchao.mymybatis.entity.Method;
import com.panchao.mymybatis.enums.SqlTypeEnum;
/**
 * 配置文件读取工具类
 * @author PANCHAO
 *
 */
public class ConfigureFileUtil {
	private static ClassLoader classLoader = ClassLoader.getSystemClassLoader();

	/**
	 * 获取数据库连接配置信息
	 * 
	 * @return
	 */
	public static DataBase getDataBase() {
		DataBase dataBase = new DataBase();
		InputStream in = classLoader.getResourceAsStream("mybatis-config.xml");
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(in);
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Element root = document.getRootElement();
		if (!"database".equals(root.getName())) {
			return null;
		}
		for (Object item : root.elements("property")) {
			Element property = (Element) item;
			switch (property.attributeValue("name")) {
			case "driverClassName":
				dataBase.setDriverClassName(property.getText());
				break;
			case "url":
				dataBase.setUrl(property.getText());
				break;
			case "username":
				dataBase.setUsername(property.getText());
				break;
			case "password":
				dataBase.setPassword(property.getText());
				break;
			default:
				break;
			}
		}
		return dataBase;
	}
	/**
	 * 获取对应的mapperXML文件配置信息
	 * @param mapperBeanPath
	 * @return
	 */
	public static MapperBean getMapperBean(String mapperBeanPath) {

		InputStream in = classLoader.getResourceAsStream(mapperBeanPath);
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(in);
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Element root = document.getRootElement();
		String interfaceName = root.attributeValue("namespace");

		MapperBean mapperBean = new MapperBean();
		List<Method> methods = new ArrayList<>();
		Method method = null;
		Element methodElement = null;
		for (Object item : root.elements()) {
			methodElement = (Element) item;
			method = new Method();
			method.setMethodName(methodElement.attributeValue("id"));
			method.setParameterType(methodElement.attributeValue("parameterType"));
			method.setResultType(methodElement.attributeValue("resultType"));
			switch (methodElement.getName()) {
			case "insert":
				method.setSqltype(SqlTypeEnum.INSERT);
				break;
			case "delete":
				method.setSqltype(SqlTypeEnum.DELETE);
				break;
			case "update":
				method.setSqltype(SqlTypeEnum.UPDATE);
				break;
			case "select":
				method.setSqltype(SqlTypeEnum.SELECT);
				break;
			default:
				break;
			}
			method.setSql(methodElement.getTextTrim());
			methods.add(method);
		}
		mapperBean.setInterfaceName(interfaceName);
		mapperBean.setMethodList(methods);
		return mapperBean;
	}

	/**
	 * 测试工具类
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DataBase dataBase = getDataBase();
		System.out.println(dataBase);
		MapperBean mapperBean = getMapperBean("mapper/UserMapper.xml");
		System.out.println(mapperBean);
	}
}
