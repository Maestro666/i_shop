package ua.com.fok.service;

import ua.com.fok.domain.User;
import ua.com.fok.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User> {
    User getUserByEmail(String email);
}
