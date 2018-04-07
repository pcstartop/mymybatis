package com.panchao.mymybatis.mapper;

import com.panchao.mymybatis.entity.UserEntity;

public interface UserMapper {
	UserEntity selectById(String id);
	Integer insert(String name,String sex);
	Integer delete(String id);
	Integer update(String sex);
	Integer updateById(String name,String sex,String id);
}
