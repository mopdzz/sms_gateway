package com.sp.platform.gateway.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: mopdzz
 * Date: 14-12-17
 * Time: 上午8:29
 * To change this template use File | Settings | File Templates.
 */@Getter
   @Setter
   @ToString(callSuper=true)
   @XmlRootElement
public class UserRequest {
    private Integer id;
    private String name;
    private String passwd;
}
