package ua.com.fok.service.impl;

import org.apache.log4j.Logger;
import ua.com.fok.dao.UserDao;
import ua.com.fok.dao.impl.UserDaoImplementation;
import ua.com.fok.domain.User;
import ua.com.fok.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImplementation implements UserService {
    private static Logger LOGGER = Logger.getLogger(UserServiceImplementation.class);
    private static UserService userServiceImpl;
    private UserDao userDao;

    private UserServiceImplementation() {
        try {
            userDao = new UserDaoImplementation();
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.error(e);
        }
    }

    public static UserService getUserService() {
        if (userServiceImpl == null) {
            userServiceImpl = new UserServiceImplementation();
        }

        return userServiceImpl;
    }

    @Override
    public User create(User t) {

        return userDao.create(t);
    }

    @Override
    public User read(Integer id) {
        return userDao.read(id);
    }

    @Override
    public User update(User t) {
        return userDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public List<User> readAll() {
        return userDao.readAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

}
