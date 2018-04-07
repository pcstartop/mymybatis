package com.panchao.mymybatis.main;

import com.panchao.mymybatis.entity.UserEntity;
import com.panchao.mymybatis.mapper.UserMapper;
import com.panchao.mymybatis.sqlsession.MySqlSession;
/**
 * 测试类
 * @author PANCHAO
 *
 */
public class Test {
	public static void main(String[] args) {
		UserMapper userMapper = new MySqlSession().getMapper(UserMapper.class);
		//新增
		Integer i = userMapper.insert("关羽", "男");
		System.out.println(i);
		//修改
		i = userMapper.updateById("紫菱", "女", "3");
		System.out.println(i);
		i = userMapper.update("男");
		System.out.println(i);
		//删除
		i = userMapper.delete("3");
		System.out.println(i);
		//查询
		UserEntity userEntity = userMapper.selectById("1");
		System.out.println(userEntity);
	}
}
