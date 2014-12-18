package com.sp.platform.dao;

import com.sp.platform.domain.User;
import com.yangl.common.hibernate.HibernateDaoUtil;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: mopdzz
 * Date: 14-12-17
 * Time: 上午8:19
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDao extends HibernateDaoUtil<User, Integer>{
}
