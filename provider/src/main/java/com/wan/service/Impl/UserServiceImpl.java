package com.wan.service.Impl;

import com.wan.entity.User;
import com.wan.service.UserService;
import java.util.Random;
import java.util.UUID;

/**
 * @author wan
 * @Description:
 * @date 2022/11/29 17:57
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUserByUserId(Integer id) {
        System.out.println("客户端查询了"+id+"的用户");
        Random random = new Random();
        User user = User.builder().userName(UUID.randomUUID().toString())
                .id(id).sex(random.nextBoolean()).build();
        return user;
    }
}
