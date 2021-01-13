package com.erzhiqian.wechatappmanager.application.dto;

import lombok.Data;

@Data
public class MiniProgramDevDomain {

    /**
     * 小程序服务器域名
     */
    private String serverDomain;

    /**
     * 小程序业务域名
     */
    private String businessDomain;


}
