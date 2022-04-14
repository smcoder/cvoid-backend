package org.smcoder.cvoid.dao;

import org.smcoder.cvoid.domain.SmCount;
import org.springframework.stereotype.Repository;

/**
 * SmCountDao继承基类
 */
@Repository
public interface SmCountDao extends MyBatisBaseDao<SmCount, Integer> {
}