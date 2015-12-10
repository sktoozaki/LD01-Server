package com.kk.server.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by KK on 2015/12/9.
 */
public class MySqlDbIml implements DbDao {
    private Connection conn;
    private String driver;
    private String url;
    private String username;
    private String pass;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public MySqlDbIml(String driver, String url, String username, String pass) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.pass = pass;
    }

    public Connection getConnection() throws Exception {
        if (conn==null)
        {
            Class.forName(this.driver);
            conn= DriverManager.getConnection(url,username,pass);
        }
        return conn;
    }


    @Override
    public boolean insert(String sql , Object... args) {
        PreparedStatement pstmt = null;
        try {
            pstmt = getConnection().prepareStatement(sql);
            for (int i = 0; i < args.length ; i++ )
            {
                pstmt.setObject( i + 1 , args[i]);
            }
            if (pstmt.executeUpdate() != 1)
            {
                return false;
            }
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void modify(String sql, Object... args) {
        PreparedStatement pstmt = null;
        try {
            pstmt = getConnection().prepareStatement(sql);
            for (int i = 0; i < args.length ; i++ )
            {
                pstmt.setObject( i + 1 , args[i]);
            }
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public ResultSet query(String sql, Object... args) {
        PreparedStatement pstmt = null;
        try {
            pstmt = getConnection().prepareStatement(sql);
            for (int i = 0; i < args.length ; i++ )
            {
                pstmt.setObject( i + 1 , args[i]);
            }
            return pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConn()
            throws Exception
    {
        if (conn != null && !conn.isClosed())
        {
            conn.close();
        }
    }
}
