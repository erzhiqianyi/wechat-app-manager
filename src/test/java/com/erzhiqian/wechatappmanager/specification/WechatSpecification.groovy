package com.erzhiqian.wechatappmanager.specification

import com.erzhiqian.wechatappmanager.BasicSpecification
import com.erzhiqian.wechatappmanager.application.dto.NewAppSecret
import com.erzhiqian.wechatappmanager.application.dto.NewAuthorizerInfo
import com.erzhiqian.wechatappmanager.application.dto.NewDevProfile
import com.erzhiqian.wechatappmanager.application.dto.NewWechatApp

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

class WechatSpecification extends BasicSpecification {

    def tenantId = "gh_82bdb360393c"

    protected NewAppSecret createAppSecret(String appSecret) {
        def newAppSecret = new NewAppSecret(appSecret: appSecret)
        return newAppSecret;
    }

    protected NewAuthorizerInfo createNewAuthorizerInfo(
            String nickName, String headImage, String username,
            String principalName, String appType, String certifiedState) {
        def newAuthorizerInfo = new NewAuthorizerInfo(nickname: nickName, headImage: headImage,
                username: username, principalName: principalName,
                appType: appType, certifiedState: certifiedState)
        return newAuthorizerInfo;

    }

    protected NewDevProfile createNewDevProfile(String token, String encodingAESKey,
                                                String dataSignType, String dataContentType) {
        def newDevProfile = new NewDevProfile(token: token, encodingAESKey: encodingAESKey,
                dataSignType: dataSignType, dataContentType: dataContentType);
        return newDevProfile;
    }

    def "should add platform app "() {
        given:
        def newAppSecret = createAppSecret('3d9226db5fc21c3574ab454975de8e20')
        def nickName = "test"
        def headImage = "https://wx.qlogo.cn/mmhead/Q3auHgzwzM6fHe3NhQBfH4ibsxZk8ktOXRV2Ws7dKDqnlaREKORdHNw/0"
        def username = "gh_852ad136c363"
        def principalName = "erzhiqianyi";
        def newAuthorizerInfo = createNewAuthorizerInfo(nickName, headImage, username, principalName, appType, certifiedState);
        def token = "04MzOmzVA48Q0MLHGYsD3BdD6UBbGruZ"
        def encodingAESKey = "m6qD0p1CUkQ83CMvJRMRY6V8vTAK63EZkglCsARucYJ"
        def newDevProfile = createNewDevProfile(token, encodingAESKey, dataSignType, dataContentType)
        def appId = "wx4ff4f9c7af819999"
        def newWechatApp = new NewWechatApp(appId: appId, authorizerInfo: newAuthorizerInfo,
                appSecret: newAppSecret, devProfile: newDevProfile);
        when:
        def response = post('/apps/' + tenantId, newWechatApp)

        then:
        response.statusCode == CREATED
        where:
        appType        | certifiedState | dataSignType    | dataContentType
        'SUBSCRIBE'    | 'CERTIFIED'    | 'SAFE'          | 'JSON'
        'SUBSCRIBE'    | 'CERTIFIED'    | 'SAFE'          | 'XML'
        'SUBSCRIBE'    | 'CERTIFIED'    | 'UN_SAFE'       | 'JSON'
        'SUBSCRIBE'    | 'CERTIFIED'    | 'UN_SAFE'       | 'XML'
        'SUBSCRIBE'    | 'CERTIFIED'    | 'COMPATIBILITY' | 'JSON'
        'SUBSCRIBE'    | 'CERTIFIED'    | 'COMPATIBILITY' | 'XML'
        'SUBSCRIBE'    | 'UN_CERTIFIED' | 'SAFE'          | 'JSON'
        'SUBSCRIBE'    | 'UN_CERTIFIED' | 'SAFE'          | 'XML'
        'SUBSCRIBE'    | 'UN_CERTIFIED' | 'UN_SAFE'       | 'JSON'
        'SUBSCRIBE'    | 'UN_CERTIFIED' | 'UN_SAFE'       | 'XML'
        'SUBSCRIBE'    | 'UN_CERTIFIED' | 'COMPATIBILITY' | 'JSON'
        'SUBSCRIBE'    | 'UN_CERTIFIED' | 'COMPATIBILITY' | 'XML'
        'SERVICES'     | 'CERTIFIED'    | 'SAFE'          | 'JSON'
        'SERVICES'     | 'CERTIFIED'    | 'SAFE'          | 'XML'
        'SERVICES'     | 'CERTIFIED'    | 'UN_SAFE'       | 'JSON'
        'SERVICES'     | 'CERTIFIED'    | 'UN_SAFE'       | 'XML'
        'SERVICES'     | 'CERTIFIED'    | 'COMPATIBILITY' | 'JSON'
        'SERVICES'     | 'CERTIFIED'    | 'COMPATIBILITY' | 'XML'
        'SERVICES'     | 'UN_CERTIFIED' | 'SAFE'          | 'JSON'
        'SERVICES'     | 'UN_CERTIFIED' | 'SAFE'          | 'XML'
        'SERVICES'     | 'UN_CERTIFIED' | 'UN_SAFE'       | 'JSON'
        'SERVICES'     | 'UN_CERTIFIED' | 'UN_SAFE'       | 'XML'
        'SERVICES'     | 'UN_CERTIFIED' | 'COMPATIBILITY' | 'JSON'
        'SERVICES'     | 'UN_CERTIFIED' | 'COMPATIBILITY' | 'XML'
        'MINI_PROGRAM' | 'CERTIFIED'    | 'SAFE'          | 'JSON'
        'MINI_PROGRAM' | 'CERTIFIED'    | 'SAFE'          | 'XML'
        'MINI_PROGRAM' | 'CERTIFIED'    | 'UN_SAFE'       | 'JSON'
        'MINI_PROGRAM' | 'CERTIFIED'    | 'UN_SAFE'       | 'XML'
        'MINI_PROGRAM' | 'CERTIFIED'    | 'COMPATIBILITY' | 'JSON'
        'MINI_PROGRAM' | 'CERTIFIED'    | 'COMPATIBILITY' | 'XML'
        'MINI_PROGRAM' | 'UN_CERTIFIED' | 'SAFE'          | 'JSON'
        'MINI_PROGRAM' | 'UN_CERTIFIED' | 'SAFE'          | 'XML'
        'MINI_PROGRAM' | 'UN_CERTIFIED' | 'UN_SAFE'       | 'JSON'
        'MINI_PROGRAM' | 'UN_CERTIFIED' | 'UN_SAFE'       | 'XML'
        'MINI_PROGRAM' | 'UN_CERTIFIED' | 'COMPATIBILITY' | 'JSON'
        'MINI_PROGRAM' | 'UN_CERTIFIED' | 'COMPATIBILITY' | 'XML'


    }



}
