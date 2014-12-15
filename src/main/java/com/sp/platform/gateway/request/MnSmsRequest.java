package com.sp.platform.gateway.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: mopdzz
 * Date: 14-12-10
 * Time: 上午7:24
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@ToString(callSuper=true)
@XmlRootElement
public class MnSmsRequest {
    private String serviceId;
    private String linkId;
}
