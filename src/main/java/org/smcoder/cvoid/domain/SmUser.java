package org.smcoder.cvoid.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * sm_user
 * @author 
 */
@Data
public class SmUser implements Serializable {
    private Integer id;

    private String account;

    private String password;

    private String name;

    private String phone;

    private String addressId;

    private Integer role;

    private static final long serialVersionUID = 1L;
}