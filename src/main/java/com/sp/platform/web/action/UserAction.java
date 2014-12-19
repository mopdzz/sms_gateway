package com.sp.platform.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sp.platform.domain.User;
import com.sp.platform.service.UserService;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mopdzz
 * Date: 14-12-19
 * Time: 上午7:53
 * To change this template use File | Settings | File Templates.
 */
@Namespace("/manage")
@Scope("prototype")
@InterceptorRefs({@InterceptorRef("loginInterceptor")})
@Results({@Result(name = "list", location = "list.jsp")})
public class UserAction extends ActionSupport {
    @Autowired
    private UserService userService;
    private List<User> list;
    private int id;

    public String list(){
        list = userService.getAll();
        return "list";
    }

    public String delete() {
        if (id > 0) {
            userService.delete(id);
        }
        return list();
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
