package com.panchao.mymybatis.main;

import com.panchao.mymybatis.entity.UserEntity;
import com.panchao.mymybatis.mapper.UserMapper;
import com.panchao.mymybatis.sqlsession.MySqlSession;

/**
 * 增删改查类
 * @author PANCHAO
 *
 */
public class UserOperation {
	private static UserMapper userMapper = new MySqlSession().getMapper(UserMapper.class);

	public static int insertUser(String name,String sex) {
		return userMapper.insert(name,sex);
	}
	public static int updateOneUserById(String name,String sex,String id){
		return userMapper.updateById(name, sex, id);
	}
	public static int updateMoreUserBySex(String sex){
		return userMapper.update(sex);
	}
	public static int deleteUserById(String id){
		return userMapper.delete(id);
	}
	public static UserEntity selectById(String id){
		return userMapper.selectById(id);
	}
}
