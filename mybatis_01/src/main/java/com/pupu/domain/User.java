package com.pupu.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : lipu
 * @since : 2020-03-09 10:47
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -6750214402995747620L;

    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
}
