package com.sp.platform.service.impl;

import com.sp.platform.dao.UserDao;
import com.sp.platform.domain.User;
import com.sp.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mopdzz
 * Date: 14-12-17
 * Time: 上午8:19
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class UserSericeImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User get(int id) {
        return userDao.get(id);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User checkUser(User user) {
        User dbUser = userDao.findUniqueBy("name", user.getName());
        if(dbUser != null && dbUser.getPasswd().equalsIgnoreCase(user.getPasswd())){
            return dbUser;
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
