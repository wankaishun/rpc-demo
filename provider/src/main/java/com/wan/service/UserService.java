package com.wan.service;

import com.wan.entity.User;

/**
 * @author wan
 * @Description:
 * @date 2022/11/29 17:56
 */
public interface UserService {
    User getUserByUserId(Integer id);
}
