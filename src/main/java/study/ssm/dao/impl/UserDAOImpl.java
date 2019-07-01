package study.ssm.dao.impl;

import study.ssm.dao.UserDAO;
import study.ssm.entity.User;
import study.ssm.utils.ConnMariaDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    @Override
    public User queryByUsername(String username) {
        String sql = "SELECT * FROM user Where username = ?";
        ConnMariaDB.connInit();
        try {
            PreparedStatement ps = ConnMariaDB.connection.prepareStatement(sql);
            ps.setObject(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new User(rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException e) {
            System.err.println("获取sql语句执行对象失败!");
            e.printStackTrace();
        }
        return null;
    }
}
