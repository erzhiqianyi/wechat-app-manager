package com.erzhiqian.wechatappmanager.domain.app.value;

import java.security.Principal;

/**
 * @author 二之前一
 * @CreateDate 2020年10月31日
 */
public class AuthorizerInfo {

    private String nickname;

    private Image headImage;

    private String username;

    private Principal  principal;

    private Image qrCodeUrl;


    public AuthorizerInfo(String nickname, String username, Principal principal) {
        this.nickname = nickname;
        this.username = username;
        this.principal = principal;
    }
}
