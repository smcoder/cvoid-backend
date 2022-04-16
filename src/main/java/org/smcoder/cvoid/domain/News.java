package org.smcoder.cvoid.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * news
 * @author 
 */
@Data
public class News implements Serializable {
    private Integer id;

    private Integer addressId;

    private String title;

    private String content;

    private String publishTime;

    private String source;

    private static final long serialVersionUID = 1L;
}