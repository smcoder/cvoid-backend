package org.smcoder.cvoid.dao;

import org.smcoder.cvoid.domain.SmCount;
import org.smcoder.cvoid.example.SmCountExample;
import org.springframework.stereotype.Repository;

/**
 * SmCountDao继承基类
 */
@Repository
public interface SmCountDao extends MyBatisBaseDao<SmCount, Integer> {
    SmCount selectByExample(SmCountExample example);
}