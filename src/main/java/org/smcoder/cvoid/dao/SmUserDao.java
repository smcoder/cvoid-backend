package org.smcoder.cvoid.dao;

import org.smcoder.cvoid.domain.SmUser;
import org.springframework.stereotype.Repository;

/**
 * SmUserDao继承基类
 */
@Repository
public interface SmUserDao extends MyBatisBaseDao<SmUser, Integer> {
}