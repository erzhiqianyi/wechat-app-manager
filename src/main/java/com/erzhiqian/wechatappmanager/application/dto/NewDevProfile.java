package com.erzhiqian.wechatappmanager.application.dto;


import lombok.Data;

/**
 * @author 二之前一
 * @CreateDate 2020年10月29日
 */
@Data
public class NewDevProfile {

    private String token;

    private String encodingAESKey;

    private String dataSignType;

    private String dataContentType;

    private String serverDomain;

    private String businessDomain;
}
