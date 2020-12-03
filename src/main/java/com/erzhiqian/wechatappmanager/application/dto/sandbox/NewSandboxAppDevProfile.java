package com.erzhiqian.wechatappmanager.application.dto.sandbox;

import com.erzhiqian.wechatappmanager.application.dto.NewMpDevProfile;
import lombok.Data;


/**
 * 测试公众号开发配置
 *
 * @author 二之前一
 * @CreateDate 2020年12月1日
 */
@Data
public class NewSandboxAppDevProfile {

    /**
     * 开发策略
     */
    private String devStrategy;

    /**
     *  公众号开发配置
     */
    private NewMpDevProfile devProfile;



}
