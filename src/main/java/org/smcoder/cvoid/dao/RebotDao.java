package org.smcoder.cvoid.dao;

import org.smcoder.cvoid.domain.Rebot;
import org.smcoder.cvoid.example.RebotExample;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * RebotDao继承基类
 */
@Repository
public interface RebotDao extends MyBatisBaseDao<Rebot, Integer> {
    List<Rebot> selectByExample(RebotExample example);
}