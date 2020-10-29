package com.erzhiqian.wechatappmanager.domain.tenant;


import lombok.ToString;

/**
 * @author 二之前一
 * @CreateDate 2020年10月29日
 */
@ToString
public class Tenant {

    private String id;

    public Tenant(String id) {
        this.id = id;
    }

    public String id(){
        return id;
    }


}
