package com.sp.platform.domain;

import com.sp.platform.gateway.util.CustomDateJsonSerializer;
import com.sp.platform.gateway.util.CustomDateXmlSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: mopdzz
 * Date: 14-12-17
 * Time: 上午8:19
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_user")
public class User implements Serializable {
    private static final long serialVersionUID = -3861549558520520632L;

    private Integer id;
    private String name;
    private String passwd;
    private int role;
    private Date ctime;
    private Date utime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    @XmlJavaTypeAdapter(CustomDateXmlSerializer.class)
    @JsonSerialize(using = CustomDateJsonSerializer.class)
    public Date getCtime() {
        return ctime;
    }

    @XmlJavaTypeAdapter(CustomDateXmlSerializer.class)
    @JsonSerialize(using = CustomDateJsonSerializer.class)
    public Date getUtime() {
        return utime;
    }
}
