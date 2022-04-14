package org.smcoder.cvoid.dao;

import org.smcoder.cvoid.domain.Rebot;
import org.springframework.stereotype.Repository;

/**
 * RebotDao继承基类
 */
@Repository
public interface RebotDao extends MyBatisBaseDao<Rebot, Integer> {
}