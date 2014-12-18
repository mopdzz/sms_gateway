package com.sp.platform.service;

import com.sp.platform.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
