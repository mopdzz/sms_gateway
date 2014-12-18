package com.sp.platform.service;

import com.sp.platform.domain.User;

/**
 * Created with IntelliJ IDEA.
 * User: mopdzz
 * Date: 14-12-17
 * Time: 上午8:19
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    public User get(int id);
    public void delete(int id);
    public void save(User user);
    public User checkUser(User user);
}
