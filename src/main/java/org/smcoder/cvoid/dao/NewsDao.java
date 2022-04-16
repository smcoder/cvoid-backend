package org.smcoder.cvoid.dao;

import org.smcoder.cvoid.domain.News;
import org.smcoder.cvoid.example.NewsExample;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * NewsDao继承基类
 */
@Repository
public interface NewsDao extends MyBatisBaseDao<News, Integer> {

    List<News> selectByExample(NewsExample example);
}