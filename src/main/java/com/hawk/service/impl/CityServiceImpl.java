package com.hawk.service.impl;

import com.hawk.dao.CityMapper;
import com.hawk.entity.City;
import com.hawk.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangdonghao
 * @date 2019/5/30
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;


    @Override
    public List<City> findCityAll() {
        return cityMapper.findCityAll();
    }
}
