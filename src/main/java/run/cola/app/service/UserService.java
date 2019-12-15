package run.cola.app.service;

import run.cola.app.po.User;

public interface UserService {

    User checkUser(String username,String password);
}
