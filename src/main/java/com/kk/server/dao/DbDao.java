package com.kk.server.dao;

import java.sql.ResultSet;

/**
 * Created by KK on 2015/12/9.
 */
public interface DbDao {
    public boolean insert(String sql , Object... args);
    public void modify(String sql , Object... args );
    public ResultSet  query(String sql , Object... args);
}
