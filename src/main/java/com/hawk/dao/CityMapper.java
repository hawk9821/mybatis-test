package com.hawk.dao;

import com.hawk.entity.City;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangdonghao
 * @date 2019/5/30
 */
@Repository
public interface CityMapper {

    List<City> findCityAll();
}
