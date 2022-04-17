package org.smcoder.cvoid.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.smcoder.cvoid.response.Page;

import java.io.Serializable;
import java.util.List;

/**
 * sm_user
 * @author 
 */
@Getter
@Setter
public class PageUser extends Page implements Serializable {
    private Integer id;

    private String account;

    private String password;

    private String name;

    private String phone;

    private String addressId;

    private Integer role;

    private static final long serialVersionUID = 1L;

    public PageUser(long total, List rows) {
        super(total, rows);
    }
}