package ua.com.fok.dao;

import ua.com.fok.domain.User;
import ua.com.fok.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD<User> {
    User getUserByEmail(String email);
}