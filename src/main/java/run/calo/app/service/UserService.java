package run.calo.app.service;

import run.calo.app.po.User;

public interface UserService {

    User checkUser(String username, String password);
}
