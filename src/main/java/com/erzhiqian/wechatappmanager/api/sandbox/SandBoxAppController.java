package com.erzhiqian.wechatappmanager.api.sandbox;


import com.erzhiqian.wechatappmanager.application.SandboxAppService;
import com.erzhiqian.wechatappmanager.application.WechatAppService;
import com.erzhiqian.wechatappmanager.application.dto.platformapp.NewPlatformApp;
import com.erzhiqian.wechatappmanager.application.dto.sandbox.NewSandBoxApp;
import com.erzhiqian.wechatappmanager.domain.tenant.Tenant;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.resolve;

/**
 * 测试号接口
 *
 * @author 二之前一
 * @CreateDate 2020年12月2日
 */

@RestController
@RequestMapping("/apps/{tenantId}/sandbox")
@Log4j2
public class SandBoxAppController {

    private SandboxAppService sandboxAppService;

    public SandBoxAppController(SandboxAppService sandboxAppService) {
        this.sandboxAppService = sandboxAppService;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public void createPlatFormApp(@PathVariable("tenantId") Tenant tenant, @RequestBody NewSandBoxApp sandBoxApp) {
        sandboxAppService.createSandbox(tenant, sandBoxApp);
    }
}
