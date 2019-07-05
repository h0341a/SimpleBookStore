package study.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.ssm.dao.UserDAO;
import study.ssm.entity.User;
import study.ssm.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean checkUser(User user) {
        User userFromDB = userDAO.queryByUsername(user.getUsername());
        return userFromDB != null && userFromDB.getPassword().equals(user.getPassword());
    }
}
