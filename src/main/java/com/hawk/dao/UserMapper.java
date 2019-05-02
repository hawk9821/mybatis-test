package com.hawk.dao;

import com.hawk.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zhangdonghao
 * @date 2019/4/15
 */
@Repository
public interface UserMapper extends Mapper<User>{

    List<User> findAll();
}
