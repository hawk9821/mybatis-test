package com.hawk.service.impl;

import com.hawk.dao.TestScan;
import com.hawk.dao.UserMapper;
import com.hawk.entity.User;
import com.hawk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhangdonghao
 * @date 2019/4/16
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TestScan scan;

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public void insert(User user) {
        userMapper.insertSelective(user);
//        int a = 1/0;
    }

    @Override
    public List<User> findAll() {
        scan.test();
        return userMapper.findAll();
    }
}
