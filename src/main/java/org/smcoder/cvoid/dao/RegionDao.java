package org.smcoder.cvoid.dao;

import org.smcoder.cvoid.domain.Region;
import org.smcoder.cvoid.example.RegionExample;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * RegionDao继承基类
 */
@Repository
public interface RegionDao extends MyBatisBaseDao<Region, Integer> {

    List<Region> selectByExample(RegionExample example);
}