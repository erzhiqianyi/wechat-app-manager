package com.erzhiqian.wechatappmanager.application.dto;

/**
 * 公众号开发配置
 */
public class NewMpDevProfile {

    /**
     * 代托管第三方平台应用编号
     */
    private String proxyPlathFormAppId;

    /**
     * 应用密钥
     */
    private String appSecret;

    /**
     * 消息校验token
     */
    private String token;

    /**
     * 微信消息和事件的接口URL
     */
    private String serverCallBackURL;

    /**
     * JS接口安全域名
     */
    private String jsSecurityURL;

    /**
     * 网页授权获取用户基本信息域名
     */
    private String webpageAuthorizationURL;
}
