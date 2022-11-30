package com.wan.entity;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

/**
 * @author wan
 * @Description:
 * @date 2022/11/30 11:24
 */
@Data
@Builder
public class RPCResponse implements Serializable {
    private int code;
    private String message;
    private Object data;
    public static RPCResponse success(Object data) {
        return RPCResponse.builder().code(200).data(data).build();
    }
    public static RPCResponse fail() {
        return RPCResponse.builder().code(500).message("服务器发生错误").build();
    }
}
