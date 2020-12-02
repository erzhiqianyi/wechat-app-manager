package com.erzhiqian.wechatappmanager.api;

import com.erzhiqian.wechatappmanager.application.WechatAppService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 二之前一
 * @CreateDate 2020年10月29日
 */
@RestController
@RequestMapping("/apps/{tenantId}")
@Log4j2
public class WechatAppController {

    private WechatAppService wechatAppService;

    public WechatAppController(WechatAppService wechatAppService) {
        this.wechatAppService = wechatAppService;
    }


}
