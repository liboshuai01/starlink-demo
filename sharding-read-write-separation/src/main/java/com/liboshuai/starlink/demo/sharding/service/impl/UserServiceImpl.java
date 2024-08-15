package com.liboshuai.starlink.demo.sharding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.liboshuai.starlink.demo.sharding.dao.UserDAO;
import com.liboshuai.starlink.demo.sharding.entity.UserEntity;
import com.liboshuai.starlink.demo.sharding.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;

    @Override
    public void hello() {
        // 查询从库中的用户信息（两个从库轮训其中一个）
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<UserEntity>().eq(UserEntity::getUsername, "lbs");
        UserEntity userEntity = userDAO.selectOne(queryWrapper);
        System.out.println("userEntity = " + userEntity);
        // 更新数据到主库
        userEntity.setPassword("liboshuai@2024");
        userDAO.updateById(userEntity);
        // 查询从库中的用户信息（两个从库轮训其中一个）
        UserEntity newUserEntity = userDAO.selectOne(queryWrapper);
        System.out.println("newUserEntity = " + newUserEntity);
    }
}
