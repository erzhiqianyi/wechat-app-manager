package com.erzhiqian.wechatappmanager.domain.app.value;

/**
 * @author 二之前一
 * @CreateDate 2020年10月31日
 */
public class AuthorizerInfo {

    private String nickname;

    private Image headImage;

    private String username;

    private AuthenticatePrincipal  principal;

    private Image qrCodeUrl;


    public AuthorizerInfo(String nickname, String username, AuthenticatePrincipal principal) {
        this.nickname = nickname;
        this.username = username;
        this.principal = principal;
    }
}
