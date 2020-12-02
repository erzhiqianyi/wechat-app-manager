package com.erzhiqian.wechatappmanager.application.dto.platformapp;


import lombok.Data;

/**
 *
 * 第三方平台开发配置
 *
 * 参考<a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/how_to_apply.html‘>平台型第三方平台申请和上线流程</a>
 *
 * @author 二之前一
 * @CreateDate 2020年10月29日
 */
@Data
public class PlatformAppDevProfile {


    /**
     * 应用密钥
     */
    private String appSecret;

    /**
     * 消息校验token
     */
    private String token;

    /**
     * 消息加解密Key
     */
    private String encodingAESKey;

    /**
     * 数据前面方式
     */
    private String dataSignType;

    /**
     * 数据格式类型
     */
    private String dataContentType;

    /**
     * 平台业务域名
     */
    private PlatformAppDomain domain;





}
