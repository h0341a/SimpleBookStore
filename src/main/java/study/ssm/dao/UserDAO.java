package study.ssm.dao;

import study.ssm.entity.User;

public interface UserDAO {

    User queryByUsername(String username);

}
