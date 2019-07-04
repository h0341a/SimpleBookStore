package study.ssm.dao.impl;

import org.apache.ibatis.session.SqlSession;
import study.ssm.dao.UserDAO;
import study.ssm.entity.User;
import study.ssm.utils.ConnMariaDB;
import study.ssm.utils.MySqlSessionFactory;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    @Override
    public User queryByUsername(String username) {
        try {
            MySqlSessionFactory.getSqlSession();
            UserDAO userDAO = MySqlSessionFactory.session.getMapper(UserDAO.class);
            User user = userDAO.queryByUsername(username);
            MySqlSessionFactory.closeSession();
            return user;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
