package org.smcoder.cvoid.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * rebot
 * @author 
 */
@Data
public class Rebot implements Serializable {
    private Integer id;

    private String key;

    private String content;

    private static final long serialVersionUID = 1L;
}