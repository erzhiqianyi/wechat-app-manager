package com.erzhiqian.wechatappmanager.specification

import com.erzhiqian.wechatappmanager.BasicSpecification
import com.erzhiqian.wechatappmanager.application.dto.NewAuthorizerInfo
import com.erzhiqian.wechatappmanager.application.dto.NewWechatApp

import static org.springframework.http.HttpStatus.CREATED

class PlatformAppSpecification extends BasicSpecification {

    def tenantId = "gh_82bdb360393c"

    protected NewAuthorizerInfo createNewAuthorizerInfo(
            String[] authorizerInfo) {
        def newAuthorizerInfo = new NewAuthorizerInfo(
                nickname: authorizerInfo[0],
                username: authorizerInfo[1],
                principalName: authorizerInfo[2],
                headImage: authorizerInfo[3],
        )
        return newAuthorizerInfo;

    }

    def "should create platform app "() {
        given:
        def appId = "wx4ff4f9c7af819999"
        def authorizerInfo = [
                "二之前士多接口测试号",
                "gh_852ad136c363",
                "二之前一",
                "https://wx.qlogo.cn/mmhead/Q3auHgzwzM6fHe3NhQBfH4ibsxZk8ktOXRV2Ws7dKDqnlaREKORdHNw/0"
        ]
        def devProfile = [
            "3d9226db5fc21c3574ab454975de8e20",
            "HkVjaO1ZQyoDdmTab5y0w7C49XWmuQLD",
            "cHjHQKmTLmRCB24wamWRAjMVbPDV0xNX0DPz4XoLQlH",
            "SAFE",
            "XML",
            "https://erzhiqian.top",
            "https://erzhiqian.top/wechat/platform/component_verify_ticket",
            "https://erzhiqian.top/wechat/app/\$APPID\$/callback",
            "https://erzhiqian.top",
            "https://erzhiqian.top",
        ]
        def newAuthorizerInfo = createNewAuthorizerInfo(authorizerInfo)
        def platformAppDevProfile = createPlatFormDevProfile(devProfile)

    }


}
