package study.ssm.dao.impl;

import study.ssm.dao.UserDAO;
import study.ssm.entity.User;
import study.ssm.utils.MySqlSessionFactory;
import java.io.IOException;

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
