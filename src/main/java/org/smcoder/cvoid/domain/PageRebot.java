package org.smcoder.cvoid.domain;

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
public class PageRebot extends Page implements Serializable {
    private Integer id;

    private String key;

    private String content;

    private static final long serialVersionUID = 1L;

    public PageRebot(long total, List rows) {
        super(total, rows);
    }
}