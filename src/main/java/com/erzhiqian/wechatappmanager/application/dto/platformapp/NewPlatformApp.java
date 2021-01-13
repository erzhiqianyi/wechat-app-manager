package com.erzhiqian.wechatappmanager.application.dto.platformapp;

import com.erzhiqian.wechatappmanager.application.dto.NewAuthorizerInfo;
import lombok.Data;

/**
 *
 * 创建第三方平台账号所需资料
 *
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
    private PlatformAppDevProfile devProfile;


}
