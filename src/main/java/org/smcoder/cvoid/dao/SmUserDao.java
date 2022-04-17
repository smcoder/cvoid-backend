package org.smcoder.cvoid.dao;

import org.smcoder.cvoid.domain.PageUser;
import org.smcoder.cvoid.domain.SmUser;
import org.smcoder.cvoid.example.SmUserExample;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SmUserDao继承基类
 */
@Repository
public interface SmUserDao extends MyBatisBaseDao<SmUser, Integer> {
    SmUser selectByExample(SmUserExample example);

    List<SmUser> selectList(PageUser pageUser);
}