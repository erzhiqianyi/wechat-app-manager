package com.erzhiqian.wechatappmanager.application.dto.sandbox;

import com.erzhiqian.wechatappmanager.application.dto.NewAuthorizerInfo;

/**
 * 创建测试公众号所需信息
 *
 * @author 二之前一
 * @CreateDate 2020年12月1日
 */
public class NewSandBoxApp {

    /**
     * 应用编号
     */
    private String appId;

    /**
     * 应用账号信息
     */
    private NewAuthorizerInfo authorizerInfo;


    /**
     * 测试公众号开发配置
     */
    private SandboxAppDevProfile devProfile;

}
