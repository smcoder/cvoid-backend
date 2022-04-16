package org.smcoder.cvoid.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * sm_count
 * @author 
 */
@Data
public class SmCount implements Serializable {
    private Integer id;

    private Integer addressId;

    private String addressName;

    private Integer newAdd;

    private Integer sumCount;

    private Integer goodCount;

    private Integer deathCount;

    private static final long serialVersionUID = 1L;
}