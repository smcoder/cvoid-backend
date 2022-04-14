package org.smcoder.cvoid.dao;

import org.smcoder.cvoid.domain.Region;
import org.springframework.stereotype.Repository;

/**
 * RegionDao继承基类
 */
@Repository
public interface RegionDao extends MyBatisBaseDao<Region, Integer> {
}