package com.panchao.mymybatis.main;


import com.panchao.mymybatis.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;

public class UserOperationTest {
    @Test
    public void insertUser() {
        Assert.assertEquals(1, UserOperation.insertUser("张三", "男"));
    }

    @Test
    public void updateOneUserById() {
        Assert.assertEquals(1, UserOperation.updateOneUserById("李四", "女", "1"));
    }

    @Test
    public void updateMoreUserBySex() {
        Assert.assertEquals(1, UserOperation.updateMoreUserBySex("男"));
    }

    @Test
    public void deleteUserById() {
        Assert.assertEquals(1, UserOperation.deleteUserById("1"));
    }

    @Test
    public void selectById() {
        UserEntity userEntity = UserOperation.selectById("1");
        Assert.assertEquals("1", userEntity.getId());
    }
}