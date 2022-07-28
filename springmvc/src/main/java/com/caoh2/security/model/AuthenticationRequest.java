package com.caoh2.security.model;

import lombok.Data;

/**
 * 认证请求结构
 */
@Data
public class AuthenticationRequest {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
