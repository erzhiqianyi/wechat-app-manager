package com.erzhiqian.wechatappmanager.domain.app;

import com.erzhiqian.wechatappmanager.domain.app.state.AppState;
import com.erzhiqian.wechatappmanager.domain.app.strategy.DevStrategy;
import com.erzhiqian.wechatappmanager.domain.app.value.AuthorizerInfo;
import com.erzhiqian.wechatappmanager.domain.app.value.WechatAppId;
import com.erzhiqian.wechatappmanager.domain.tenant.Tenant;


/**
 * 微信应用
 *
 * @author 二之前一
 * @CreateDate 2020年10月31日
 */
public class WechatApp {

    private Tenant tenant;

    private WechatAppId id;

    private AppState appState;

    private AuthorizerInfo authorizerInfo;

    private DevStrategy devStrategy;



}
