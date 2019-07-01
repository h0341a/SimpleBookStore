package study.ssm.service.impl;

import study.ssm.dao.UserDAO;
import study.ssm.dao.impl.UserDAOImpl;
import study.ssm.entity.User;
import study.ssm.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    public boolean checkUser(User user) {
        User userFromDB = userDAO.queryByUsername(user.getUsername());
        return userFromDB != null && userFromDB.getPassword().equals(user.getPassword());
    }
}
