package com.panchao.mymybatis.entity;

import com.panchao.mymybatis.enums.SqlTypeEnum;
/**
 * mapper文件中增删改查属性Bean
 * @author PANCHAO
 *
 */
public class Method {
	private String methodName; // 方法名
	private String parameterType; // 参数类型
	private String resultType; // 返回类型
	private SqlTypeEnum sqltype; // sql的类型,计划在xml读取有四种情况
	private String sql; // 执行的sql语句

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getParameterType() {
		return parameterType;
	}

	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public SqlTypeEnum getSqltype() {
		return sqltype;
	}

	public void setSqltype(SqlTypeEnum sqltype) {
		this.sqltype = sqltype;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	@Override
	public String toString() {
		return "[methodName=" + methodName + ",parameterType=" + parameterType + ",resultType=" + resultType.toString()
				+ ",sqltype=" + sqltype + ",sql=" + sql + "]";
	}
}
