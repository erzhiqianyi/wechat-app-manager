package com.erzhiqian.wechatappmanager.application.dto.platformapp;

import com.erzhiqian.wechatappmanager.application.dto.MiniProgramDevDomain;
import lombok.Data;

@Data
public class PlatformAppDomain {

    /**
     * 授权发起页域名
     */
    private String loginAuthorizationDomain;

    /**
     * 授权事件接收 URL
     */
    private String authorizationCallbackURL;


    /**
     * 消息与事件接收URL
     */
    private String messageCallbackURL;

    /**
     * 小程序服务器域名
     */
    private MiniProgramDevDomain miniProgramDevDomain;

}
