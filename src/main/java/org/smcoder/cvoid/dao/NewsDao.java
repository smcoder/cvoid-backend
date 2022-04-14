package org.smcoder.cvoid.dao;

import org.smcoder.cvoid.domain.News;
import org.springframework.stereotype.Repository;

/**
 * NewsDao继承基类
 */
@Repository
public interface NewsDao extends MyBatisBaseDao<News, Integer> {
}