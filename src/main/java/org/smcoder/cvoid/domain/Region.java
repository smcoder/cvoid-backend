package org.smcoder.cvoid.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * region
 * @author 
 */
@Data
public class Region implements Serializable {
    private Integer id;

    private String province;

    private String city;

    private static final long serialVersionUID = 1L;
}