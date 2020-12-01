package com.erzhiqian.wechatappmanager.application.dto;

import lombok.Data;


/**
 * 应用账号信息
 *
 * @author 二之前一
 * @CreateDate 2020年10月29日
 */
@Data
public class NewAuthorizerInfo {


    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String headImage;

    /**
     * 原始id
     */
    private String username;

    /**
     * 主体名称
     */
    private String principalName;

}
