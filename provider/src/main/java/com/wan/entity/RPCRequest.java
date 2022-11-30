package com.wan.entity;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

/**
 * @author wan
 * @Description:
 * @date 2022/11/30 11:22
 */
@Data
@Builder
public class RPCRequest implements Serializable {
    private String intefaceName;
    private String methedName;
    private Object[] params;
    private Class<?>[] paramTypes;
}
