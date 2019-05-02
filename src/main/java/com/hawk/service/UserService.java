package com.hawk.service;

import com.hawk.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangdonghao
 * @date 2019/4/15
 */
@Service
public interface UserService {
    User getUserById(Integer id);

    void insert(User user);

    List<User> findAll();
}
