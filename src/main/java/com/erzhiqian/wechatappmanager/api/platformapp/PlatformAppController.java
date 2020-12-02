package com.erzhiqian.wechatappmanager.api.platformapp;

import com.erzhiqian.wechatappmanager.application.PlatformAppService;
import com.erzhiqian.wechatappmanager.application.dto.platformapp.NewPlatformApp;
import com.erzhiqian.wechatappmanager.domain.tenant.Tenant;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

/**
 *
 * 第三方平台应用接口
 *
 * @author 二之前一
 * @CreateDate 2020年10月29日
 */
@RestController
@RequestMapping("/apps/{tenantId}/platform")
@Log4j2
public class PlatformAppController {

    private PlatformAppService platformAppService;

    public PlatformAppController(PlatformAppService platformAppService) {
        this.platformAppService = platformAppService;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public void createPlatFormApp(@PathVariable("tenantId") Tenant tenant, @RequestBody NewPlatformApp newPlatformApp) {
        platformAppService.createPlatformApp(tenant, newPlatformApp);
    }
}
