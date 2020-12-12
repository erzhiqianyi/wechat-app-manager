package com.erzhiqian.wechatappmanager.api;

import com.erzhiqian.wechatappmanager.application.WechatAppService;
import com.erzhiqian.wechatappmanager.application.dto.NewPlatformApp;
import com.erzhiqian.wechatappmanager.application.dto.NewWechatApp;
import com.erzhiqian.wechatappmanager.domain.tenant.Tenant;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;


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

    @RequestMapping("/apps/{tenantId}/platform")
    @ResponseStatus(CREATED)
    @PostMapping
    public void createOpenPlatFomApp(@PathVariable("tenantId") Tenant tenant, @RequestBody NewPlatformApp newPlatformApp) {
        wechatAppService.createOpenPlatFomApp(tenant, newPlatformApp);
    }
}
