package com.erzhiqian.wechatappmanager.specification

import com.erzhiqian.wechatappmanager.BasicSpecification
import com.erzhiqian.wechatappmanager.application.dto.NewAuthorizerInfo
import com.erzhiqian.wechatappmanager.application.dto.NewMpDevProfile
import com.erzhiqian.wechatappmanager.application.dto.sandbox.NewSandBoxApp
import com.erzhiqian.wechatappmanager.application.dto.sandbox.NewSandboxAppDevProfile

import static org.springframework.http.HttpStatus.CREATED

class SandboxAppSpecification extends BasicSpecification {
    def tenantId = "gh_82bdb360393c"

    protected NewAuthorizerInfo createNewAuthorizerInfo(String[] authorizerInfo) {
        return new NewAuthorizerInfo(
                nickname: authorizerInfo[0],
                username: authorizerInfo[1],
                principalName: authorizerInfo[2],
                headImage: authorizerInfo[3]
        )
    }

    protected NewSandboxAppDevProfile createNewSandboxAppDevProfile(String[] devProfile) {
        def newMpDevProfile = new NewMpDevProfile(
                appSecret: devProfile[1],
                token: devProfile[2],
                serverCallBackURL: devProfile[3],
                jsSecurityURL: devProfile[4],
                webpageAuthorizationURL: devProfile[5]
        )

        return new NewSandboxAppDevProfile(
                devStrategy: devProfile[0],
                devProfile: newMpDevProfile
        )

    }

    def "should create sandbox app" () {
        given:
        def appId = "wx4ff4f9c7af819999"

        def authorizerInfo = [
                "二之前士多接口测试号",
                "gh_852ad136c363",
                "二之前一",
                "http://mmbiz.qpic.cn/mmbiz_jpg/3GRiaGqDbnNEEYGB93KhLUaS5z7hVmLeEvRwuIaxu5Fc4CZYhdicy3sGbbLpCEfgibhXFyR9A0dXHsic59EUEibu3dg/0"
        ]

        def devProfile = [
                "WECHAT",
                "3d9226db5fc21c3574ab454975de8e20",
                "04MzOmzVA48Q0MLHGYsD3BdD6UBbGruZ",
                "https://erzhiqian.top/weixin/app/wechat/wx4ff4f9c7af819999",
                "https://erzhiqian.top",
                "https://erzhiqian.top",
        ]

        def newAuthorizerInfo = createNewNewAuthorizerInfo(authorizerInfo)

        def newSandboxAppDevProfile = createNewSandboxAppDevProfile(devProfile)

        def newSandboxApp = new NewSandBoxApp(
                appId: appId,
                authorizerInfo: newAuthorizerInfo,
                devProfile: newSandboxAppDevProfile);
        when:
        def response = post('/apps/' + tenantId+"/sandbox", newSandboxApp)
        then:
        response.statusCode == CREATED



    }


}
