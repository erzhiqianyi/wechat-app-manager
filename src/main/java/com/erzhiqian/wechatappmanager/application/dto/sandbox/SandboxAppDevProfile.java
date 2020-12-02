package com.erzhiqian.wechatappmanager.application.dto.sandbox;

import com.erzhiqian.wechatappmanager.application.dto.MpDevProfile;
import lombok.Data;


/**
 * 测试公众号开发配置
 *
 * @author 二之前一
 * @CreateDate 2020年12月1日
 */
@Data
public class SandboxAppDevProfile {

    /**
     * 开发策略,根据策略确定使用 公众号开发配置还是由第三方平台代为实现开发
     */
    private String devStrategy;

    /**
     *  公众号开发配置
     */
    private MpDevProfile mpDevProfile;

    /**
     * 代托管第三方平台应用编号
     */
    private String proxyPlathFormAppId;






}
