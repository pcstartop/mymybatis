package com.panchao.mymybatis.entity;
/**
 * 用户实体类
 * @author PANCHAO
 *
 */
public class UserEntity {
	private String id;
	private String name;
	private String sex;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "[id="+id+",name="+name+",sex="+sex+"]";
	}
}
