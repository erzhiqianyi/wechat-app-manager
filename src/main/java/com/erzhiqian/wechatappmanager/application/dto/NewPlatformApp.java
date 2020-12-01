package com.erzhiqian.wechatappmanager.application.dto;

import lombok.Data;

/**
 * 第三方平台账号信息
 * @author 二之前一
 * @CreateDate 2020年12月1日
 */
@Data
public class NewPlatformApp {

    /**
     * 应用编号
     */
    private String appId;

    /**
     * 应用账号信息
     */
    private NewAuthorizerInfo authorizerInfo;

    /**
     * 开发配置
     */
    private NewDevProfile devProfile;
}
