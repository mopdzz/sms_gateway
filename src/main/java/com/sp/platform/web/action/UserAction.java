package com.sp.platform.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sp.platform.domain.User;
import com.sp.platform.service.UserService;
import com.yangl.common.Constants;
import com.yangl.common.CookieHelper;
import com.yangl.common.Struts2Utils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: mopdzz
 * Date: 14-12-18
 * Time: 下午11:43
 * To change this template use File | Settings | File Templates.
 */
@Namespace("/")
@Scope("request")
@Results({@Result(name = "success", location = "${goingToURL}", type = "redirect")})
public class UserAction  extends ActionSupport {
    private static Logger logger = LoggerFactory.getLogger(UserAction.class);
    @Resource
    private UserService userService;

    private String goingToURL = "/index.jsp";
    private boolean rememberMe;
    private User user;
    private String message;
    /**
     * 登陆
     */
    @Action("doLogin")
    public String doLogin() {
        user = userService.checkUser(user);
        if (user != null) {
            logger.info("login is success");
            if (rememberMe) {
                CookieHelper.instance.addPublicCookie(Constants.COOKIE_KEY, user.getName() + ";" + user.getPasswd(), 60 * 60 * 24 * 7 * 2, ServletActionContext.getResponse());
                logger.info("writer cookie is success...");
            }
            Struts2Utils.getSession().setAttribute(Constants.SESSION_KEY, user);
            if (Struts2Utils.getSession().getAttribute(Constants.GOTO_URL_KEY) != null) {
                String goto_url = Struts2Utils.getSession().getAttribute(Constants.GOTO_URL_KEY).toString();
                if (StringUtils.isNotEmpty(goto_url)) {
                    logger.info("response will goto : " + goto_url);
                    setGoingToURL(goto_url);
                    Struts2Utils.getSession().removeAttribute(Constants.GOTO_URL_KEY);
                }
            } else {
                logger.info("url is goto : " + goingToURL);
                setGoingToURL(goingToURL);
            }
            return SUCCESS;
        } else {
            logger.info("user name or pwd error...");
            message = "用户名或密码错误";
            return "login";
        }
    }

    public String getGoingToURL() {
        return goingToURL;
    }

    public void setGoingToURL(String goingToURL) {
        this.goingToURL = goingToURL;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
