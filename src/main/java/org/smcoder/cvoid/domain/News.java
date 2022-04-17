package org.smcoder.cvoid.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * news
 * @author 
 */
@Data
public class News implements Serializable {
    private Integer id;

    private String addressId;

    private String title;

    private String content;

    private String publishTime;

    private static final long serialVersionUID = 1L;
}