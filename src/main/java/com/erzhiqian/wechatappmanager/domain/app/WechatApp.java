package com.erzhiqian.wechatappmanager.domain.app;

import com.erzhiqian.wechatappmanager.application.dto.NewDevProfile;
import com.erzhiqian.wechatappmanager.domain.app.value.AppType;
import com.erzhiqian.wechatappmanager.domain.app.value.AuthorizerInfo;
import com.erzhiqian.wechatappmanager.domain.app.value.DevProfile;
import com.erzhiqian.wechatappmanager.domain.app.value.WechatAppId;
import com.erzhiqian.wechatappmanager.domain.tenant.Tenant;


/**
 * 微信信用
 *
 * @author 二之前一
 * @CreateDate 2020年10月31日
 */
public class WechatApp {

    private Tenant tenant;

    private WechatAppId id;

    private AppType appType;

    private AuthorizerInfo authorizerInfo;

    private DevProfile devProfile;


}
